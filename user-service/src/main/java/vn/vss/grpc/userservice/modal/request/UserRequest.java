package vn.vss.grpc.userservice.modal.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.vss.grpc.common.constant.CommonConstant;

import java.time.LocalDate;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:56 PM
 * @project grpc
 */
@Data
public class UserRequest {

    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate dateOfBirth;
    private String avatar;
}
