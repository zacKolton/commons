package commons.Utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import projectSpecific.ParsedObjects.MergeRequest;

public class MDUtils
{
    // Type can be 
    // - #
    // - ##
    // - ###
    // ...
    public static String heading(String title, String indent, String position) 
    {
        char ch='"';
        String result = indent+" <div align="+ch+"left"+ch+">"+title+"</div>";
        if(position.equals("left") || position.equals("center") || position.equals("right"))
        {
            result = indent+" <div align="+ch+position+ch+" >"+title+"</div>";
        }
        return result;
    }

    // The input names should be updated here for future projects
    // It would be cool if you could center the text between | ... |
    public static String table(ArrayList<MergeRequest> mergeRequests, JSONObject tableConfig)
    {
        String headerField = "|";
        String divideField = "|";
        String rowField    = "|";
        String divide      = ":----:";
        String col         = "|";

        JSONArray headers = tableConfig.getJSONArray("headers");
        JSONArray rowData = tableConfig.getJSONArray("row-data");

        for(int i = 0; i < headers.length(); i++)
        {
            String    headerKey     = headers.getJSONObject(i).getString("key");
                      headerField  += " "+ headers.getJSONObject(i).getString("text") + " |";
                      divideField  += " "+divide+" |";
        }

        for(int i = 0; i < rowData.length(); i++)
        {
            
        }

        // needs to be tested yet and completed
        return null;
    }

    public static String link(String s, String link) { return "["+s+"]("+link+")"; }
    public static String bullet(String s)   { return "* "+ s; }
    public static String bold(String s)     { return "**"+s+"**"; }
    public static String italic(String s)   { return "*"+s+"*"; }
    public static String quote(String s)    { return "> "+s; }
    public static String div()              { return "---"; }

}
