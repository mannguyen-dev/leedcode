package problem.p0xxx.p763m;

import problem.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            lastIndex.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int size = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            size += 1;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        UtilityClass.logResult(partitionLabels(s));
    }
}
