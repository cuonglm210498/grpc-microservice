package vn.vss.grpc.departmentservice.mapper;

import org.springframework.stereotype.Component;
import vn.vss.grpc.departmentservice.modal.response.UserResponseGrpc;
import vn.vss.grpc.proto.UserResponse;

/**
 * @author CuongLM18
 * @created 29/12/2022 - 3:06 PM
 * @project grpc-master
 */
@Component
public class UserGrpcMapper {

    public UserResponseGrpc to(UserResponse userResponse) {
        UserResponseGrpc responseGrpc = new UserResponseGrpc();
        responseGrpc.setId(userResponse.getId());
        responseGrpc.setFullName(userResponse.getFullName());
        responseGrpc.setPhone(userResponse.getPhone());
        responseGrpc.setEmail(userResponse.getEmail());
        responseGrpc.setUserName(userResponse.getUserName());
        responseGrpc.setAddress(userResponse.getAddress());
        return responseGrpc;
    }
}
