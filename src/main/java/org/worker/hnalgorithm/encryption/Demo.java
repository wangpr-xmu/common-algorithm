package org.worker.hnalgorithm.encryption;

/**
 * @author peiru wang
 * @date 2021/7/29
 */
public class Demo {
    public static void main(String[] args) {
        SimpleEncryption encryption = new SimpleEncryption();
        SimpleDecryption decryption = new SimpleDecryption();
        String msg = "hello world!";
        System.out.println(encryption.encode(msg, 3));
        System.out.println(decryption.decode(encryption.encode(msg, 3), 3));
    }
}
