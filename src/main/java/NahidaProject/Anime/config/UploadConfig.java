package NahidaProject.Anime.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
public class UploadConfig {
    @Bean
    public MultipartConfigElement getMultipartConfig(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize(DataSize.parse("10GB"));
        multipartConfigFactory.setMaxRequestSize(DataSize.parse("20GB"));
        return multipartConfigFactory.createMultipartConfig();
    }
}
