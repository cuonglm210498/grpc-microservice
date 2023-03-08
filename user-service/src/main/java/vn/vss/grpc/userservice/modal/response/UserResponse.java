package vn.vss.grpc.userservice.modal.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import vn.vss.grpc.common.constant.CommonConstant;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:56 PM
 * @project grpc
 */
@Data
public class UserResponse {

    private Long id;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DATE_FORMAT_DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate createdDate;
    private String createdBy;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DATE_FORMAT_DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate modifiedDate;
    private String modifiedBy;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DATE_FORMAT_DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate dateOfBirth;
    private String avatar;
}
