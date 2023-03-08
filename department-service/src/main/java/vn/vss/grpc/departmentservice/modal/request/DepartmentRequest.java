package vn.vss.grpc.departmentservice.modal.request;

import lombok.Data;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 2:57 PM
 * @project grpc
 */
@Data
public class DepartmentRequest {

    private String name;
    private String address;
    private String code;
}
