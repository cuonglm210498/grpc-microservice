package vn.vss.grpc.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:37 PM
 * @project grpc
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorCodeResponse {

    private String code;
    private String message;
    private HttpStatus status;
}
