package selfpractice.sorting;

import org.apache.commons.lang3.ArrayUtils;

import common.InputReader;

public class QuickSort {

    private QuickSort() {}

    public static void main(String[] args) {
        int[] array = InputReader.readIntArray();
        sort(array);
        System.out.println(ArrayUtils.toString(array));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                //swap
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        //swap
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;

        return i;
    }

}
