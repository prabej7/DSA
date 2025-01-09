
import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index) {
        int maxValue = index;
        while (true) {
            int leftIndex = leftChild(maxValue);
            int rightIndex = rightChild(maxValue);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxValue)) {
                maxValue = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxValue)) {
                maxValue = rightIndex;
            }

            if (index != maxValue) {
                swap(index, maxValue);
                index = maxValue;
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int nodes[] = { 99, 72, 61, 58 };
        for (int i : nodes) {
            heap.insert(i);
        }

        System.out.println(heap.getHeap());

        heap.insert(100);
        heap.remove();
        System.out.println(heap.getHeap());

    }

}