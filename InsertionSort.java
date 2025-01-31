public class InsertionSort {

    public static void sort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j > -1 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int array[] = { 4, 2, 6, 5, 1, 3 };

        sort(array);

        for(int i: array){
            System.out.printf("%d\t",i);
        }
    }

}