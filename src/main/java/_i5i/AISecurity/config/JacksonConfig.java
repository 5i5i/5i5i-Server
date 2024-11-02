package _i5i.AISecurity.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    @Primary
    ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        StreamReadConstraints streamReadConstraints = StreamReadConstraints
                .builder()
                .maxStringLength(Integer.MAX_VALUE)
                .build();
        objectMapper.getFactory().setStreamReadConstraints(streamReadConstraints);

        // HTML 이스케이프 비활성화 설정
        objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);

        return objectMapper;
    }
}
