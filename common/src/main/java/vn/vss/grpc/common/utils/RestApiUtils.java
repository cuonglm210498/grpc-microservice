package vn.vss.grpc.common.utils;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;

/**
 * @author CuongLM18
 * @created 26/12/2022 - 4:56 PM
 * @project grpc-master
 */
@Component
@AllArgsConstructor
public class RestApiUtils {

    private final RestTemplate restTemplate;

    public <T> T getApi(final String path, final HttpMethod method, Class<T> clazz) {
        try {
            var response = restTemplate.exchange(
                    path,
                    method,
                    null,
                    clazz);

            if (HttpStatus.OK == response.getStatusCode() || HttpStatus.CREATED == response.getStatusCode())
                return response.getBody();
            return null;
        } catch (Exception e) {
            throw new BusinessException(BusinessCodeResponse.INTERNAL_SERVER_ERROR);
        }
    }
}
