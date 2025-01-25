public class RecursiveBST {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public  Node root;

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            rInsert(root, value);
        }
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else if (value > currentNode.value) {
            return rContains(currentNode.right, value);
        }

        return false;
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                currentNode = null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, value);
            }
        }
        return currentNode;
    }

    public Node deleteNode(int value) {
        return deleteNode(root, value);
    }

    public static void main(String[] args) {
        RecursiveBST bst = new RecursiveBST();

        int nodes[] = { 47, 21, 76, 18, 27, 52, 82 };

        for(int i: nodes){
            bst.rInsert(i);
        }

        System.out.println(bst.root.left.right.value);

        System.out.println(bst.deleteNode(27).value);
        System.out.println(bst.rContains(27));
    }
}
