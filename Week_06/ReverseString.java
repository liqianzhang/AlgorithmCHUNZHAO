public class ReverseString {


    public  String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();
        for (int start = 0; start < chars.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, chars.length -1);
            while (i < j){
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);


//        int factor = 0;
//        int section = factor * 2 * k;
//        for (int i = 0; i < s.length(); i++) {
//            char tmp = 0;
//           while(s.length() - section >= k){
//               if (i <= section + k){//对 section 到 section + k之前进行翻转
//                    tmp = (char) (tmp + s.charAt(section + k - 1));
//               }
//               //s.substring(section, section + k)
//           }
//            s.replace(s.substring(section, section + k), String.valueOf(tmp));
//            factor++;
//        }
//        return s;
    }
}
