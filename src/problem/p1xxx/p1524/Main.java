package problem.p1xxx.p1524;

public class Main {
    public static int numOfSubarrays(int[] arr) {
        int prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;
        int total = 0;

        int mod = 1_000_000_000 + 7;

        for (int j : arr) {
            prefixSum += j;

            if ((prefixSum & 1) == 1) {
                total = (total + evenCount) % mod;
                oddCount++;
            } else {
                total = (total + oddCount) % mod;
                evenCount++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(numOfSubarrays(arr));
    }

}
