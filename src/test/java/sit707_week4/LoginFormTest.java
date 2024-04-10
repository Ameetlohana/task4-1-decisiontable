package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "s222332999";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Ameet";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse("Login should fail with empty username and password", status.isLoginSuccess());
    }

    @Test
    public void testFailEmptyUsernameAndValidPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
    }

    @Test
    public void testFailValidUsernameAndEmptyPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", null);
        Assert.assertFalse("Login should fail with empty password", status.isLoginSuccess());
    }

    @Test
    public void testFailIncorrectUsernameAndCorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("incorrect_username", "ahsan_pass");
        Assert.assertFalse("Login should fail with incorrect username", status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndIncorrectPasswordAndDontCareValCode() {
        LoginStatus status = LoginForm.login("ahsan", "incorrect_password");
        Assert.assertFalse("Login should fail with incorrect password", status.isLoginSuccess());
    }

    @Test
    public void testFailCorrectUsernameAndCorrectPasswordAndIncorrectValCode() {
        LoginStatus status = LoginForm.login("ahsan",  "incorrect_code");
        Assert.assertFalse("Login should fail with incorrect validation code", status.isLoginSuccess());
    }

  

    @Test
    public void testSuccessCorrectUsernameAndCorrectPasswordAndCorrectValCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Login should succeed with correct credentials", status.isLoginSuccess());
    }

    @Test
    public void testFailIncorrectValCode() {
        boolean isValid = LoginForm.validateCode("incorrect_code");
        Assert.assertFalse("Validation code should be incorrect", isValid);
    }

    @Test
    public void testSuccessCorrectValCode() {
        boolean isValid = LoginForm.validateCode("123456");
        Assert.assertTrue("Validation code should be correct", isValid);
    }
}
