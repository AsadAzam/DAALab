#include <iostream.h>
#include <conio.h>

void main() {
    clrscr();
    int i, k, a[10], c[10], n, l;
    cout << "Enter the no. of elements\t";
    cin >> n;
    cout << "\nEnter the sorted elments for optimal merge pattern";
    for (i = 0; i < n; i++) {
        cout << "\t";
        cin >> a[i];
    }
    i = 0;
    k = 0;
    c[k] = a[i] + a[i + 1];
    i = 2;
    while (i < n) {
        k++;
        if ((c[k - 1] + a[i]) <= (a[i] + a[i + 1])) {
            c[k] = c[k - 1] + a[i];
        }
        else {
            c[k] = a[i] + a[i + 1];
            i = i + 2;
            while (i < n) {
                k++;
                if ((c[k - 1] + a[i]) <= (c[k - 2] + a[i])) {
                    c[k] = c[k - 1] + a[i];
                }
                else {
                    c[k] = c[k - 2] + a[i];
                }
                i++;
            }
        }
        i++;
    }
    k++;
    c[k] = c[k - 1] + c[k - 2];
    cout << "\n\nThe optimal sum are as follows......\n\n";
    for (k = 0; k < n - 1; k++) {
        cout << c[k] << "\t";
    }
    l = 0;
    for (k = 0; k < n - 1; k++) {
        l = l + c[k];
    }
    cout << "\n\n The external path length is ......" << l;
    getch();
}