package logic.passwordmanagement;

public class PasswordVerify {
    public static boolean verify(String password, String encryptedPassword) {
        return verifyPassword(password, encryptedPassword);
    }
    
    private static boolean verifyPassword(String password, String encryptedPassword) {
        return PasswordEncryption.encrypt(password).equals(encryptedPassword);
    }
}
