/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        System.out.println(list);
        System.out.println("Removed: " + list.removeFirst());
        System.out.println(list);
        System.out.println("First element: " + list.getfirst());
        System.out.println(list);
    }
}
