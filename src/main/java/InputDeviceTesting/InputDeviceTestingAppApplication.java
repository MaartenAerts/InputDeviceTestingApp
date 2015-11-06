package InputDeviceTesting;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class InputDeviceTestingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }
    @Bean
    CommandLineRunner init(final ResearcherRepo researcherRepo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                researcherRepo.save(new Researcher("lol@brol.fu","trol"));
            }
        };
    }
}
