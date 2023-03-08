package vn.vss.grpc.departmentservice.service.grpc;

import vn.vss.grpc.departmentservice.modal.response.UserResponseGrpc;

import java.util.List;

/**
 * @author CuongLM18
 * @created 30/12/2022 - 8:14 AM
 * @project grpc-master
 */
public interface GrpcClientService {

    List<UserResponseGrpc> getAllUser();

    UserResponseGrpc findUserById(Long id);

    void deleteUserById(Long id);
}
