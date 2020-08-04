package top.king.utils;

public class StringHandler {
    public static String str2unicode(String str) {
        StringBuffer sb = new StringBuffer();
        for (char c : str.toCharArray()) {
            sb.append("\\u");
            sb.append(Integer.toHexString(c));
        }
        return sb.toString();
    }
}
