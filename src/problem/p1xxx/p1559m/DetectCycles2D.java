package problem.p1xxx.p1559m;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class DetectCycles2D {
    private static class Point {
        private int x;
        private int y;
        private int val;

        Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public boolean valEquals(Point p){
            return this.val == p.val;
        }

        @Override
        public boolean equals(Object p){

            return (this.val == ((Point) p).val && this.x == ((Point) p).x && this.y == ((Point) p).y);
        }
    }

    public static boolean containsCycle(char[][] grid) {
        int gridRow = grid.length;
        int gridCol = grid[0].length;
        boolean[][] tempTbl = new boolean[gridRow][gridCol];

        List<Point> paths = new ArrayList<>();

        for (int i = 0; i < tempTbl.length; i++){
            for (int j = 0; j < tempTbl[0].length; j++){
                if (tempTbl[i][j]){
                    continue;
                } else {
                    paths = new ArrayList<>();
                    Point current = new Point(i, j, grid[i][j]);
                    paths.add(current);
                    boolean rs = dfs(grid, current, current, paths, tempTbl);
                    if (rs) return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, Point current, Point prev, List<Point> paths, boolean[][] tempTbl){
        tempTbl[current.x][current.y] = true;
        // go up
        if (current.y - 1 >= 0) {
            Point upPoint = new Point(current.x, current.y - 1, grid[current.x][current.y - 1]);
            if (!upPoint.equals(prev) && upPoint.valEquals(current)) {
                if (paths.contains(upPoint)) {
                    return true;
                }
                paths.add(upPoint);
                dfs(grid, upPoint, current, paths, tempTbl);
            }
        }

        // go down
        if (current.y + 1 < grid.length) {
            Point downPoint = new Point(current.x, current.y + 1, grid[current.x][current.y + 1]);
            if (!downPoint.equals(prev) && downPoint.valEquals(current)) {
                if (paths.contains(downPoint)) {
                    return true;
                }
                paths.add(downPoint);
                dfs(grid, downPoint, current, paths, tempTbl);
            }
        }

        // go right
        if ( current.x + 1 < grid[0].length) {
            Point rightPoint = new Point(current.x + 1, current.y, grid[current.x + 1][current.y]);
            if (!rightPoint.equals(prev) && rightPoint.valEquals(current)) {
                if (paths.contains(rightPoint)) {
                    return true;
                }
                paths.add(rightPoint);
                dfs(grid, rightPoint, current, paths, tempTbl);
            }
        }

        // go left
        if (current.x - 1 >= 0) {

            Point leftPoint = new Point(current.x - 1, current.y, grid[current.x - 1][current.y]);
            if (!leftPoint.equals(prev) && leftPoint.valEquals(current)) {
                if (paths.contains(leftPoint)) {
                    return true;
                }
                paths.add(leftPoint);
                dfs(grid, leftPoint, current, paths, tempTbl);
            }
        }

        return false;
    }

    static void main() {
        char[][] grid = {{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}};
        UtilityClass.logResult(containsCycle(grid));
    }
}
