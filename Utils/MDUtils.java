package commons.Utils;

import java.util.ArrayList;

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

    public static String table(ArrayList<MergeRequest> mergeRequests)
    {
        
        return null;
    }

    public static String link(String s, String link) { return "["+s+"]("+link+")"; }
    public static String bullet(String s)   { return "* "+ s; }
    public static String bold(String s)     { return "**"+s+"**"; }
    public static String italic(String s)   { return "*"+s+"*"; }
    public static String quote(String s)    { return "> "+s; }
    public static String div()              { return "---"; }

}
