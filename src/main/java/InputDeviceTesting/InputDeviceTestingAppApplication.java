package InputDeviceTesting;

import InputDeviceTesting.uantwerpen.model.*;
import InputDeviceTesting.uantwerpen.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class InputDeviceTestingAppApplication {



    public static void main(String[] args) {

        SpringApplication.run(InputDeviceTestingAppApplication.class, args);
    }


    @Bean
    CommandLineRunner init(final TestResultRepo testResultRepo, final TestSequenceRepo testSequenceRepo, final ResearcherRepo researcherRepo, final ResearchGroupRepo researchGroupRepo, final TestRepo testRepo, final DeviceRepo deviceRepo, final TestSubjectRepo testSubjectRepo) {
        final Researcher researcher = new Researcher("lol@brol.fu", "trol", "King", "Lepel", "organ", LocalDateTime.now(), LocalDateTime.now());
        researcher.addRole(new Role("HEADRESEARCHER"));
        researcher.addRole(new Role("RESEARCHER"));
        researcher.addRole(new Role("LEUTROL"));

        final Researcher researcher2 = new Researcher("lol@bro.fu", "blub", "PAPA", "Mama", "Familie", LocalDateTime.now(), LocalDateTime.now());
        researcher2.addRole(new Role("RESEARCHER"));

        final Researcher researcher3 = new Researcher("Lekkere@Soep.fu", "Pil", "Shakira", "Belgium", "Thuis", LocalDateTime.now(), LocalDateTime.now());
        researcher3.addRole(new Role("RESEARCHER"));

        final Researcher researcher4 = new Researcher("Kietel@brol.fu", "bak", "PRefix", "test", "test", LocalDateTime.now(), LocalDateTime.now());
        researcher4.addRole(new Role("RESEARCHER"));
        researcher4.addRole(new Role("TESTER"));
        researcher4.addRole(new Role("TROL"));

        final Researcher researcher5 = new Researcher("Re5@brol.fu", "pass5", "5plep", "plop", "kabouter", LocalDateTime.now(), LocalDateTime.now());
        researcher5.addRole(new Role("HEADRESEARCHER"));
        researcher5.addRole(new Role("TOPPIE"));

        final TestSubject testSubject2 = new TestSubject("alain", "van dam", "vijske", "synalco medics", "alain@synalco.com");
        final TestSubject testSubject3 = new TestSubject("Baltazaar", "boma", "vrouwezot", "boma vleesindustrie nv", "boma@vleesindustrie_nv.com");
        final TestSubject testSubject4 = new TestSubject("carmen", "waterslager", "poets", "boma vleesindustrie nv", "carmen@vleesindustrie_nv.com");
        final TestSubject testSubject5 = new TestSubject("markske", "vertongen", "loemp", "boma vleesindustrie nv", "markske@vleesindustrie_nv.com");
        final TestSubject testSubject6 = new TestSubject("bieke", "de bakker", "", "boma vleesindustrie nv", "bieke@vleesindustrie_nv.com");
        final TestSubject testSubject7 = new TestSubject("fernand", "costermans", "vrouwezot", "antiek", "fenrand@antiek.com");
        final TestSubject testSubject8 = new TestSubject("pascalleke", "de bakker", "", "caféke", "pascalle@café.com");



        final ResearchGroup researchGroup1 = new ResearchGroup();
        researchGroup1.setCreator(researcher);
        researchGroup1.setGroupName("Group Name");
        researchGroup1.setCreatedDate(LocalDateTime.now());
        researchGroup1.setModifiedDate(LocalDateTime.now());
        researchGroup1.addResearcher(researcher);
        Device device2 = new Device("playstation kaske", "Logitech", "4.1");
        Device device = new Device("Muis", "Logitech", "1.0");
        Test test = new Test("Degelijke titel",
                device, 25, 10, "red", "yellow", "blue", "green", "black");
        List<TestSubject> testSubjects = IntStream.range(0, 9)
                .mapToObj(i -> new TestSubject("test", "test2", "testje", "hallo", i + "@test.com", test)).collect(Collectors.toList());
        Random random = new Random(System.currentTimeMillis());


        TestSequence testSequence1 = new TestSequence(0, 250, 25);
        TestSequence testSequence2 = new TestSequence(1, 500, 50);
        TestSequence testSequence3 = new TestSequence(2, 150, 15);

        List<TestSequence> testSequences = new ArrayList<TestSequence>();
        List<TestResult> fullTestResult = new ArrayList<TestResult>();
        testSequences.add(testSequence1);
        testSequences.add(testSequence2);
        testSequences.add(testSequence3);
        test.setTestSequences(testSequences);
        // test.setTestSubjects(testSubjects);
        for (TestSubject testSubject : testSubjects) {
            List<TestResult> testResults = new ArrayList<TestResult>();
            for (TestSequence testSequence : testSequences) {
                TestResult testResult = new TestResult(testSubject, random.doubles(200, 400).findFirst().getAsDouble(),
                        random.doubles(0, 50).findFirst().getAsDouble(),
                        random.doubles(6, 20).findFirst().getAsDouble(),
                        random.doubles(0, 4).findFirst().getAsDouble(),
                        random.doubles(600, 800).findFirst().getAsDouble(),
                        random.doubles(0, 10).findFirst().getAsDouble(),
                        random.doubles(10, 20).findFirst().getAsDouble());
//                testResults.add(testResult);
                testSequence.addTestResult(testResult);
            }
            testSubject.setTestResultList(testResults);
        }

//            fullTestResult.addAll(testResults);
        researchGroup1.addTest(test);


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                researcherRepo.save(researcher);
                researcherRepo.save(researcher2);
                researcherRepo.save(researcher3);
                researcherRepo.save(researcher4);
                researcherRepo.save(researcher5);
                researcher5.addRole(new Role("LOLOLOLO"));
                researcherRepo.save(researcher5);
                testSubjectRepo.save(testSubject2);
                testSubjectRepo.save(testSubject3);
//                deviceRepo.save(device);
                deviceRepo.save(device2);
                testSubjectRepo.save(testSubjects);

                testSubjectRepo.save(testSubject4);
                testSubjectRepo.save(testSubject5);
                testSubjectRepo.save(testSubject6);
                testSubjectRepo.save(testSubject7);
                testSubjectRepo.save(testSubject8);
//                testSequenceRepo.save(testSequences);
//
//                testRepo.save(test);
//
//                testSequenceRepo.save(testSequences);
                researchGroupRepo.save(researchGroup1);

                //   testResultRepo.save(fullTestResult);
            }
        };
    }
}
