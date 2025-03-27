package problem.p2xxx.p20xx.p2226m;

public class Main {
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy: candies) sum += candy;

        if (sum < k){
            return 0;
        }

        int l = 1;
        int r = (int) (sum / k);
        int res = 0;
        int mid;

        while (l <= r){
            mid = ((r+l)/2);
            long count = 0;
            for (int candy : candies) {
                if (candy >= mid)
                    count += (candy / mid);

                if (count >= k) break;
            }

            if (count < k){
                r = mid-1;
            }else{
                res = mid;
                l = mid +1;
            }
        }
        return res;
    }

    public static int maximumCandies2(int[] candies, long k) {
        int max = 0;
        for (int candy: candies) {
            if (max < candy) max = candy;
        }
        int l = 1;
        int r = max;
        int res = 0;
        int mid;

        while (l <= r){
            mid = ((r+l)/2);
            int count = 0;
            for (int candy : candies) {
                if (candy >= mid)
                    count += (candy / mid);

                if (count >= k) break;
            }

            if (count >= k){
                res = mid;
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] candies = {1,2,3,4,10};
        int k = 5;
        System.out.println(maximumCandies2(candies, k));
    }
}
