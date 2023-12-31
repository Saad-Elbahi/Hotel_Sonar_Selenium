package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.dailycodework.lakesidehotel.model.BookedRoom;

class BookedRoomTest {
    @Test
    public void testGettersAndSetters() {
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setBookingId(1L);
        bookedRoom.setCheckInDate(LocalDate.now());
        bookedRoom.setCheckOutDate(LocalDate.now().plusDays(3));
        bookedRoom.setGuestFullName("John Doe");
        bookedRoom.setGuestEmail("john.doe@example.com");
        bookedRoom.setNumOfAdults(2);
        bookedRoom.setNumOfChildren(1);
        bookedRoom.setTotalNumOfGuest(3);
        bookedRoom.setBookingConfirmationCode("ABC123");

        assertEquals(1L, bookedRoom.getBookingId());
        assertEquals(LocalDate.now(), bookedRoom.getCheckInDate());
        assertEquals(LocalDate.now().plusDays(3), bookedRoom.getCheckOutDate());
        assertEquals("John Doe", bookedRoom.getGuestFullName());
        assertEquals("john.doe@example.com", bookedRoom.getGuestEmail());
        assertEquals(2, bookedRoom.getNumOfAdults());
        assertEquals(1, bookedRoom.getNumOfChildren());
        assertEquals(3, bookedRoom.getTotalNumOfGuest());
        assertEquals("ABC123", bookedRoom.getBookingConfirmationCode());
    }

    @Test
    public void testCalculateTotalNumberOfGuest() {
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setNumOfAdults(2);
        bookedRoom.setNumOfChildren(1);
        bookedRoom.calculateTotalNumberOfGuest();

        assertEquals(3, bookedRoom.getTotalNumOfGuest());
    }

    @Test
    public void testSetNumOfAdults() {
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setNumOfAdults(2);

        assertEquals(2, bookedRoom.getNumOfAdults());
        assertEquals(2, bookedRoom.getTotalNumOfGuest());
    }

    @Test
    public void testSetNumOfChildren() {
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setNumOfChildren(1);

        assertEquals(1, bookedRoom.getNumOfChildren());
        assertEquals(1, bookedRoom.getTotalNumOfGuest());
    }

    @Test
    public void testSetBookingConfirmationCode() {
        BookedRoom bookedRoom = new BookedRoom();
        bookedRoom.setBookingConfirmationCode("XYZ789");

        assertEquals("XYZ789", bookedRoom.getBookingConfirmationCode());
    }
}