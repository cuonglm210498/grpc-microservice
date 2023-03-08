package vn.vss.grpc.common.controller;

import org.springframework.http.ResponseEntity;
import vn.vss.grpc.common.exception.ErrorCodeResponse;
import vn.vss.grpc.common.modal.response.BaseResponse;

/**
 * @author CuongLM18
 * @created 04/01/2023 - 11:17 AM
 * @project grpc-master
 */
public class BaseController {

    public ResponseEntity<BaseResponse<ErrorCodeResponse>> success() {
        return ResponseEntity.ok(BaseResponse.ofSuccess());
    }

    public <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.ok(BaseResponse.ofSuccess(data));
    }
}
