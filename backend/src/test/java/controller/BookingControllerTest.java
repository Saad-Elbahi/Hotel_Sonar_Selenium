package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dailycodework.lakesidehotel.controller.BookingController;
import com.dailycodework.lakesidehotel.exception.InvalidBookingRequestException;
import com.dailycodework.lakesidehotel.exception.ResourceNotFoundException;
import com.dailycodework.lakesidehotel.model.BookedRoom;
import com.dailycodework.lakesidehotel.response.BookingResponse;
import com.dailycodework.lakesidehotel.service.IBookingService;
import com.dailycodework.lakesidehotel.service.IRoomService;


class BookingControllerTest {

    @Mock
    private IBookingService bookingService;

    @Mock
    private IRoomService roomService;

    @InjectMocks
    private BookingController bookingController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBookings_AdminRole_ReturnsOk() {
        // Arrange
        List<BookedRoom> bookings = new ArrayList<>(); // Populate with test data
        when(bookingService.getAllBookings()).thenReturn(bookings);

        // Act
        ResponseEntity<List<BookingResponse>> responseEntity = bookingController.getAllBookings();

        // Assert
        assertEquals(ResponseEntity.ok(new ArrayList<>()), responseEntity);
        verify(bookingService, times(1)).getAllBookings();
    }

    @Test
    void saveBooking_ValidBookingRequest_ReturnsOk() throws InvalidBookingRequestException {
        // Arrange
        Long roomId = 1L; // Set valid room ID
        BookedRoom bookingRequest = new BookedRoom(); // Populate with valid booking request data
        when(bookingService.saveBooking(roomId, bookingRequest)).thenReturn("confirmationCode");

        // Act
        ResponseEntity<?> responseEntity = bookingController.saveBooking(roomId, bookingRequest);

        // Assert
        assertEquals(ResponseEntity.ok("Room booked successfully, Your booking confirmation code is :confirmationCode"), responseEntity);
        verify(bookingService, times(1)).saveBooking(roomId, bookingRequest);
    }





    // Add more test methods for other controller methods
}
