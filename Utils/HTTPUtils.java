package commons.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPUtils 
{

    public static String getResponse(String requestName, String configFile) throws JSONException, IOException
    {
        String            result     = "";
        JSONObject        gitLabInfo = FileUtils.getJSONObjectFile(configFile);
        URL               url        = new URL(gitLabInfo.getString(requestName));
        HttpURLConnection http       = (HttpURLConnection) url.openConnection();

        setRequestProperties(http, gitLabInfo.getJSONArray("props"));

        if(http.getResponseCode() == 200)
        {
            MsgUtils.message(requestName+ "\trequest was successful!");
            BufferedReader rd = new BufferedReader(new InputStreamReader(http.getInputStream(), "UTF-8"));
            result = rd.lines().collect(Collectors.joining());
        }
        else
        {
            MsgUtils.error(requestName+ "\trequest failed");
        }
        http.disconnect();
        
        return result;

    }

    private static void setRequestProperties(HttpURLConnection http, JSONArray props)
    {
        for(int i = 0; i < props.length(); i++)
        {
            String header = props.getJSONObject(i).getString("header");
            String value  = props.getJSONObject(i).getString("value");

            if(value.equals("Private-Token") || value.equals("Basic"))
            {
                String username = props.getJSONObject(i).getString("username");
                String password = props.getJSONObject(i).getString("password");
                String auth = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
                http.setRequestProperty(header, value+ " "+ auth);
            }
            else
            {
                http.setRequestProperty(header, value);
            }
        }
    }
    
}

/*
    private static JSONObject getRequest(JSONObject userInfo, String requestName)
    {
        JSONObject result = null;
        boolean done = false;
        for(int i = 0; (!done) && (i < userInfo.getJSONArray("props").length()); i++)
        {
            String tempName = userInfo.getJSONArray("requests").getJSONObject(i).getString("name");
            if(tempName.equals(requestName))
            {
                done = true;
                result = userInfo.getJSONArray("requests").getJSONObject(i);
            }
        }
        return result;
    }
*/
