package request;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.request.LoginRequest;

class LoginRequestTest {
    @Test
    public void testValidLoginRequest() {
        // Given
        String email = "test@example.com";
        String password = "secret";
        

        // When
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        // Then
        // No exception should be thrown for a valid login request
        // You might also want to add additional assertions based on your requirements
    }

}