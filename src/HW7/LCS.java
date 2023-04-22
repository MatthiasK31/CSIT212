/*
Matthias Kim
HW7 - LCS Finder
4/10/2023
 */
package HW7;

public class LCS {
    public static int lcs_length (String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int [][] table = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) //fill the first row and column with all 0s
                    table [i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1)) // increase the value at (i, j) each time the character one row back and one column up are the same
                    table[i][j] = table[i-1][j-1]+1;
                else //otherwise set the value at (i, j) to the maximum between the value one column back or one row back
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
            }
        }
        return table[m][n]; //return the lower-rightmost value
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
        System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA",
                "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
    }
}
