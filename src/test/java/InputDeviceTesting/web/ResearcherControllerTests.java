package InputDeviceTesting.web;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.web.ResearcherRestController;
import org.apache.http.client.HttpClient;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.google.gson.Gson;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;


/**
 * Created by Niels on 30/10/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
@WebAppConfiguration
public class ResearcherControllerTests {

    private MockMvc mockMvc;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private ResearcherRepo researcherRepo;

    @Autowired
    private ResearcherRestController researcherRestController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private Researcher researcher;
    private Gson gson = new Gson();
    String json;
    String serviceURL = "http://localhost:8086/api/researcher/";
    HttpClient httpClient;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(researcherRestController)
                .build();
    }

   /* @Test
    public void findResearchers() throws Exception{

        this.mockMvc
                .perform(
                        get

    }*/

    @Test
    public void testSaveResearcher() throws Exception  {

        // create our object as a json string
        researcher = new Researcher("trol@mail.com","trol");
            json = gson.toJson(researcher);
        System.out.println(json);

        // create our object as a json string
        //researcher = new Researcher("potzak@mail.com","pot");
        //    json = gson.toJson(researcher);
        //System.out.println(json);

        this.mockMvc
                .perform(
                        post("/api/researcher/").content(json)
                                .contentType(APPLICATION_JSON_UTF8))
                        .andExpect(status().isCreated());
    }

    @Test
    public void testResearcherAlreadyExists() throws Exception {
        // create our object as a json string
        researcher = new Researcher("lol@brol.fu","trolol"); // email bestaat al en zou conflicten moeten geven.
        json = gson.toJson(researcher);
        System.out.println(json);

        this.mockMvc
                .perform(
                        post("/api/researcher/").content(json)
                                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isConflict());

    }
}


