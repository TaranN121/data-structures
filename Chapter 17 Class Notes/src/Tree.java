import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;

    static class Node
    {
        private List<Node> children;
        private Object data;


        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */

        public int size()
        {
            int total = 1;
            for (Node child : children)
            {
                total += child.size();
            }            
            return total;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<Node>(); 
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return root.size();
    }

public void depthFirst()
{
    System.out.print("Depth-first traversal: ");
    depthFirst(root);
    System.out.println();
}

private void depthFirst(Node node)
{
    if (node == null) 
        return;
    System.out.print(node.data + " ");     
    for (Node child : node.children)       
    {
        depthFirst(child);
    }
}


public void postorder()
{
    System.out.print("Postorder traversal: ");
    postorder(root);
    System.out.println();
}

private void postorder(Node node)
{
    if (node == null) 
        return;
    for (Node child : node.children)        
     postorder(child);

    System.out.print(node.data + " ");      
}


}
