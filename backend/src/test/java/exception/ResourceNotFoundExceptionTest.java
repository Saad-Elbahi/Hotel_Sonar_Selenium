package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.ResourceNotFoundException;

class ResourceNotFoundExceptionTest {
    @Test
    public void testResourceNotFoundException() {
        // Given
        String errorMessage = "Resource Not Found";

        // When
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(errorMessage);

        // Then
        assertEquals(errorMessage, resourceNotFoundException.getMessage());
    }
}