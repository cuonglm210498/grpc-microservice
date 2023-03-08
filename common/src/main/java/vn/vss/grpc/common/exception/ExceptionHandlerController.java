package vn.vss.grpc.common.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.vss.grpc.common.modal.response.BaseResponse;

import java.nio.file.AccessDeniedException;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:39 PM
 * @project grpc
 */
@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerController {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BaseResponse<ErrorCodeResponse>> handlerBusinessException(BusinessException e) {
        return new ResponseEntity<>(BaseResponse.ofFail(e), e.getErrorCodeResponse().getStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse<ErrorCodeResponse>> handlerAccessDeniedException(AccessDeniedException e) {
        return new ResponseEntity<>(BaseResponse.ofFail(e), HttpStatus.FORBIDDEN);
    }
}
