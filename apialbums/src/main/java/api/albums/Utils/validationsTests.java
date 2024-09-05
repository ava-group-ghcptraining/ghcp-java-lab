
package apialbums.src.main.java.api.albums.Utils;
import org.junit.Test;
import static org.junit.Assert.*;

public class validationsTests {

    @Test
    public void testValidateIPv6Address_ValidAddress() {
        String ipAddress = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        assertTrue(validations.validateIPv6Address(ipAddress));
    }

    @Test
    public void testValidateIPv6Address_InvalidAddress() {
        String ipAddress = "2001:0db8:85a3::8a2e:0370:7334";
        assertFalse(validations.validateIPv6Address(ipAddress));
    }

    @Test
    public void testValidatePhoneNumber_ValidNumber() {
        String phoneNumber = "1234567890";
        assertTrue(validations.validatePhoneNumber(phoneNumber));
    }

    @Test
    public void testValidatePhoneNumber_InvalidNumber() {
        String phoneNumber = "12345";
        assertFalse(validations.validatePhoneNumber(phoneNumber));
    }

    @Test
    public void testValidateEmailAddress_ValidAddress() {
        String emailAddress = "test@example.com";
        assertTrue(validations.validateEmailAddress(emailAddress));
    }

    @Test
    public void testValidateEmailAddress_InvalidAddress() {
        String emailAddress = "test@example";
        assertFalse(validations.validateEmailAddress(emailAddress));
    }
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("apialbums.src.main.java.api.albums.Utils.validationsTests");
    }
}