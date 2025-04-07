import java.util.Arrays;
import java.util.Random;

public class MergeSort_Methods {

    public static void runPerformanceTests() {
        int[] sizes = {1000, 10_000, 100_000, 1_000_000};

        System.out.printf("%-15s%-25s%-25s%n", "Брой елементи", "Време MergeSort (ms)", "Време Arrays.sort (ms)");

        for (int size : sizes) {
            int[] original = generateRandomArray(size);

            // Merge Sort n
            int[] arrMerge = Arrays.copyOf(original, original.length);
            long startTime = System.nanoTime();
            merge_sort(arrMerge, 0, arrMerge.length - 1);
            long endTime = System.nanoTime();
            long durationMerge = (endTime - startTime) / 1_000_000;

            int[] arrJavaSort = Arrays.copyOf(original, original.length);
            startTime = System.nanoTime();
            Arrays.sort(arrJavaSort);
            endTime = System.nanoTime();
            long durationJava = (endTime - startTime) / 1_000_000;

            System.out.printf("%-15d%-25d%-25d%n", size, durationMerge, durationJava);
        }
    }

    // Случайно
    private static int[] generateRandomArray(int n) {
        return new Random().ints(n, 1, 1_000_000).toArray();
    }

    // печат
    public static void print_list(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // рекурсия
    public static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid);
            merge_sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];


        // rigth left copy

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        //copy na elementite
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
