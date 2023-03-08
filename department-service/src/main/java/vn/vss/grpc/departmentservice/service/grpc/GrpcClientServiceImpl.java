package vn.vss.grpc.departmentservice.service.grpc;

import com.google.common.collect.Lists;
import io.grpc.StatusRuntimeException;
import lombok.Data;
import org.springframework.stereotype.Service;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;
import vn.vss.grpc.departmentservice.mapper.UserGrpcMapper;
import vn.vss.grpc.departmentservice.modal.response.UserResponseGrpc;
import vn.vss.grpc.proto.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CuongLM18
 * @created 30/12/2022 - 8:14 AM
 * @project grpc-master
 */
@Data
@Service
public class GrpcClientServiceImpl implements GrpcClientService {

    private final UserGrpcMapper mapper;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @Override
    public List<UserResponseGrpc> getAllUser() {
        AllRequest allRequest = AllRequest.newBuilder().build();
        Iterator<UserResponse> responses = userServiceBlockingStub.getAll(allRequest);

        List<UserResponse> listResponse = Lists.newArrayList(responses);

        return listResponse.stream().map(mapper::to).collect(Collectors.toList());
    }

    @Override
    public UserResponseGrpc findUserById(Long id) {
        UserRequest userRequest = UserRequest.newBuilder().setId(id).build();

        UserResponse response;

        try {
            response = userServiceBlockingStub.getUser(userRequest);
        } catch (StatusRuntimeException e) {
            throw new BusinessException(BusinessCodeResponse.USER_NOT_FOUND);
        }

        return mapper.to(response);
    }

    @Override
    public void deleteUserById(Long id) {
        UserRequest userRequest =
                UserRequest.newBuilder()
                        .setId(id)
                        .build();

        try {
            userServiceBlockingStub.deleteUser(userRequest);
        } catch (StatusRuntimeException e) {
            throw new BusinessException(BusinessCodeResponse.USER_NOT_FOUND);
        }
    }
}
