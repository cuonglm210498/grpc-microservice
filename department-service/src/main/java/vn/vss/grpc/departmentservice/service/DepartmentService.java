package vn.vss.grpc.departmentservice.service;

import vn.vss.grpc.departmentservice.modal.response.DepartmentResponse;
import vn.vss.grpc.departmentservice.modal.vo.User;

import java.util.List;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:23 AM
 * @project grpc
 */
public interface DepartmentService {

    List<DepartmentResponse> getAll();

    List<User> getAllUser();
}
