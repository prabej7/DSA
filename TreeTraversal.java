import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (temp.value == newNode.value) {
                return false;
            }

            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }

                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }

                temp = temp.right;
            }
        }

    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }

    public ArrayList<Integer> DFSPreorder(){
        ArrayList<Integer> results = new ArrayList<>();
        
        class Traverse{

            public Traverse(Node currentNode) {
                results.add(currentNode.value);

                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }

                if(currentNode.right!=null){
                    new Traverse(currentNode.right);
                }
            }
            
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            public Traverse(Node currentNode){
                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }

                if(currentNode.right!=null){
                    new Traverse(currentNode.right);
                }

                results.add(currentNode.value);
            }
        }
        new Traverse(root);

        return results;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            public Traverse(Node currentNode){
                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }

                results.add(currentNode.value);

                if(currentNode.right!=null){
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public static void main(String[] args) {
        BFS tree = new BFS();

        int nodes[] = { 47, 21, 76, 18, 27, 52, 82 };

        for (int nums : nodes) {
            tree.insert(nums);
        }

        System.out.println(tree.DFSInOrder());
    }

}
