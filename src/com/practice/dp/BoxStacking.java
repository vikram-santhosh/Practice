package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BoxStacking {

    public static int solve(Box[] boxes) {
        Box rotBox[] = rotate(boxes);
        int n = rotBox.length;
        Arrays.sort(rotBox);

        int stackHeight[] = new int[n];
        for(int i=0;i<n;i++) {
            stackHeight[i] = rotBox[i].height;
        }

        int max = -1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(rotBox[i].length < rotBox[j].length && rotBox[i].width < rotBox[j].width) {
                    stackHeight[i] = Math.max(stackHeight[j] + rotBox[i].height, stackHeight[i]);
                    max = Math.max(stackHeight[i], max);
                }
            }
        }
        return max;

    }

    public static Box[] rotate(Box[] boxes) {
        Box rotBox[] = new Box[3 * boxes.length];
        for(int i=0;i<boxes.length;i++) {
            Box box = boxes[i];
            rotBox[3*i] = new Box(box.height, Math.max(box.length, box.width), Math.min(box.length, box.width));
            rotBox[3*i + 1] = new Box(box.width, Math.max(box.length, box.height), Math.min(box.length, box.height));
            rotBox[3*i + 2] = new Box(box.length, Math.max(box.width, box.height), Math.min(box.width, box.height));
        }
        return rotBox;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
            List<Box> boxes = new ArrayList<>();
            for(int i=0; i<n*3; i+=3) {
                boxes.add(new Box(arr[i], arr[i+1], arr[i+2]));
            }
            System.out.println(solve(boxes.toArray(new Box[n])));
        }


    }
}

class Box implements Comparable<Box> {
    int height;
    int length;
    int width;
    int area;

    public Box(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.area = this.length * this.width;
    }

    @Override
    public int compareTo(Box o) {
        if(this.area > o.area) return  -1;
        else if (this.area < o.area) return 1;
        else return 0;
    }
}
