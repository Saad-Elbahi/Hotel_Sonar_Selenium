package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.UserAlreadyExistsException;

class UserAlreadyExistsExceptionTest {
    @Test
    public void testUserAlreadyExistsException() {
        // Given
        String errorMessage = "User Already Exists";

        // When
        UserAlreadyExistsException userAlreadyExistsException = new UserAlreadyExistsException(errorMessage);

        // Then
        assertEquals(errorMessage, userAlreadyExistsException.getMessage());
    }

}