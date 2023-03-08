package vn.vss.grpc.userservice.service;

import vn.vss.grpc.userservice.entity.User;
import vn.vss.grpc.userservice.modal.request.UserRequest;
import vn.vss.grpc.userservice.modal.response.UserResponse;

import java.util.List;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:27 AM
 * @project grpc
 */
public interface UserService {

    List<UserResponse> getAll();

    UserResponse findById(Long id);

    void saveUser(UserRequest userRequest);

    boolean checkEmailExist(String email);

    boolean checkPhoneExits(String phone);

    boolean checkUserNameExist(String userName);
}
