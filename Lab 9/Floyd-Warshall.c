#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

#define inf 2000000

int main() {
    long long int testcase, t, i, j, k;
    scanf(" %lli ", &testcase);
    for (t = 1; t <= testcase; t++) {
        long long int size;
        scanf(" %lli ", &size);
        long long int array[size + 1][size + 1];
        for (i = 1; i < size + 1; i++) {
            for (j = 1; j < size + 1; j++) {
                if (i != j)
                    array[i][j] = inf;
                if (i == j)
                    array[i][j] = 0;
            }
        }

        long long int queries, q, a, b, distance;
        scanf(" %lli ", &queries);

        for (q = 1; q <= queries; q++) {
            scanf(" %lli %lli ", &a, &b);

            array[a][b] = 6;
            array[b][a] = 6;
        }

        for (k = 1; k < size + 1; k++) {
            for (i = 1; i < size + 1; i++) {
                for (j = 1; j < size + 1; j++) {
                    if (array[i][k] + array[k][j] < array[i][j])
                        array[i][j] = array[i][k] + array[k][j];
                }
            }
        }

        long long int input;
        scanf(" %lli ", &input);

        for (i = 1; i < size + 1; i++) {
            if (array[input][i] != 0 && array[input][i] != inf)
                printf("%lli ", array[input][i]);
            if (array[input][i] == inf)
                printf("-1 ");
        }
        printf("\n");
    }
    return 0;
}