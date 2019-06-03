package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubSeq {

    public static String solve(char[] str_1, char[] str_2) {
        int m = str_1.length, n = str_2.length;
        int dp[][] = new int[m+1][n+1];
        int max = -1;
        for(int i=0 ; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if (i==0 || j == 0) dp[i][j] = 0;
                else if ( str_1[i-1] == str_2[j-1] ) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
                else dp[i][j] = Math.max (dp[i][j-1], dp[i-1][j] );
            }
        }
/*        for(int i=0 ; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }*/
        int i=m, j=n;
        StringBuffer res = new StringBuffer();
        while (i !=0  &&  j !=0 ) {
            if (str_1[i-1] == str_2[j-1]) {
                res.append(str_1[i-1]);
                i -= 1;
                j -= 1;
            } else {
                if (dp[i][j] == dp[i-1][j]) i-= 1;
                else if( dp[i][j] == dp[i][j-1]) j-=1;
            }
        }

        return res.reverse().toString();
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0) {
            String vals[] = br.readLine().split("\\s+");
            int m =  Integer.parseInt(vals[0]);
            int n =  Integer.parseInt(vals[1]);
            String str_1 = br.readLine();
            String str_2 =  br.readLine();
            System.out.println(solve(str_1.toCharArray(), str_2.toCharArray()).length());
        }

    }
}
