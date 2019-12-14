package com.practice.backtracking;

/**
 * Created by Flinstone on 17-Nov-19.
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Flinstone on 17-Nov-19.
 */
public class AllQueens {


    public static boolean validate(int x, int y, List<Integer> cols) {
        for (int i=0; i<cols.size(); i++) {
            int row = i;
            int col = cols.get(i);
            if ( row == x || col == y || x+y ==  col+row || x-y == row-col )
                return false;
        }
        return true;
    }
    public static Set<List<Integer>> findNQueens (int n) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> colPos = new ArrayList<>();
        solve(n, 0, colPos, res);
        return res;
    }

    public static boolean solve(int n, int row, List<Integer> colPos, Set<List<Integer>> res) {
        if (row == n) {
            res.add(new ArrayList<>(colPos));
            return true;
        }
        for(int col=0; col<n; col++) {
            if (validate(row, col, colPos)) {
                colPos.add(col);
                if (solve(n, row+1, colPos, res)) {
                    return true;
                }
                colPos.remove(colPos.size()-1);
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            Set<List<Integer>> positions = findNQueens(n);
            positions.forEach(res -> {
                String out = res.stream().map(i -> String.valueOf(i+1)).collect(Collectors.joining(" "));
                System.out.println("["+ out +"]");
            });
        }
    }
}
