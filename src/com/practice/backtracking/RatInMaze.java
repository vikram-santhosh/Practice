package com.practice.backtracking;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Flinstone on 16-Nov-19.
 */
public class RatInMaze{
    public static ArrayList<String> printPath(int[][] m, int n)
    {
        ArrayList<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        solve(m, n, res, sb, 0, 0, '\0');
        Collections.sort(res);
        return res;
    }

    public static void solve(int[][] m, int n, ArrayList<String> res, StringBuffer sb,
                             int i, int j, char move) {
        if ( i>=0 && i<n && j >=0 && j<n && m[i][j] == 1) {
            m[i][j] = 0;
            sb.append(move);
            if (i == n-1 && j == n-1) {
                res.add(sb.toString().trim());
            }
            solve(m, n, res, sb, i-1, j, 'U' );
            solve(m, n, res, sb, i+1, j, 'D' );
            solve(m, n, res, sb, i, j-1, 'L' );
            solve(m, n, res, sb, i, j+1, 'R' );
            sb.deleteCharAt(sb.length()-1);
            m[i][j] = 1;
        }
    }
}