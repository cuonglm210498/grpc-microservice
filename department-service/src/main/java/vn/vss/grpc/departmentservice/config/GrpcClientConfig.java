package vn.vss.grpc.departmentservice.config;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.vss.grpc.proto.UserServiceGrpc;

/**
 * @author CuongLM18
 * @created 29/12/2022 - 2:10 PM
 * @project grpc-master
 */
@Configuration
public class GrpcClientConfig {

    @Value("${user.service.target}")
    private String grpcServerAddress;

    @Bean
    Channel channel() {
        return ManagedChannelBuilder.forTarget(grpcServerAddress)
                .usePlaintext()
                .build();
    }

    @Bean
    UserServiceGrpc.UserServiceBlockingStub guestbookServiceBlockingStub(Channel channel) {
        return UserServiceGrpc.newBlockingStub(channel);
    }
}
