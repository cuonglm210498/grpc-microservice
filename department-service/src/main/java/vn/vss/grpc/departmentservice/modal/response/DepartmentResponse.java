package vn.vss.grpc.departmentservice.modal.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.vss.grpc.common.constant.CommonConstant;

import java.time.LocalDate;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 2:57 PM
 * @project grpc
 */
@Data
public class DepartmentResponse {

    private long id;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DATE_FORMAT_DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate createdDate;
    private String createdBy;
    @JsonFormat(pattern = CommonConstant.DateTimeFormat.DATE_FORMAT_DD_MM_YYYY, timezone = CommonConstant.DateTimeFormat.TIME_ZONE)
    private LocalDate modifiedDate;
    private String modifiedBy;
    private String name;
    private String address;
    private String code;
}
