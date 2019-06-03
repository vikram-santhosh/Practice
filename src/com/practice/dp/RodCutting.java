package com.practice.dp;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RodCutting {

    public int solve() throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int val[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int dp[][] = new int[val.length+1][n+1];
        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=n;j++) {
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else {
                    if ( j >= i){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-i] + val[i-1]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=n;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }        return dp[val.length][n];
    }

    public static void main(String args[]) throws IOException {
        RodCutting rodCutting = new RodCutting();
        rodCutting.solve();

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        IntStream.range(0,t).forEach(i -> {
            try {
                System.out.println((rodCutting.solve()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/
    }
}
