package api.utils;

public class validations {
    //Create a regex function to validate IPV6 address
    public static boolean validateIPv6Address(String ipAddress) {
        String regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
        return ipAddress.matches(regex);
    }

    
    //Create a regex function to validate phone number and email address
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^[0-9]{10}$";
        return phoneNumber.matches(regex);
    }

    public static boolean validateEmailAddress(String emailAddress) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return emailAddress.matches(regex);
    }
}
