package com.practice.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Flinstone on 29-Oct-19.
 */
public class Subsets {

    public static List<List<Integer>> subsets(int arr[]) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int start = 0;
        backtrack(arr, start, temp, res);
        return res;
    }

    public static void backtrack(int arr[], int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for(int i=start; i<arr.length; i++) {
            temp.add(arr[i]);
            backtrack(arr, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1,2,3};
        List<List<Integer>> res = subsets(arr);
        res.forEach( subset -> System.out.println(subset.stream().map(String::valueOf).collect(Collectors.joining(","))));
    }
}
