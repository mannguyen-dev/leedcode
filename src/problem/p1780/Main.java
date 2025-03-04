package problem.p1780;

public class Main {
    public static boolean checkPowersOfThree(int n) {

        while (n > 0){
            if (n % 3 == 2){
                return false;
            }

            n /= 3;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(21));
    }
}
