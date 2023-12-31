package response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.response.BookingResponse;
import com.dailycodework.lakesidehotel.response.RoomResponse;

class RoomResponseTest {

    @Test
    public void testRoomResponseConstructorWithoutPhotoAndBookings() {
        // Given
        Long id = 1L;
        String roomType = "Single";
        BigDecimal roomPrice = BigDecimal.valueOf(100.0);

        // When
        RoomResponse roomResponse = new RoomResponse(id, roomType, roomPrice);

        // Then
        assertNotNull(roomResponse);
        assertEquals(id, roomResponse.getId());
        assertEquals(roomType, roomResponse.getRoomType());
        assertEquals(roomPrice, roomResponse.getRoomPrice());
        // Additional assertions if needed
    }

    @Test
    public void testRoomResponseConstructorWithPhotoAndBookings() {
        // Given
        Long id = 4556L;
        String roomType = "Double";
        BigDecimal roomPrice = BigDecimal.valueOf(150.0);
        boolean isBooked = true;
        List<BookingResponse> bookings = new ArrayList<>();

        // When
        RoomResponse roomResponse = new RoomResponse(id, roomType, roomPrice, isBooked, (byte[]) null, bookings);

        // Then
        assertNotNull(roomResponse);
        assertEquals(id, roomResponse.getId());
        assertEquals(roomType, roomResponse.getRoomType());
        assertEquals(roomPrice, roomResponse.getRoomPrice());
        assertEquals(isBooked, roomResponse.isBooked());
        // Assert photo (you may need to convert the byte array to Base64 for comparison)
        // assertEquals(encodedPhoto, roomResponse.getPhoto());
        assertEquals(bookings, roomResponse.getBookings());
    }

    @Test
    public void testRoomResponseConstructorWithPhotoBytes() {
        // Given
        Long id = 789L;
        String roomType = "Suite";
        BigDecimal roomPrice = BigDecimal.valueOf(200.0);
        boolean isBooked = false;
        byte[] photoBytes = new byte[]{/* provide sample bytes here */};
        List<BookingResponse> bookings = new ArrayList<>();

        // When
        RoomResponse roomResponse = new RoomResponse(id, roomType, roomPrice, isBooked, photoBytes, bookings);

        // Then
        assertNotNull(roomResponse);
        assertEquals(id, roomResponse.getId());
        assertEquals(roomType, roomResponse.getRoomType());
        assertEquals(roomPrice, roomResponse.getRoomPrice());
        assertEquals(isBooked, roomResponse.isBooked());
        // Assert photo (you may need to convert the byte array to Base64 for comparison)
        // assertEquals(encodedPhoto, roomResponse.getPhoto());
        assertEquals(bookings, roomResponse.getBookings());
    }
}
