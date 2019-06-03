package com.practice.strings;
import java.util.*;

public class Solution {

    class Review implements Comparable<Review>{
        int score;
        int index;
        Review(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Review o) {
            if (this.score != o.score) return  o.score - this.score;
            else return this.index - o.index;
        }
    }
    public int rankString(String str, Set<String> good) {
        List<String> arr =Arrays.asList(str.split("_"));
        int count = 0;
        for(String s : arr ) {
            if(good.contains(s)) count ++;
        }
        return count;
    }
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        Set<String> good_set = new HashSet<>(Arrays.asList(A.split("_")));
        Set<Review> reivews = new TreeSet<>();
        for( int i=0; i<B.size(); i++) {
            int score = rankString(B.get(i),good_set);
            reivews.add(new Review(score, i));
        }
        ArrayList<Integer> out = new ArrayList<>();
        for (Review r : reivews) out.add(r.index);
        return out;
    }
    public static void main (String[] args) {
    }
}