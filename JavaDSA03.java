public class ArrayUtilities {

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverses the array in-place
    static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    // Sorts the array of 0s and 1s using two passes
    static void sortZeroOne(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value == 0) {
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < count ? 0 : 1;
        }

        printArray(arr);
    }

    // Sorts the array of 0s and 1s using a single loop
    static void sortZeroOneInOneLoop(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 1 && arr[right] == 0) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] == 0) left++;
            if (arr[right] == 1) right--;
        }

        printArray(arr);
    }

    // Sorts array to place even numbers on left and odd on right
    static void sortOddEven(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 != 0 && arr[right] % 2 == 0) {
                swap(arr, left, right);
                left++;
                right--;
            }
            if (arr[left] % 2 == 0) left++;
            if (arr[right] % 2 != 0) right--;
        }

        printArray(arr);
    }

    // Returns sorted squares of elements in the array
    static void sortSquares(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int[] ans = new int[n];
        int k = 0;

        while (left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k++] = arr[left] * arr[left];
                left++;
            } else {
                ans[k++] = arr[right] * arr[right];
                right--;
            }
        }

        reverseArray(ans); // To get increasing order
        printArray(ans);
    }

    public static void main(String[] args) {
        int[] binaryArray = {0, 1, 0, 1, 0, 1, 0, 1, 0};
        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Original binary array:");
        printArray(binaryArray);

        System.out.println("Sorted 0s and 1s (2-pass):");
        sortZeroOne(binaryArray.clone());

        System.out.println("Sorted 0s and 1s (1-pass):");
        sortZeroOneInOneLoop(binaryArray.clone());

        System.out.println("Sorted odd and even:");
        sortOddEven(numberArray.clone());

        System.out.println("Sorted squares:");
        sortSquares(numberArray.clone());
    }
}
