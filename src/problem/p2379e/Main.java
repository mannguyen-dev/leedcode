package problem.p2379e;

public class Main {

    public static int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int l = 0;
        int r = 0;
        int recolor = 0;
        int res = k;

//        while (r < k){
//            if (chars[r] == 'W'){
//                recolor++;
//            }
//            r++;
//        }
//        res = recolor;
        while (r < chars.length){
//            if (chars[l] == 'W'){
//                recolor--;
//            }

            if (chars[r] == 'W'){
                recolor++;
            }

//            if (recolor < res){
//                res = recolor;
//            }

            if (r - l + 1 == k){
                res = Math.min(res, recolor);
                if (chars[l] == 'W'){
                    recolor--;
                }
                l++;
            }

            //l++;
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }
}
