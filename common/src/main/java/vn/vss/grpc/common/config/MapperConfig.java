package vn.vss.grpc.common.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CuongLM18
 * @created 07/12/2022 - 1:50 PM
 * @project grpc
 */
@Configuration
public class MapperConfig {

    @Bean(name = "modelMapper")
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper
                .getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
}
