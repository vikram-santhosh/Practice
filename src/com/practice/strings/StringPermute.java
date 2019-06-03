package com.practice.strings;

import java.util.*;

public class StringPermute {
    public List<String> permute(char[] input) {
        Map<Character,Integer> countMap = new TreeMap<>();
        for(char ch: input) {
            countMap.compute(ch, (key, value) -> {
                if(value == null) return 1;
                else return value + 1;
            });
        }
        int[] count = new int[countMap.size()];
        char[] str = new char[countMap.size()];
        char[] result = new char[input.length];

        List<String> resultList = new ArrayList<>();
        int idx = 0;
        for(Map.Entry<Character,Integer> entry : countMap.entrySet()) {
            str[idx] = entry.getKey();
            count[idx] = entry.getValue();
            idx ++;
        }

        permuteUtil(str, count, result, resultList, 0);
        return resultList;

    }

    public void permuteUtil(char[] str, int[] count, char[] result, List<String> resultList, int level){
        if(level == result.length) {
            resultList.add(new String(result));
            return;
        }
        for(int i=0;i<count.length;i++) {
            if(count[i] != 0) {
                result[level] = str[i];
                count[i] --;
                permuteUtil(str, count, result, resultList, level+1);
                count[i] += 1;
            }
        }

    }
    public static void main(String args[]) {
        StringPermute permuteObj = new StringPermute();
        List<String> result = permuteObj.permute("abc".toCharArray());
        result.forEach(i -> System.out.println(i));
    }
}
