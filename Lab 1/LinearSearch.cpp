#include <iostream>

using namespace std;

int main(){
    int a[10] = {10, 20, 34, 3, 65, 45, 11, 66, 90, 74};
    cout<<"Enter a number to be found : ";
    int number;
    cin>>number;
    int count = 0;

    int length = (int)(sizeof(a) / sizeof(a[0]));

    for (int i = 0; i < length; i++){
        count += 1;
        if (number == a[i]){
            cout<<"Number Found"<<endl;
            break;
        }
    }
    cout<<"Total iterations were: "<<count<<endl;
    return 0;
}