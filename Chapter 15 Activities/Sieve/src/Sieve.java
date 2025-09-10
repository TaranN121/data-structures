import java.util.*;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        Set<Integer> list = new HashSet<>();
        //Iterator<Integer> iterator = list.iterator();

        for (int i=2;i<=n;i++){
            list.add(i);

        }
        for (int p = 2; p * p <= n; p++) {
            if (list.contains(p)) {
                for (int multiple = 2 * p; multiple <= n; multiple += p) {
                    list.remove(multiple);
                }
            }
        }

        System.out.println("Primes up to " + n + ": " + list);




    }
}
