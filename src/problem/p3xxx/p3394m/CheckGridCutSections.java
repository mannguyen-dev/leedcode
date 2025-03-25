package problem.p3xxx.p3394m;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CheckGridCutSections {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xCoordinates = new ArrayList<>();
        List<int[]> yCordinates = new ArrayList<>();

        for (int[] rectangle: rectangles){
            xCoordinates.add(new int[]{rectangle[0], 1});
            xCoordinates.add(new int[]{rectangle[2], 0});
            yCordinates.add(new int[]{rectangle[1], 1});
            yCordinates.add(new int[]{rectangle[3], 0});
        }

        Comparator<int[]> comparator = Comparator.comparingInt((int[] i) -> i[0]).thenComparingInt(y -> y[1]);
        xCoordinates.sort(comparator);
        yCordinates.sort(comparator);

        return countLineIntersections(xCoordinates) || countLineIntersections(yCordinates);
    }

    private static boolean countLineIntersections(List<int[]> coordinates) {
        int lines = 0;
        int overlap = 0;

        for (int[] cordinate : coordinates){
            if (cordinate[1] == 1){
                overlap++;
            } else {
                overlap--;
            }
            if (overlap == 0){
                lines++;
            }
        }

        return lines >= 3;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] rectangles = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        UtilityClass.logResult(checkValidCuts(n, rectangles));
    }
}
