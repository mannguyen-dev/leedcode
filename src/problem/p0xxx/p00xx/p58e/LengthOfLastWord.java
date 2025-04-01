package problem.p0xxx.p00xx.p58e;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;

        while (s.charAt(i) == ' ') i--;

        while (i >= 0){
            if (s.charAt(i) != ' ')
                count++;
            else
                break;
            i--;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "fly me   to   the moon ";
        System.out.println(lengthOfLastWord(s));
    }
}
