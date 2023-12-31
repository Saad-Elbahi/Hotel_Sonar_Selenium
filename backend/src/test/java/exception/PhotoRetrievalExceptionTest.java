package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.PhotoRetrievalException;

class PhotoRetrievalExceptionTest {
    @Test
    public void testPhotoRetrievalException() {
        // Given
        String errorMessage = "Photo Retrieval Error";

        // When
        PhotoRetrievalException photoRetrievalException = new PhotoRetrievalException(errorMessage);

        // Then
        assertEquals(errorMessage, photoRetrievalException.getMessage());
    }
}