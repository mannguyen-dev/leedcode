package problem.p0xxx.p01xx.p118e;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 2; i <= numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.addAll(res.get(i-2));
            temp.add(0);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < res.get(i-2).size()+1; j++){
                row.add(temp.get(j) + temp.get(j+1));
            }
            res.add(row);
        }

        return res;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
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

        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        UtilityClass.logResult(generate(numRows));
    }
}
