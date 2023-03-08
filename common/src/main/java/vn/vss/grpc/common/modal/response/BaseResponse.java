package vn.vss.grpc.common.modal.response;

import lombok.*;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;
import vn.vss.grpc.common.exception.ErrorCodeResponse;

import java.nio.file.AccessDeniedException;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:35 PM
 * @project grpc
 */
@Data
@NoArgsConstructor
public class BaseResponse<T> {

    private ErrorCodeResponse code;
    private T data;

    public BaseResponse(ErrorCodeResponse code) {
        this.code = code;
    }

    public BaseResponse(ErrorCodeResponse code, T data) {
        this.code = code;
        this.data = data;
    }

    public static BaseResponse<ErrorCodeResponse> ofSuccess() {
        return new BaseResponse<>(BusinessCodeResponse.SUCCESS);
    }

    public static <M> BaseResponse<M> ofSuccess(M data) {
        return new BaseResponse<>(BusinessCodeResponse.SUCCESS, data);
    }

    public static BaseResponse<ErrorCodeResponse> ofFail(BusinessException businessException) {
        return new BaseResponse<>(businessException.getErrorCodeResponse(), null);
    }

    public static BaseResponse<ErrorCodeResponse> ofFail(AccessDeniedException accessDeniedException) {
        return new BaseResponse<>(BusinessCodeResponse.FORBIDDEN, null);
    }
}
