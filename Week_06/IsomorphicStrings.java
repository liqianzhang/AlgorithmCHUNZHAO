import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        isIsomorphic("foo", "bar");
    }
    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphicHeper(s, t) && isIsomorphicHeper(t, s);

    }
    public static boolean isIsomorphicHeper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2){
                    return false;
                }
            }else {
                map.put(c1 ,c2);
            }
        }
        return true;
    }
}
