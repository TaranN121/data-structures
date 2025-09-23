import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    private static class Pair {
        int row, col;
        Pair(int r, int c) { row = r; col = c; }
    }

    public void floodfill(int row, int column)
    {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, column));
        int fillNumber = 1;

        while (!stack.isEmpty())
        {
            Pair p = stack.pop();

           
            if (p.row >= 0 && p.row < SIZE && p.col >= 0 && p.col < SIZE && pixels[p.row][p.col] == 0)
            {
              
                pixels[p.row][p.col] = fillNumber++;

             
                stack.push(new Pair(p.row - 1, p.col)); 
                stack.push(new Pair(p.row, p.col + 1)); 
                stack.push(new Pair(p.row + 1, p.col)); 
                stack.push(new Pair(p.row, p.col - 1)); 
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }

    public static void main(String[] args)
    {
        java.util.Scanner input = new java.util.Scanner(System.in);
        Grid g = new Grid();

        System.out.print("Enter starting row (0-9): ");
        int row = input.nextInt();
        System.out.print("Enter starting column (0-9): ");
        int col = input.nextInt();

        g.floodfill(row, col);
        System.out.println(g);
    }
}
