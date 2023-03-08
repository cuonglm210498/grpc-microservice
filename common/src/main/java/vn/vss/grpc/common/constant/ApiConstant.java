package vn.vss.grpc.common.constant;

/**
 * @author CuongLM18
 * @created 26/12/2022 - 2:57 PM
 * @project grpc-master
 */
public class ApiConstant {

    private ApiConstant() {}

    public static final class UserService {
        private UserService () {}

        public static final String GET_ALL_USER = "http://localhost:8088/api/v1/user";
    }
}
