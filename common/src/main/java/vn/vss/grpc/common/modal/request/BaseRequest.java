package vn.vss.grpc.common.modal.request;

import lombok.Data;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:34 PM
 * @project grpc
 */
@Data
public class BaseRequest {

    private int pageIndex = 1;
    private int pageSize = 10;
}
