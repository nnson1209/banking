package com.shark.sharkbank.auth_users.services;

import com.shark.sharkbank.auth_users.dtos.UpdatePasswordRequest;
import com.shark.sharkbank.auth_users.dtos.UserDTO;
import com.shark.sharkbank.auth_users.entity.User;
import com.shark.sharkbank.res.Response;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {

    User getCurrentLoggedInUser();

    Response<UserDTO> getMyProfile();

    Response<Page<UserDTO>> getAllUsers(int page, int size);

    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);

    Response<?> uploadProfilePicture(MultipartFile file);

    Response<?> uploadProfilePictureToS3(MultipartFile file);

}