import java.util.*;

public class QuickSort {
    int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than the pivot
            if (arr.get(j) < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr.get(i+1);
        arr.set((i+1), arr.get(high));
        arr.set(high, temp);

        return i+1;
    }

    void sort(ArrayList<Integer> arr, int low, int high) { 
        if (low < high) {
            /* pi is partitioning index, arr[pi] is 
                now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    // Driver program
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
        int n = arr.size();
        
        System.out.print("Given Array : { ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b }");

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.print("\nSorted Array : { ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("\b\b }\n");
    }
}