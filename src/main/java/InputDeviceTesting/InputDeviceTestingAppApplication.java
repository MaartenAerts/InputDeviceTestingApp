package InputDeviceTesting;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Role;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }


    @Bean
    CommandLineRunner init(final ResearcherRepo researcherRepo){
        final Researcher researcher = new Researcher("lol@brol.fu","trol","King","Lepel", "organ", LocalDateTime.now() , LocalDateTime.now());
        researcher.addRole(new Role("HEADRESEARCHER"));
        researcher.addRole(new Role("LEUTROL"));

        final Researcher researcher2 = new Researcher("lol@bro.fu","blub","U","Mama", "Familie", LocalDateTime.now() , LocalDateTime.now());
        researcher2.addRole(new Role("RESEARCHER"));

        final Researcher researcher3 = new Researcher("Lekkere@Soep.fu","Pil","Shakira","Belgium", "Thuis", LocalDateTime.now() , LocalDateTime.now());
        researcher3.addRole(new Role("RESEARCHER"));
        researcher3.addRole(new Role("HEUMEUW"));

        final Researcher researcher4 = new Researcher("Kietel@brol.fu","bak","PRefix","test", "test", LocalDateTime.now() , LocalDateTime.now());
        researcher4.addRole(new Role("RESEARCHER"));
        researcher4.addRole(new Role("TESTER"));
        researcher4.addRole(new Role("TROL"));

        final Researcher researcher5 = new Researcher("Re5@brol.fu","pass5","5plep","plop", "kabouter", LocalDateTime.now() , LocalDateTime.now());
        researcher5.addRole(new Role("HEADRESEARCHER"));
        researcher5.addRole(new Role("TOPPIE"));


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                researcherRepo.save(researcher);
                researcherRepo.save(researcher2);
                researcherRepo.save(researcher3);
                researcherRepo.save(researcher4);
                researcherRepo.save(researcher5);
            }
        };
    }
}
