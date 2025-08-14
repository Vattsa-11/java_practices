public class ReverseArray {
    public static void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        reverse(array);

        System.out.print("Reversed array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}