package com.barath.barathHotel.service.interfac;

import com.barath.barathHotel.dto.LoginRequest;
import com.barath.barathHotel.dto.Response;
import com.barath.barathHotel.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}
