import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
            Stack<String> stack = new Stack<>();
            boolean properlyNested = true;

            while (in.hasNext() && properlyNested)
            {
                String tag = in.next();

                if (!tag.startsWith("</")) 
                {
                    stack.push(tag);
                }
                else 
                {
                    if (stack.isEmpty())
                    {
                        properlyNested = false;
                        break;
                    }

                    String openTag = stack.pop();
                    String expectedCloseTag = "</" + openTag.substring(1);
                    if (!tag.equals(expectedCloseTag))
                    {
                        properlyNested = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty())
                properlyNested = false;

            if (properlyNested)
                System.out.println("tags are properly nested");
            else
                System.out.println("tags are not properly nested");

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }
}
