package InputDeviceTesting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan//("InputDeviceTesting.uantwerpen.model")
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
//@EnableJpaRepositories//    (basePackages = "InputDeviceTesting.uantwerpen.repo")
//@EntityScan(basePackages = " InputDeviceTesting.uantwerpen.model")
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }

}
