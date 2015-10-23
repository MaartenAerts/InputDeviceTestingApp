package InputDeviceTesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("InputDeviceTesting.uantwerpen.model")
//@EnableJpaRepositories//    (basePackages = "InputDeviceTesting.uantwerpen.repo")
//@EntityScan(basePackages = " InputDeviceTesting.uantwerpen.model")
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }
}
