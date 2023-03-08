package vn.vss.grpc.departmentservice.modal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.vss.grpc.common.constant.CommonConstant;

import java.time.LocalDate;

/**
 * @author CuongLM18
 * @created 29/12/2022 - 3:03 PM
 * @project grpc-master
 */
@Data
public class User {

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
