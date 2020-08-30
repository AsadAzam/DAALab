import java.util.*;

class MergeSort {
    void merge(ArrayList<Integer> arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l+i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m+1+j);

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using

    void sort(ArrayList<Integer> arr, int l, int r){ 
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Driver method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str_pana;
        boolean stop = false;
        
        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.print("Enter the elements of the array (Press Enter to end) : ");
        while (!stop) {
            str_pana = sc.nextLine();
            if (!str_pana.equals("")) {
                int number = Integer.parseInt(str_pana);
                arr.add(number);
            } else {
                stop = true;
            }
        } 
        // int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.print("Given Array : { ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b }");

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.size() - 1);

        System.out.print("\nSorted Array : { ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b }");
    }
}