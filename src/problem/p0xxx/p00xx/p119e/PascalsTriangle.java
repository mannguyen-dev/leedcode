package problem.p0xxx.p00xx.p119e;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 0; i < rowIndex; i++){
            List<Integer> nextRow = new ArrayList<>(Collections.nCopies(res.size() + 1, 0));
            for (int j = 0; j < res.size(); j++){
                nextRow.set(j, nextRow.get(j) + res.get(j));
                nextRow.set(j + 1, nextRow.get(j + 1) + res.get(j));
            }
            res = nextRow;
        }

        return res;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }

        return res.getLast();
    }

    public static void main(String[] args) {
        int numRows = 5;
        UtilityClass.logResult(getRow(numRows));
    }
}
