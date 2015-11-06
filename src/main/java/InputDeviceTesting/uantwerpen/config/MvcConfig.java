package InputDeviceTesting.uantwerpen.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 * Created by Niels on 3/11/2015.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

     @Override
     public void addViewControllers(ViewControllerRegistry registry) {
          registry.addViewController("/").setViewName("dashboard");
          registry.addViewController("/index").setViewName("dashboard");
          registry.addViewController("/dashboard").setViewName("dashboard");
          registry.addViewController("/home").setViewName("dashboard");

          registry.addViewController("/login").setViewName("login");
          registry.addViewController("/access").setViewName("access");
    }
}
