
import java.util.Arrays;

public class MergeSort {
    private static int[] merge(int[] array1, int[] array2) {
        int combined[] = new int[array1.length + array2.length];
        int index = 0, i = 0, j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                index++;
                i++;
            } else {
                combined[index] = array2[j];
                index++;
                j++;
            }
        }

        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }

        while (j < array2.length) {
            combined[index] = array2[j];
            index++;
            j++;
        }

        return combined;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int array[] = { 5, 4, 7, 1, 3, 2, 8, 6 };
        System.out.println(Arrays.toString(mergeSort(array)));
    }

}