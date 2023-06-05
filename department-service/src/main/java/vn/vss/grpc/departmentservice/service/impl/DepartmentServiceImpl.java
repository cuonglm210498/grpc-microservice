package vn.vss.grpc.departmentservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.vss.grpc.common.constant.ApiConstant;
import vn.vss.grpc.common.modal.response.BaseResponse;
import vn.vss.grpc.common.utils.RestApiUtils;
import vn.vss.grpc.departmentservice.entity.Department;
import vn.vss.grpc.departmentservice.mapper.DepartmentMapper;
import vn.vss.grpc.departmentservice.modal.response.DepartmentResponse;
import vn.vss.grpc.departmentservice.modal.vo.User;
import vn.vss.grpc.departmentservice.repository.DepartmentRepository;
import vn.vss.grpc.departmentservice.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:24 AM
 * @project grpc
 */
@Data
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final RestApiUtils restApiUtils;
    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getAll() {
        List<Department> list = departmentRepository.findAll();
        return list
                .stream()
                .map(departmentMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUser() {
        BaseResponse response = restApiUtils.callRestApi(ApiConstant.UserService.GET_ALL_USER, HttpMethod.GET, BaseResponse.class);
        return objectMapper.convertValue(response.getData(), new TypeReference<>(){});
    }
}
