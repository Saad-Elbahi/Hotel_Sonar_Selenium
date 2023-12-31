package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.InternalServerException;

class InternalServerExceptionTest {
    @Test
    public void testInternalServerException() {
        // Given
        String errorMessage = "Internal Server Error";

        // When
        InternalServerException internalServerException = new InternalServerException(errorMessage);

        // Then
        assertEquals(errorMessage, internalServerException.getMessage());
    }
}