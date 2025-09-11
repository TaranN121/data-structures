import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /* the Map interface is generic 
         * the first type given is he key
         * the second type given is the value
         */
        Map<String, Color> favColors = new HashMap<>();
        
        //add elements to the map using put
        //cant have two keys that are duplicates. It will replace the value.
        favColors.put("Sreeram", Color.GREEN);
        favColors.put("Kaitlyn", Color.GREEN);
        favColors.put("Lebron", Color.YELLOW);
        favColors.put("Nimai", Color.BLACK);

        //create a set of the keys in a map

        Set<String> keys = favColors.keySet();
        for (String key: keys){
            //[name] ([hasCode]): [color]
            System.out.println(key + "("+key.hashCode()+"): "+favColors.get(key));
        }



    }
}
