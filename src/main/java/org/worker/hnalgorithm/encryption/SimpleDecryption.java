package org.worker.hnalgorithm.encryption;

/**
 * @author peiru wang
 * @date 2021/7/29
 */
public class SimpleDecryption {
    public String decode(String msg, int factor) {
        if(msg == null) {
            return "";
        }
        char[] chars = msg.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                int asc = chars[i] - factor;
                if(asc < 48) {
                    asc = 57 - (48 - asc - 1);
                }
                chars[i] = (char)asc;
            }
            if(Character.isLowerCase(chars[i])) {
                int asc = chars[i] - factor;
                if(asc < 97) {
                    asc = 122 - (97 - asc - 1);
                }
                chars[i] = (char)asc;
            }
            if(Character.isUpperCase(chars[i])) {
                int asc = chars[i] - factor;
                if(asc < 65) {
                    asc = 90 - (65 - asc - 1);
                }
                chars[i] = (char)asc;
            }
        }
        return new String(chars);
    }
}
