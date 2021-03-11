public class PalindromicSubstrings {
    public static void main(String[] args) {
        int num = countSubstrings("aabb");
        System.out.println(num);
    }
    public static int countSubstrings(String s) {
        boolean[][] dp =new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i ; j++) {
               if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])) {
                   dp[i][j] = true;
                   ans ++;
               }
            }
        }
        return ans;
    }
}
