package com.barath.barathHotel.service.interfac;

import com.barath.barathHotel.dto.Response;
import com.barath.barathHotel.entity.Booking;

public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);

}
