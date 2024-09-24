public package api.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class validationsTests {

    @Test
    public void testValidateIPv6Address_ValidAddress() {
        String ipAddress = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        assertTrue(Validations.validateIPv6Address(ipAddress));
    }

    @Test
    public void testValidateIPv6Address_InvalidAddress() {
        String ipAddress = "2001:0db8:85a3::8a2e:0370:7334";
        assertFalse(Validations.validateIPv6Address(ipAddress));
    }

    @Test
    public void testValidatePhoneNumber_ValidNumber() {
        String phoneNumber = "1234567890";
        assertTrue(Validations.validatePhoneNumber(phoneNumber));
    }

    @Test
    public void testValidatePhoneNumber_InvalidNumber() {
        String phoneNumber = "12345";
        assertFalse(Validations.validatePhoneNumber(phoneNumber));
    }

    @Test
    public void testValidateEmailAddress_ValidAddress() {
        String emailAddress = "test@example.com";
        assertTrue(Validations.validateEmailAddress(emailAddress));
    }

    @Test
    public void testValidateEmailAddress_InvalidAddress() {
        String emailAddress = "test@example";
        assertFalse(Validations.validateEmailAddress(emailAddress));
    }
}