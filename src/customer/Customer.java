package customer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Customer {
    private String name,age,phoneNumber,bankRating;
    private String password;
    private String salt;

    public Customer(String name, String age, String phoneNumber, String bankRating, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.bankRating = bankRating;
        this.salt = getSalt();
        this.password = get_SHA_256_SecurePassword(password,this.salt);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBankRating(String bankRating) {
        this.bankRating = bankRating;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBankRating() {
        return bankRating;
    }
    private static String get_SHA_256_SecurePassword(String passwordToHash,
                                                     String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
    public void showStats()
    {
        System.out.println("\n" + "Name: " + this.getName() + "\n" + "Age: " + this.getAge() + "\n" + "Phone Number: " + this.getPhoneNumber() + "\n" + "Bank Rating: " + this.getBankRating() + "\n");
    }
}
