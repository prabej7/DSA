
import java.util.ArrayList;

public class HashTableP {
    class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 7;
    private Node[] dataMap;

    public HashTableP() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            System.out.println(i + ": ");
            while (temp != null) {
                System.out.printf("    {%s: %d}\n", temp.key, temp.value);
                temp = temp.next;
            }
        }
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];

            hash = (hash + asciiValue * 23) % dataMap.length;
        }

        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        Node temp = dataMap[index];

        if (dataMap[index] == null) {
            dataMap[index] = newNode;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }

        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();

        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];

            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public static void main(String[] args) {
        HashTableP ht = new HashTableP();
        ht.set("apple", 10);
        ht.set("ball", 20);
    
        ArrayList keys = ht.keys();

        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i));
        }  
    }

}