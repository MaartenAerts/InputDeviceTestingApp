package InputDeviceTesting.uantwerpen.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Niels on 3/11/2015.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/dashboard").setViewName("dashboard");
//        registry.addViewController("/login").setViewName("login");
//    }
}
