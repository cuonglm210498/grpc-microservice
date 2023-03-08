package vn.vss.grpc.departmentservice.controller.grpc;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vss.grpc.common.modal.response.BaseResponse;
import vn.vss.grpc.departmentservice.modal.response.UserResponseGrpc;
import vn.vss.grpc.departmentservice.service.grpc.GrpcClientService;

import java.util.List;

/**
 * @author CuongLM18
 * @created 26/12/2022 - 8:03 AM
 * @project grpc-master
 */
@Data
@RestController
@RequestMapping("/api/v1/department/grpc/user")
public class UserGrpcController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<UserResponseGrpc>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.ofSuccess(grpcClientService.findUserById(id)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<UserResponseGrpc>>> getAll() {
        return ResponseEntity.ok(BaseResponse.ofSuccess(grpcClientService.getAllUser()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteUserById(@PathVariable Long id) {
        grpcClientService.deleteUserById(id);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }


}
