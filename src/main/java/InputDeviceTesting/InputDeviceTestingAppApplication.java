package InputDeviceTesting;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Role;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }
    @Bean
    CommandLineRunner init(final ResearcherRepo researcherRepo){
        final Researcher researcher = new Researcher("lol@brol.fu","trol","King","Potsac die 2e", "The anal organ", LocalDateTime.now() , LocalDateTime.now());
        Role role = new Role("HEUMEUW");
        List<Role> roleList = new ArrayList<Role>();
        roleList.add(role);
        researcher.setRoles(roleList);
        final Researcher researcher2 = new Researcher("kak@brol.fu","blub","U","Moeder", "U moeder op een fles", LocalDateTime.now() , LocalDateTime.now());
        final Researcher researcher3 = new Researcher("Lekkere@piemel.fu","pis","Sharia","Belgiums", "Allukahbar", LocalDateTime.now() , LocalDateTime.now());

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                researcherRepo.save(researcher);
                researcherRepo.save(researcher2);
                researcherRepo.save(researcher3);
            }
        };
    }
}
