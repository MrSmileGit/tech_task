package helpers;

import java.security.SecureRandom;

public class RandomGenerator {

    public static String getRandomText(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        SecureRandom RND = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = RND.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getRandomWord(int length) {
        return getRandomText(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public static int getRandomNumber(int length) {
        return Integer.parseInt(getRandomText(length, "1234567890"));
    }

    public static String getRandomEmail() {
        StringBuilder sb = new StringBuilder(Math.max(10, 16));
        sb.append(getRandomWord(4));
        sb.append(getRandomNumber(5));
        sb.append(getRandomWord(4));
        sb.append("@gmail.com");
        return sb.toString();
    }

}
