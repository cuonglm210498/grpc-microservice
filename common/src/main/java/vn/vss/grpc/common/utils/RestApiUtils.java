package vn.vss.grpc.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CuongLM18
 * @created 26/12/2022 - 4:56 PM
 * @project grpc-master
 */
@Slf4j
@Component
@AllArgsConstructor
public class RestApiUtils {

    public static final String X_AUTH_TOKEN = "X-AUTH-TOKEN";
    public static final String BEARER = "Bearer ";
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public <T> T callRestApi(final String path, final HttpMethod method, Class<T> clazz) {
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

    public <T> T callRestApi(final String path, final HttpMethod method, Object request, Class<T> clazz) {
        try {
            var response = restTemplate.exchange(
                    path,
                    method,
                    new HttpEntity<>(objectMapper.writeValueAsString(request)),
                    clazz);

            if (HttpStatus.OK == response.getStatusCode() || HttpStatus.CREATED == response.getStatusCode())
                return response.getBody();
            return null;
        } catch (Exception e) {
            throw new BusinessException(BusinessCodeResponse.INTERNAL_SERVER_ERROR);
        }
    }

    public <T> T callRestApiWithToken(final String path, final HttpMethod method, Object request, Class<T> clazz) {
        try {
            var response = restTemplate.exchange(
                    path,
                    method,
                    new HttpEntity<>(objectMapper.writeValueAsString(request), this.makeHeader()),
                    clazz);

            if (HttpStatus.OK == response.getStatusCode() || HttpStatus.CREATED == response.getStatusCode())
                return response.getBody();
            return null;
        } catch (Exception e) {
            throw new BusinessException(BusinessCodeResponse.INTERNAL_SERVER_ERROR);
        }
    }

    public HttpHeaders makeHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String token = ((HttpServletRequest) request).getHeader("X-AUTH-TOKEN");
        headers.add(X_AUTH_TOKEN, token);

        return headers;
    }
}
