public class BinarySearchTree {
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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int nodes[] = { 47, 21, 76, 18, 27, 52, 82 };

        for (int nums : nodes) {
            tree.insert(nums);
        }

        System.out.println(tree.contains(19));
    }

}