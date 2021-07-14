package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class FileUtils 
{
    public static String getFile(String f) throws IOException
    {
        File            file   = new File(f);
        FileInputStream fis    = new FileInputStream(file);
        String          str    = "";
        byte[]          data   = new byte[(int) file.length()];

        fis.read(data);
        fis.close();
        str      = new String(data, "UTF-8");

        return str;
    }

    public static JSONArray getJSONArrayFile(String f) throws IOException
    {
        File            file   = new File(f);
        FileInputStream fis    = new FileInputStream(file);
        String          str    = "";
        byte[]          data   = new byte[(int) file.length()];

        fis.read(data);
        fis.close();
        str      = new String(data, "UTF-8");

        return new JSONArray(str);
    }

    public static JSONObject getJSONObjectFile(String f) throws IOException
    {
        File            file   = new File(f);
        FileInputStream fis    = new FileInputStream(file);
        String          str    = "";
        byte[]          data   = new byte[(int) file.length()];

        fis.read(data);
        fis.close();
        str      = new String(data, "UTF-8");

        return new JSONObject(str);
    }
    
}
