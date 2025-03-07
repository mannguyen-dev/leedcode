package problem.p2523m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[] closestPrimes(int left, int right) {
//        int[] result = {-1, -1};
//        int minDiff = Integer.MAX_VALUE;
//        for (int i = left; i <= right; i++) {
//            if (isPrime(i)) {
//                for (int j = i + 1; j <= right; j++) {
//                    if (isPrime(j)) {
//                        int diff = j - i;
//                        if (diff < minDiff) {
//                            minDiff = diff;
//                            result[0] = i;
//                            result[1] = j;
//                        }
//                    }
//                }
//            }
//        }
//        return result;

        // Apply sieve of Eratosthenes
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i*i <= right; i++){
            if (isPrime[i]){
                for (int j = 2; i*j <= right; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        // Save all the primes in our range
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++){
            if (isPrime[i]){
                primes.add(i);
            }
        }

        // Now find the 2 closest primes
        int a=0, b = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++){
            if ((b-a) > (primes.get(i)-primes.get(i-1))){
                b = primes.get(i);
                a = primes.get(i-1);
            }
        }

        // Build your answer
        if (a==0){
            return new int[]{-1,-1};
        }

        return new int[]{a, b};
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] result = closestPrimes(12854, 130337);
        System.out.println(result[0] + " " + result[1]);
    }
}
