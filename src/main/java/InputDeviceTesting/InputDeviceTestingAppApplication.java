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
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@EnableGlobalMethodSecurity(securedEnabled = true)
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }
    @Bean
    CommandLineRunner init(final ResearcherRepo researcherRepo){
        final Researcher researcher = new Researcher("lol@brol.fu","trol","King","Lepel", "organ", LocalDateTime.now() , LocalDateTime.now());
        Role role = new Role("HEADRESEARCHER");
        List<Role> roleList = new ArrayList<Role>();
        Role testRole = new Role("LEUTROL");
        roleList.add(role);
        roleList.add(testRole);
        researcher.setRoles(roleList);

        final Researcher researcher2 = new Researcher("lol@bro.fu","blub","U","Mama", "Familie", LocalDateTime.now() , LocalDateTime.now());
        final Researcher researcher3 = new Researcher("Lekkere@Soep.fu","Pil","Shakira","Belgium", "Thuis", LocalDateTime.now() , LocalDateTime.now());
        Role role2 = new Role("RESEARCHER");
        List<Role> roleList2 = new ArrayList<Role>();
        roleList2.add(role2);
        researcher2.setRoles(roleList2);
        Role role3 = new Role("TESTER");
        List<Role> roleList3 = new ArrayList<Role>();
        roleList3.add(role3);
        researcher3.setRoles(roleList3);

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
