package encoders;

import org.jasypt.util.text.BasicTextEncryptor;

import javax.security.auth.login.LoginException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

    public static String encrypt(String password) throws LoginException, NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] passwordBytes = digest.digest(password.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : passwordBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    public static String salt() {
        String symbols = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append(symbols.charAt((int)(Math.random()*symbols.length())));
        }
        return stringBuilder.toString();
    }

    public static String encryptCookie(String password, String value) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(password);
        return encryptor.encrypt(value);
    }

    public static String decryptCookie(String password, String value) {
        BasicTextEncryptor decrypter = new BasicTextEncryptor();
        decrypter.setPassword(password);
        return decrypter.decrypt(value);
    }

}
