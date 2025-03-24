package problem.p3xxx.p3169m;

import problem.UtilityClass;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {
    public static int countDays(int days, int[][] meetings) {
        boolean[] busyDays = new boolean[days];
        for (int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            for (int i = start - 1; i < end; i++){
                if (!busyDays[i]) busyDays[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < days; i++){
            if (!busyDays[i]) count++;
        }
        return count;
    }

    public static int countDays2(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]));
        int prevEnd = 0;
        for (int[] meeting : meetings){
            int start = Math.max(meeting[0], prevEnd + 1);
            int end = meeting[1];
            int length =  end - start + 1;
            days -= Math.max(length, 0);
            prevEnd = Math.max(prevEnd, end);
        }

        return days;
    }

    public static void main(String[] args) {

        int days = 10;

        int[][] meetings = {{1,7},{1,3},{9,10}};
        UtilityClass.logResult(countDays2(days, meetings));
    }
}
