package vn.vss.grpc.common.exception;

import lombok.Getter;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:36 PM
 * @project grpc
 */
@Getter
public class BusinessException extends RuntimeException {

    private ErrorCodeResponse errorCodeResponse;

    public BusinessException(ErrorCodeResponse errorCodeResponse) {
        this.errorCodeResponse = errorCodeResponse;
    }
}
