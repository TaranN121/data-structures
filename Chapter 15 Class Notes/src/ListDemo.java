import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*the addLast method can be used to populate a list */
        LinkedList<String> staff = new LinkedList <>();
        staff.addLast("Lebron");
        staff.addLast("Dwyane");
        staff.addLast("Kyrie");
        staff.addLast("Anthony");

        System.out.println(staff);

        //the list is currently Lebron, Dwyane, Kyrie, Anthony
        /*
         * the listIterator method creates a new list iterator
         * that is positioned at the head of the list
         * the | is used to represent the iterator position
         */

         ListIterator<String> iterator = staff.listIterator();  //  |Lebron, Dwyane, Kyrie, Anthony
        
         /* the next method advances the iterator OVER the next element in the list */
         iterator.next(); //Lebron,| Dwyane, Kyrie, Anthony

         /* The next method returns the element that the iterator passes over */
         String nba = iterator.next();
         System.out.println(nba); // prints Dwyane

    }
}
