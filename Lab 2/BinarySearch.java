import java.util.*;
class BinarySearch { 
    int binarySearch(int arr[], int x) { 
        int first = 0, last = arr.length - 1; 
        while (first <= last) { 
            int mid = first + (last - first) / 2; 

            // Check if x is present at mid 
            if (arr[mid] == x) 
                return mid; 

            // If x greater, ignore left half 
            if (arr[mid] < x) 
                first = mid + 1; 

            // If x is smaller, ignore right half 
            else
                last = mid - 1; 
        } 
        // if we reach here, then element was not present 
        return -1; 
    } 

    // Driver method to test above 
    public static void main(String args[]) { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 2, 3, 4, 10, 40 }; 
        int n = arr.length; 
        System.out.print("Enter a number : "); // O(1)
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(); 
        int result = ob.binarySearch(arr, number); 
        if (result == -1) 
            System.out.println("Number not present"); 
        else
            System.out.println("Number found at index : " + result); 
    } 
}