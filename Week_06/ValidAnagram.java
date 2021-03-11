public class ValidAnagram {
    public static void main(String[] args) {
        String s = "a", t = "b";
        boolean valid = isAnagram(s, t);
        System.out.println(valid);
    }
    public static boolean isAnagram(String s, String t) {
        int[] table = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            table[t.charAt(j) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
           if (table[i] != 0) {
               return false;
           }
        }
        return true;
      }
    }
