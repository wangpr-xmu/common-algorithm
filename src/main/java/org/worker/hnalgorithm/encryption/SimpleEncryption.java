package org.worker.hnalgorithm.encryption;

/**
 * @author peiru wang
 * @date 2021/7/29
 */
public class SimpleEncryption {
    public String encode(String msg, int factor) {
        if(msg == null) {
            return "";
        }
        char[] chars = msg.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                int asc = chars[i] + factor;
                if(asc > 57) {
                    asc = asc - 57 + 47;
                }
                chars[i] = (char)asc;
            }
            if(Character.isLowerCase(chars[i])) {
                int asc = chars[i] + factor;
                if(asc > 122) {
                    asc = asc - 122 + 96;
                }
                chars[i] = (char)asc;
            }
            if(Character.isUpperCase(chars[i])) {
                int asc = chars[i] + factor;
                if(asc > 90) {
                    asc = asc - 90 + 64;
                }
                chars[i] = (char)asc;
            }
        }
        return new String(chars);
    }
}
