import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> f = strings.listIterator();
        ListIterator<String> b = strings.listIterator(strings.size());

        int mid = strings.size() / 2;
        for (int i = 0; i < mid; i++) 
        {
            String front = f.next();
            String back = b.previous();

            f.set(back);
            b.set(front);
        }
    }
}
        
    
