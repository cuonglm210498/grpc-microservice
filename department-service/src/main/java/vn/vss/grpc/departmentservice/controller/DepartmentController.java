package vn.vss.grpc.departmentservice.controller;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vss.grpc.common.modal.response.BaseResponse;
import vn.vss.grpc.departmentservice.modal.response.DepartmentResponse;
import vn.vss.grpc.departmentservice.modal.vo.User;
import vn.vss.grpc.departmentservice.service.DepartmentService;

import java.util.List;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:35 AM
 * @project grpc
 */
@Data
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<DepartmentResponse>>> getAll() {
        return ResponseEntity.ok(BaseResponse.ofSuccess(departmentService.getAll()));
    }

    @GetMapping(value = "/call-user")
    public ResponseEntity<BaseResponse<List<User>>> getAllUser() {
        return ResponseEntity.ok(BaseResponse.ofSuccess(departmentService.getAllUser()));
    }
}
