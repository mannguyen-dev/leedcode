package problem.p2xxx.p20xx.p2140m;

import problem.UtilityClass;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {


    public static long mostPoints(int[][] questions) {
        long[] mem = new long[questions.length];
        Arrays.fill(mem, -1);

        return findMaxPoints(questions, 0, mem);
    }

    private static long findMaxPoints(int[][] questions, int pos, long[] mem) {
        if (pos >= questions.length) return 0;

        if (mem[pos] != -1) return mem[pos];

        long exclude = findMaxPoints(questions, pos + 1, mem);
        long include = questions[pos][0] + findMaxPoints(questions, pos + questions[pos][1] + 1, mem);

        long maxValue = Math.max(exclude, include);
        mem[pos] = maxValue;

        return maxValue;
    }

    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        UtilityClass.logResult(mostPoints(questions));
    }
}
