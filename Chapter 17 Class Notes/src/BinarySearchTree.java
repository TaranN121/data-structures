public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
        
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    { 
        if(this.root == null){
            Node newNode = new Node();
        newNode.data = obj;
            this.root = newNode;
        }  
        else {}
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        this.root.addNode(newNode);
    }
    }




    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        while (current != null){
            int diff = obj.compareTo(current.data);
            if (diff == 0)
                return true;
            else if (diff < 0){
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node toBeRemoved = this.root;
        boolean found;
        Node parent = null;
        
        while (!found && toBeRemoved != null)
        {
            int diff = obj.compareTo(toBeRemoved.data);
            if (diff == 0)
                found = true;
            else if (diff < 0)
                parent = toBeRemoved;
                toBeRemoved = toBeRemoved.left;
            else
                toBeRemoved = toBeRemoved.right;
        }
        if (!found)
            return;
            
        //case 1 and case 2 (at least one child is null)
        if(toBeRemoved.left == null || toBeRemoved.right == null){
            Node newChild;

            if (toBeRemoved.left == null){
                newChild = toBeRemoved.right;
            }
            else{
                newChild = toBeRemoved.left;
            }

            if (parent == null){
                this.root = newChild;
            }
            else{
                parent.right = newChild;
                return;
            }
            Node leastParent = toBeRemoved;
            Node least = toBeRemoved.right;
            while (least.left != null){
                leastParent = least;
                least = least.left;
            }
            //move the data to the node being removed
            toBeRemoved.data = least.data;

            //unlink the least child
            if (leastParent == toBeRemoved){
                leastParent.right = least.right;
            }
            else[
                leastParent.left = least.right;

            ]
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(this.root)
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if (parent == null){
            return;
        }
        print(parent.left);
        System.out.println(parent.data+" ");
        print(parent.right);

    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        // A binary search tree must be made of comparable objects
        public Comparable data;
       
        public Node left;
        public Node right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            //if diff  < 0, newNode is to the left of this node
            //if diff > 0, newNode is to the right of this node
            int diff = newNode.data.compareTo(this.data);

           if (diff < 0){
                if(left == null)
                    left = newNode;
                else    {
                    left.addNode(newNode);
                }
            }
            else if (diff > 0)
            {
                if (right == null){
                    right = newNode;
                }
                else
                    right.addNode(newNode);
            } 
                
           }public void preorder(Visitor v){
            Tree.preorder(this.root,v);
           }
           public interface Visitor{
            void visit(Object data);
            }

            public static void preorder(Node n,Visitor v){

            }
        }




