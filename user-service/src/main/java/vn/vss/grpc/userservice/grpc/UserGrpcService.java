package vn.vss.grpc.userservice.grpc;

import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;
import vn.vss.grpc.proto.*;
import vn.vss.grpc.userservice.entity.User;
import vn.vss.grpc.userservice.mapper.UserMapper;
import vn.vss.grpc.userservice.repository.UserRepository;

import java.util.Optional;

/**
 * @author CuongLM18
 * @created 12/21/2022 - 11:39 PM
 * @project grpc
 */
@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        Optional<User> userFromDb = userRepository.findById(request.getId());

        if (userFromDb.isPresent()) {
            UserResponse userResponse =
                    UserResponse.newBuilder()
                            .setId(userFromDb.get().getId())
                            .setUserName(userFromDb.get().getUserName())
                            .setEmail(userFromDb.get().getEmail())
                            .setPhone(userFromDb.get().getPhone())
                            .setAddress(userFromDb.get().getAddress())
                            .setFullName(userFromDb.get().getFullName())
                            .build();

            responseObserver.onNext(userResponse);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new BusinessException(BusinessCodeResponse.USER_NOT_FOUND));
        }
    }

    @Override
    public void getAll(AllRequest request, StreamObserver<UserResponse> responseObserver) {
        userRepository
                .findAll()
                .forEach(user -> {
                    UserResponse userResponse = userMapper.toProto(user);
                    responseObserver.onNext(userResponse);
                });
        responseObserver.onCompleted();
    }

    @Override
    public void createUser(UserCreateRequest request, StreamObserver<UserCreateResponse> responseObserver) {

    }

    @Override
    public void deleteUser(UserRequest request, StreamObserver<UserDeleteResponse> responseObserver) {
        userRepository.deleteById(request.getId());
        responseObserver.onNext(UserDeleteResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(UserUpdateRequest request, StreamObserver<UserUpdateResponse> responseObserver) {
        super.updateUser(request, responseObserver);
    }
}
