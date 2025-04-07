import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class MergeSort_Methods {
    public static int[] input_list() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Дайте брой на числата в масива: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Дайте числата за масива:");

        int[] arr = new Random().ints(n, 1, 100).toArray();
        return arr;
    }

    public static void print_list(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static long merge_sort(int[] arr, int left, int right) {
        long inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            inversionCount += merge_sort(arr, left, mid);        
            inversionCount += merge_sort(arr, mid + 1, right); 
            inversionCount += merge(arr, left, mid, right);  
        }
        return inversionCount;
    }


    private static int merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        int inversionCount = 0;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                inversionCount += (mid + 1) - (left + i);
                arr[k] = R[j];
                j++;
            }
            k++;
        }

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

        return inversionCount;
    }
}
