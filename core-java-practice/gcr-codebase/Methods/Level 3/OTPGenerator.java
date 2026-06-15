public class OTPGenerator {

    public static int generateOTP() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return otp;
    }

    public static boolean checkUniqueOTPs(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numberOfOTPs = 10;
        int[] otps = new int[numberOfOTPs];

        for (int i = 0; i < numberOfOTPs; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs:");
        for (int i = 0; i < otps.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        boolean unique = checkUniqueOTPs(otps);
        if (unique) {
            System.out.println("All OTPs are unique");
        } else {
            System.out.println("Some OTPs are not unique");
        }
    }
}
