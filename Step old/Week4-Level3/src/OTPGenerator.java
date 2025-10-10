import java.util.*;

public class OTPGenerator {

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> unique = new HashSet<>();
        for (int otp : otps) unique.add(otp);
        return unique.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] otps = generateMultipleOTPs(10);
        System.out.println("Generated OTPs:");
        for (int otp : otps) System.out.println(otp);

        System.out.println("Are OTPs unique? " + areOTPsUnique(otps));
    }
}
