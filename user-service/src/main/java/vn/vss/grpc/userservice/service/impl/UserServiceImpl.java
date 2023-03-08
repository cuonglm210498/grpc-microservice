package vn.vss.grpc.userservice.service.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import vn.vss.grpc.common.exception.BusinessCodeResponse;
import vn.vss.grpc.common.exception.BusinessException;
import vn.vss.grpc.userservice.entity.User;
import vn.vss.grpc.userservice.mapper.UserMapper;
import vn.vss.grpc.userservice.modal.request.UserRequest;
import vn.vss.grpc.userservice.modal.response.UserResponse;
import vn.vss.grpc.userservice.repository.UserRepository;
import vn.vss.grpc.userservice.service.UserService;
import vn.vss.grpc.userservice.validate.UserValidate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 9:27 AM
 * @project grpc
 */
@Data
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAll() {
        List<User> list = userRepository.findAll();
        return list
                .stream()
                .map(userMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);

        if (userFromDb.isPresent()) {
            User user = userFromDb.get();
            return userMapper.to(user);
        } else {
            throw new BusinessException(BusinessCodeResponse.USER_NOT_FOUND);
        }
    }

    @Override
    public void saveUser(UserRequest userRequest) {
        userRepository.save(userMapper.to(userRequest));
    }

    @Override
    public boolean checkEmailExist(String email) {
        return userRepository.countAllByEmail(email) > 0;
    }

    @Override
    public boolean checkPhoneExits(String phone) {
        return userRepository.countAllByPhone(phone) > 0;
    }

    @Override
    public boolean checkUserNameExist(String userName) {
        return userRepository.countAllByUserName(userName) > 0;
    }
}
