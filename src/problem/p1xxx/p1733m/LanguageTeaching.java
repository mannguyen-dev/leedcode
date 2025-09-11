package problem.p1xxx.p1733m;

import problem.UtilityClass;

import java.util.HashSet;
import java.util.Set;

public class LanguageTeaching {
    public static void main(String[] args) {
        int n = 3;
        int[][] languages = {{2}, {1,3}, {1,2}, {3}};
        int[][] friendships = {{1,4},{1,2},{3,4},{2,3}};

        UtilityClass.logResult(minimumTeachings(n, languages, friendships));
    }


    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> needHelps = new HashSet<>();

        for (int[] friend: friendships){
            if (!hasIntersection(languages[friend[0]-1], languages[friend[1]-1])){
                needHelps.add(friend[0]-1);
                needHelps.add(friend[1]-1);
            }
        }

        if (needHelps.isEmpty()){
            return 0;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int person: needHelps){
                if (contains(languages[person], i)){
                    cnt++;
                }
            }
            res = Math.min(cnt, res);
        }

        return res;
    }

    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (set.contains(num)) {
                return true; // tìm thấy giao nhau
            }
        }
        return false; // không có giao nhau
    }

    /*
    class Solution:
    def minimumTeachings(self, n, languages, friendships):
        # Chuyển danh sách ngôn ngữ sang set cho tiện
        lang_sets = [set(l) for l in languages]

        # Tìm những người trong các cặp bạn bè không thể giao tiếp
        need_help = set()
        for u, v in friendships:
            if lang_sets[u-1].isdisjoint(lang_sets[v-1]):  # không có giao nhau
                need_help.add(u-1)
                need_help.add(v-1)

        # Nếu tất cả đã giao tiếp được
        if not need_help:
            return 0

        # Thử dạy từng ngôn ngữ
        res = float('inf')
        for L in range(1, n+1):
            cnt = 0
            for person in need_help:
                if L not in lang_sets[person]:
                    cnt += 1
            res = min(res, cnt)

        return res
     */
}
