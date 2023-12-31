package exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.exception.InvalidBookingRequestException;

class InvalidBookingRequestExceptionTest {
    @Test
    public void testInvalidBookingRequestException() {
        // Given
        String errorMessage = "Invalid Booking Request";

        // When
        InvalidBookingRequestException invalidBookingRequestException = new InvalidBookingRequestException(errorMessage);

        // Then
        assertEquals(errorMessage, invalidBookingRequestException.getMessage());
    }
}