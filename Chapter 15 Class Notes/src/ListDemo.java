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

         /* The add method inserts an element at the iterator position 
          * The iterator is then positioned AFTER the element that was added
         */
        iterator.add("Kevin");//Lebron, Dwyane, Kyrie, Kevin, Anthony
        iterator.add("Luka"); // Lebron, Dwyane, Kevin, Luka, Kyrie,| Anthony
        System.out.println(staff);

        //remove method can only be called after calling next or previous
        //iterator.remove(); this line would cause am IllegalStateException
        iterator.next();//Lebron, Dwyane, Kevin, Luka, Kyrie,| Anthony
        iterator.remove();//Luka removed

        System.out.println(staff);

        /* The set methpd updates the element returned by the last call to next or previous */
        iterator.previous();//Lebron, Dwyane, Kevin, |Luka, Anthony
        iterator.set("Austin");//Luka replaced with Austin
        System.out.println(staff);

        /* the hasNext method is used to determine if there is a next node after the iterator.
        the hasNext is often used in the condition of a while loop
         */

         iterator = staff.listIterator();////Lebron, Dwyane, Kevin, Luka, Anthony
         while(iterator.hasNext())
         {
            String n = iterator.next();
            if (n.equals("Anthony"))//Lebron, Dwyane, Kevin, Luka, Anthony|
                iterator.remove();//Lebron, Dwyane, Kevin, Luka|

         }
         for (String n: staff)
         {
            System.out.print(n+ " ");
         }
         System.out.println();

         iterator = staff.listIterator();
         while (iterator.hasNext())
         {
            String n = iterator.next();
            if (n.equals("Kevin"))
                staff.remove("Kevin");
         }
         System.out.println(staff);

       //  for(String n:staff){
           // if( n.equals("Dwyane"))
              //  iterator.add(" lakers");
      //   }
        // System.out.println(staff);
    }
}
