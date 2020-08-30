#include <stdio.h>

int binarySearch(int arr[], int first, int last, int x) { 
    if (last >= first) { 
        int mid = first + (last - first) / 2; 
  
        // Check if x is present at mid 
        if (arr[mid] == x) 
            return mid; 
  
        // If x greater, ignore left half
        if (arr[mid] > x) 
            return binarySearch(arr, first, mid - 1, x); 
  
        // If x is smaller, ignore right half
        return binarySearch(arr, mid + 1, last, x); 
    } 
    // if we reach here, then element was not present
    return -1; 
} 
  
int main(void) { 
    int arr[] = { 2, 3, 4, 10, 40 }; 
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Enter a number to be found : ");
    int number;
    scanf("%d", &number);
    int result = binarySearch(arr, 0, n - 1, number);
    if (result == -1)
        printf("Element is not present in array\n");
    else 
        printf("Element is present at index : %d\n", result); 
    return 0; 
} 