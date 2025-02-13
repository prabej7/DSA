import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        swap(array, pivotIndex, swapIndex);
        return swapIndex;

    }

    private static int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);

            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }

        return array;
    }

    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int array[] = { 4, 6, 1, 7, 3, 2, 5 };

        System.out.println(Arrays.toString(quickSort(array)));
    }
}