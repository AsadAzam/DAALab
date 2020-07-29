import java.util.*;
class LinearSearch{
    public static void main(String Args[]){
        int a[] = {10, 20, 34, 3, 65, 45, 11, 66, 90, 74};
        System.out.println("Enter a number to be found");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;

        for (int i=0; i<a.length; i++){
            count += 1;
            if(number==a[i]){
                System.out.println("Number Found");
                break;
            }
        }
        System.out.println("Total iterations were: " +count);
    }
}