package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Flinstone on 29-Oct-19.
 *  https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum1 {

    public static List<List<Integer>> solve(int arr[], int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 0;
        backtrack(arr, start, temp, res, target);
        return res;
    }

    public static void backtrack(int arr[], int start, List<Integer> temp, List<List<Integer>> res, int target) {
        if (target < 0) return;
        if (target == 0) res.add(new ArrayList<>(temp));
        else {
            for(int i=start; i<arr.length; i++) {
                temp.add(arr[i]);
                backtrack(arr, i, temp, res, target - arr[i]);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = solve(arr, target);
        res.forEach( row -> System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining())));
    }
}
