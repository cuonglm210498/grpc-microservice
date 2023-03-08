package vn.vss.grpc.userservice.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;
import vn.vss.grpc.common.utils.StringUtils;
import vn.vss.grpc.common.validate.Validator;
import vn.vss.grpc.userservice.modal.request.UserRequest;
import vn.vss.grpc.userservice.service.UserService;

/**
 * @author CuongLM18
 * @created 04/01/2023 - 10:49 AM
 * @project grpc-master
 */
@Component
public class UserValidate {

    @Autowired
    private UserService userService;

    public UserRequest validateUserRequest(UserRequest userCreateRequest) {
        return Validator.data(userCreateRequest)
                .validate(UserRequest::getUserName, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.USER_NAME_IS_EMPTY))
                .validate(UserRequest::getUserName, userService::checkUserNameExist, () -> new BusinessException(BusinessCodeResponse.USER_NAME_AVAILABLE))
                .validate(UserRequest::getPassword, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.PASSWORD_IS_EMPTY))
                .validate(UserRequest::getPassword, StringUtils::verifyPassword, () -> new BusinessException(BusinessCodeResponse.PASSWORD_INVALIDATE))
                .validate(UserRequest::getEmail, StringUtils::verifyEmail, () -> new BusinessException(BusinessCodeResponse.EMAIL_INVALIDATE))
                .validate(UserRequest::getEmail, userService::checkEmailExist, () -> new BusinessException(BusinessCodeResponse.EMAIL_AVAILABLE))
                .validate(UserRequest::getEmail, StringUtils::isBlank, () -> new BusinessException(BusinessCodeResponse.EMAIL_INVALIDATE))
                .validate(UserRequest::getPhone, StringUtils::verifyPhoneNumber, () -> new BusinessException(BusinessCodeResponse.PHONE_NUMBER_INVALIDATE))
                .validate(UserRequest::getPhone, userService::checkPhoneExits, () -> new BusinessException(BusinessCodeResponse.PHONE_AVAILABLE))
                .getData();
    }
}
