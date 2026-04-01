package com.shark.sharkbank.auth_users.services;

import com.shark.sharkbank.auth_users.dtos.LoginRequest;
import com.shark.sharkbank.auth_users.dtos.LoginResponse;
import com.shark.sharkbank.auth_users.dtos.RegistrationRequest;
import com.shark.sharkbank.auth_users.dtos.ResetPasswordRequest;
import com.shark.sharkbank.res.Response;

public interface AuthService {
    Response<String> register(RegistrationRequest request);
    Response<LoginResponse> login(LoginRequest loginRequest);
    Response<?> forgetPassword(String email);
    Response<?> updatePasswordViaResetCode(ResetPasswordRequest resetPasswordRequest);
}
