package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.model.BookedRoom;
import com.dailycodework.lakesidehotel.model.Room;

class RoomTest {
    @Test
    public void testGettersAndSetters() {
        Room room = new Room();
        room.setId(1L);
        room.setRoomType("Single");
        room.setRoomPrice(BigDecimal.valueOf(100.0));
        room.setBooked(true);

        /* Blob photo = new ;
        room.setPhoto(photo);*/

        List<BookedRoom> bookings = new ArrayList<>();
        room.setBookings(bookings);

        assertEquals(1L, room.getId());
        assertEquals("Single", room.getRoomType());
        assertEquals(BigDecimal.valueOf(100.0), room.getRoomPrice());
        assertTrue(room.isBooked());
        assertEquals(bookings, room.getBookings());
    }

    @Test
    public void testConstructors() {
        Room room = new Room();
        assertNotNull(room);
        assertNotNull(room.getBookings());
        assertTrue(room.getBookings().isEmpty());
        assertFalse(room.isBooked());

        Room roomWithDetails = new Room(1L, "Double", BigDecimal.valueOf(150.0), false, null, new ArrayList<>());
        assertNotNull(roomWithDetails);
        assertEquals(1L, roomWithDetails.getId());
        assertEquals("Double", roomWithDetails.getRoomType());
        assertEquals(BigDecimal.valueOf(150.0), roomWithDetails.getRoomPrice());
        assertFalse(roomWithDetails.isBooked());
        assertNotNull(roomWithDetails.getBookings());
    }

    @Test
    public void testAddBooking() {
        Room room = new Room();
        room.setId(1L);
        room.setRoomType("Single");
        room.setRoomPrice(BigDecimal.valueOf(100.0));

        BookedRoom booking = new BookedRoom();
        booking.setBookingId(1L);

        room.addBooking(booking);

        assertTrue(room.getBookings().contains(booking));
        assertEquals(room, booking.getRoom());
        assertTrue(room.isBooked());
        assertNotNull(booking.getBookingConfirmationCode());
    }

}