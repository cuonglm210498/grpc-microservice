package vn.vss.grpc.departmentservice.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import vn.vss.grpc.departmentservice.entity.Department;
import vn.vss.grpc.departmentservice.modal.request.DepartmentRequest;
import vn.vss.grpc.departmentservice.modal.response.DepartmentResponse;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 2:56 PM
 * @project grpc
 */
@Component
@AllArgsConstructor
public class DepartmentMapper {

    private ModelMapper modelMapper;

    public Department to(DepartmentRequest departmentRequest) {
        return modelMapper.map(departmentRequest, Department.class);
    }

    public DepartmentResponse to(Department department) {
        return modelMapper.map(department, DepartmentResponse.class);
    }
}
