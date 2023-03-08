package vn.vss.grpc.departmentservice.modal.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.vss.grpc.common.constant.CommonConstant;

import java.time.LocalDate;

/**
 * @author CuongLM18
 * @created 29/12/2022 - 2:59 PM
 * @project grpc-master
 */
@Data
public class UserResponseGrpc {

    private Long id;
    private String userName;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate dateOfBirth;
    private String avatar;
}
