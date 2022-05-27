package by.epam.unit_6.task_1.cryptographer;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Password {
    private final static int iterations = 20 * 1000;
    private final static int saltLength = 32;
    private final static int desiredLength = 256;

    public static String getSaltedHash(String password) {
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLength);
            return Base64.getEncoder().encodeToString(salt) + "$" + hash(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkPassword(String password, String stored) {
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            throw new IllegalStateException("The stored password have the form 'salt$hash'");
        }
        String hashOfInput;

        hashOfInput = hash(password, Base64.getDecoder().decode(saltAndPass[0]));
        assert hashOfInput != null;
        return hashOfInput.equals(saltAndPass[1]);
    }

    private static String hash(String password, byte[] salt) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Empty password are not supported!");
        }
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key = secretKeyFactory.generateSecret(
                    new PBEKeySpec(password.toCharArray(), salt, iterations, desiredLength));

            return Base64.getEncoder().encodeToString(key.getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }
}
