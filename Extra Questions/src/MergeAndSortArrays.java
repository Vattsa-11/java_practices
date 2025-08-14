import java.util.Arrays;

public class MergeAndSortArrays {
    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;

        for (int num : arr1) {
            merged[i++] = num;
        }
        for (int num : arr2) {
            merged[i++] = num;
        }

        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 2, 8};
        int[] array2 = {4, 7, 1};

        int[] mergedArray = mergeAndSort(array1, array2);

        System.out.print("Merged and sorted array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}
