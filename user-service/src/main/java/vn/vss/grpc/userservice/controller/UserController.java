package vn.vss.grpc.userservice.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vss.grpc.common.controller.BaseController;
import vn.vss.grpc.common.modal.response.BaseResponse;
import vn.vss.grpc.userservice.modal.request.UserRequest;
import vn.vss.grpc.userservice.modal.response.UserResponse;
import vn.vss.grpc.userservice.service.UserService;
import vn.vss.grpc.userservice.validate.UserValidate;

import java.util.List;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:30 AM
 * @project grpc
 */
@Data
@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {

    private final UserService userService;
    private final UserValidate userValidate;

    @GetMapping
    public ResponseEntity<BaseResponse<List<UserResponse>>> getAll() {
        return ResponseEntity.ok(BaseResponse.ofSuccess(userService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<UserResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(BaseResponse.ofSuccess(userService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Void>> saveUser(@RequestBody UserRequest userRequest) {
        userValidate.validateUserRequest(userRequest);
        userService.saveUser(userRequest);
        return success(null);
    }
}
