// Given three integers x, y, and z, the task is to find the sum of all the numbers formed by
// having 4 at most x times, having 5 at most y times, and having 6 at most z times as a digit.

// source:- https://practice.geeksforgeeks.org/problems/number-formation3506/1


package excercise.matrix;

public class SumOfNumberForms {
    public static void main(String[] args) {
        int X = 1;
        int Y = 1;
        int Z = 1;

        SumOfNumberFormsSolution s1 = new SumOfNumberFormsSolution();

        System.out.println(s1.getSum(X,Y,Z));
    }
}


class SumOfNumberFormsSolution {

    public int getSum(int x, int y, int z) {
        int mod = 1000000007;

        // exactsum[i][j][k] stores the sum of
        // all the numbers having exact
        // i 4's, j 5's and k 6's
        long exactsum[][][] = new long[x + 1][y + 1][z + 1];

        // exactnum[i][j][k] stores numbers
        // of numbers having exact

        // i 4's, j 5's and k 6's
        long exactnum[][][] = new long[x + 1][y + 1][z + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    exactsum[i][j][k] = 0;
                    exactnum[i][j][k] = 0;
                }
            }
        }

        long ans = 0L;
        exactnum[0][0][0] = 1L;

        for (int i = 0; i <= x; ++i) {
            for (int j = 0; j <= y; ++j) {
                for (int k = 0; k <= z; ++k) {

                    // Computing exactsum[i][j][k]
                    // as explained above
                    if (i > 0) {
                        exactsum[i][j][k] += (exactsum[i - 1][j][k] * 10 +
                                4 * exactnum[i - 1][j][k]) %
                                mod;
                        exactnum[i][j][k] += exactnum[i - 1][j][k] % mod;
                    }
                    if (j > 0) {
                        exactsum[i][j][k] += (exactsum[i][j - 1][k] * 10 +
                                5 * exactnum[i][j - 1][k]) %
                                mod;
                        exactnum[i][j][k] += exactnum[i][j - 1][k] % mod;
                    }
                    if (k > 0) {
                        exactsum[i][j][k] += (exactsum[i][j][k - 1] * 10 +
                                6 * exactnum[i][j][k - 1]) %
                                mod;
                        exactnum[i][j][k] += exactnum[i][j][k - 1] % mod;
                    }

                    ans += exactsum[i][j][k] % mod;
                    ans %= mod;
                }
            }
        }

        return (int)ans;
    }
}