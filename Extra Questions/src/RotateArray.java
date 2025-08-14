public class RotateArray {
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle cases where k > n
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        rotateLeft(array, 2);
        System.out.print("Array after left rotation by 2: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] array2 = {1, 2, 3, 4, 5, 6};
        rotateRight(array2, 2);
        System.out.print("Array after right rotation by 2: ");
        for (int num : array2) {
            System.out.print(num + " ");
        }
    }
}
