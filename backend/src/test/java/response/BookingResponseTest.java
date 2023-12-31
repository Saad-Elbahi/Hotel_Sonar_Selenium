package response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.response.BookingResponse;
import com.dailycodework.lakesidehotel.response.RoomResponse;

class BookingResponseTest {
    @Test
    public void testBookingResponseConstructor() {
        // Given
        Long id = 1L;
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(3);
        String guestName = "John Doe";
        String guestEmail = "john.doe@example.com";
        int numOfAdults = 2;
        int numOfChildren = 1;
        int totalNumOfGuests = 3;
        String bookingConfirmationCode = "ABC123";
        RoomResponse room = new RoomResponse(101L, "Single", BigDecimal.ONE);

        // When
        BookingResponse bookingResponse = new BookingResponse(id, checkInDate, checkOutDate,
                guestName, guestEmail, numOfAdults, numOfChildren, totalNumOfGuests,
                bookingConfirmationCode, room);

        // Then
        assertNotNull(bookingResponse);
        assertEquals(id, bookingResponse.getId());
        assertEquals(checkInDate, bookingResponse.getCheckInDate());
        assertEquals(checkOutDate, bookingResponse.getCheckOutDate());
        assertEquals(guestName, bookingResponse.getGuestName());
        assertEquals(guestEmail, bookingResponse.getGuestEmail());
        assertEquals(numOfAdults, bookingResponse.getNumOfAdults());
        assertEquals(numOfChildren, bookingResponse.getNumOfChildren());
        assertEquals(totalNumOfGuests, bookingResponse.getTotalNumOfGuests());
        assertEquals(bookingConfirmationCode, bookingResponse.getBookingConfirmationCode());
        assertEquals(room, bookingResponse.getRoom());
    }
}