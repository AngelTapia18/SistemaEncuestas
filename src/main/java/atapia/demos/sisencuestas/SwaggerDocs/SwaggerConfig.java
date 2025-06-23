package atapia.demos.sisencuestas.SwaggerDocs;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public  OpenApiCustomizer forceHttpsUrls() {
        return openApi -> openApi.getServers().forEach(server ->
                server.setUrl(server.getUrl().replace("http://", "https://")));
    }
}
