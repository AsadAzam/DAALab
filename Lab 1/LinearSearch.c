#include <stdio.h>

int main(){
    int a[10] = {10, 20, 34, 3, 65, 45, 11, 66, 90, 74};
    printf("Enter a number to be found : ");
    int number;
    scanf("%d", &number);
    int count = 0;
    
    int length = (int)(sizeof(a) / sizeof(a[0]));
    
    for (int i = 0; i < length; i++){
        count += 1;
        if (number == a[i]){
            printf("Number Found\n");
            break;
        }
    }
    printf("Total iterations were: %d\n", count);
    return 0;
}
