package vn.vss.grpc.userservice.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.vss.grpc.proto.UserCreateRequest;
import vn.vss.grpc.userservice.entity.User;
import vn.vss.grpc.userservice.modal.request.UserRequest;
import vn.vss.grpc.userservice.modal.response.UserResponse;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:55 PM
 * @project grpc
 */
@AllArgsConstructor
@Component
public class UserMapper {
    private ModelMapper mapper;

    public User to(UserRequest userRequest) {
        return mapper.map(userRequest, User.class);
    }

    public UserResponse to(User user) {
        return mapper.map(user, UserResponse.class);
    }

    public vn.vss.grpc.proto.UserResponse toProto(User user) {
        return vn.vss.grpc.proto.UserResponse.newBuilder()
                .setId(user.getId())
                .setUserName(user.getUserName())
                .setFullName(user.getFullName())
                .setEmail(user.getEmail())
                .setPhone(user.getPhone())
                .setAddress(user.getAddress())
                .build();
    }
}
