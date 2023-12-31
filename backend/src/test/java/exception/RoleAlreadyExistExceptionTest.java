package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.RoleAlreadyExistException;

class RoleAlreadyExistExceptionTest {
    @Test
    public void testRoleAlreadyExistException() {
        // Given
        String errorMessage = "Role Already Exists";

        // When
        RoleAlreadyExistException roleAlreadyExistException = new RoleAlreadyExistException(errorMessage);

        // Then
        assertEquals(errorMessage, roleAlreadyExistException.getMessage());
    }
}