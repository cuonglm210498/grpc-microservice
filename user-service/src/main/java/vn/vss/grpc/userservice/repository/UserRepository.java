package vn.vss.grpc.userservice.repository;

import org.springframework.stereotype.Repository;
import vn.vss.grpc.common.repository.BaseRepository;
import vn.vss.grpc.userservice.entity.User;

/**
 * @author CuongLM18
 * @created 06/12/2022 - 4:40 PM
 * @project grpc
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    long countAllByUserName(String userName);

    long countAllByEmail(String email);

    long countAllByPhone(String phone);
}
