import java.io.IOException;

public class MergeSort_Main {
    public static void main(String[] args) throws IOException {
        int[] arr = MergeSort_Methods.input_list();

        System.out.println("Първоначален масив:");
        MergeSort_Methods.print_list(arr);

        long inversionCount = MergeSort_Methods.merge_sort(arr, 0, arr.length - 1);

        System.out.println("Сортиран масив:");
        MergeSort_Methods.print_list(arr);

        System.out.println("Брой инверсии: " + inversionCount);
    }
}