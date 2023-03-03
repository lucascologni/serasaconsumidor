package br.com.serasaconsumidor.infrastructure.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class ResourceProperties {

    @Value("${browser}")
    private String webDriverType;

    @Value("${url}")
    public String url;

    @Value("${headless}")
    public boolean headless;
}