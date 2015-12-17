package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import InputDeviceTesting.uantwerpen.web.ReasearcherController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Joelg on 16/12/2015.
 * (testen met mockito niet gelukt
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)

public class ReasearcherControllerTest {

   // @Mock
   // private CustomUserDetailsService customUserDetailsService;

   // @InjectMocks
   // private ReasearcherController reasearcherController;
  //  private MockMvc mockMvc;
   @Autowired
   WebApplicationContext wac;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
  //      MockitoAnnotations.initMocks(this);
  //      mockMvc = MockMvcBuilders.standaloneSetup(reasearcherController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }



    @Test
    public void testMocky() throws Exception {
       //Lijst opstellen
      // List<Researcher> researcher = new ArrayList<>();
      // researcher.add(new Researcher());
      // researcher.add(new Researcher());

       //wanneer customUserDetailsService betrokken wordt, willen we een researcher-list terug
      //  when(customUserDetailsService.findAll()).thenReturn((List) researcher);
//String yo = "hello";
        //mockMvc.perform(get("/researcherView?sort=yo"))
                //.andExpect(status().isOk()) //verwachten status=ok
              // .andExpect(view().name("researchers")) //verwachten als view 'researchers'
              //  .andExpect(model().attribute("researcher", hasSize(2)));//verwachten 2 researchers in lijst

        Researcher user = new Researcher();
        user.setEmail("test@best.be");

        session.setAttribute("sessionParm",user);
        this.mockMvc.perform(get("/researchers").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("researchers"));

      //  this.mockMvc.perform(get("/researcherView?sort=yo").session(session)
     //           .accept(MediaType.TEXT_HTML))
      //          .andExpect(status().isOk())
       //         .andExpect(view().name("researchers"));

   }


    @After
    public void tearDown() throws Exception {

    }

}