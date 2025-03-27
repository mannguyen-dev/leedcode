package problem.p2xxx.p20xx.p2379e;

public class Main {

    public static int minimumRecolors(String blocks, int k) {
        // Solution #1
        /*
        char[] chars = blocks.toCharArray();
        int l = 0;
        int r = 0;
        int recolor = 0;
        int res;

        while (r < k){
            if (chars[r] == 'W'){
                recolor++;
            }
            r++;
        }
        res = recolor;
        while (r < chars.length){
            if (chars[l] == 'W'){
                recolor--;
            }

            if (chars[r] == 'W'){
                recolor++;
            }

            if (recolor < res){
                res = recolor;
            }

            l++;
            r++;
        }

        return res;
        */

        // Solution #2
        char[] chars = blocks.toCharArray();
        int l = 0;
        int r = 0;
        int recolor = 0;
        int res = k;

        while (r < chars.length){

            if (chars[r] == 'W'){
                recolor++;
            }


            if (r - l + 1 == k){
                res = Math.min(res, recolor);
                if (chars[l] == 'W'){
                    recolor--;
                }
                l++;
            }

            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }
}
