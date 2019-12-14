package com.practice.backtracking;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Flinstone on 17-Nov-19.
 */
public class NQueens {

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean validate(int x, int y, List<Position> positions) {
        for (Position position : positions) {
            if ( position.x == x || position.y == y || position.x + position.y ==  x+y || position.x - position.y == x-y )
                return false;
        }
        return true;
    }
    public static List<Position> findNQueens (int n) {
        List<Position> positions = new ArrayList<>();
        solve(n, 0, positions);
        return positions;
    }

    public static boolean solve(int n, int row, List<Position> positions) {
        if (row == n) {
            return true;
        }
        for(int col=0; col<n; col++) {
            if (validate(row, col, positions)) {
                positions.add(new Position(row, col));
                if (solve(n, row+1, positions)) {
                    return true;
                }
                positions.remove(positions.size()-1);
            }

        }
        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();

            List<Position> positions = findNQueens(n);

            positions.forEach(position -> System.out.println(position.x + "," + position.y));
        }
    }
}
