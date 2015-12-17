package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.web.ReasearcherController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import InputDeviceTesting.uantwerpen.web.RegisterController;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static javafx.beans.binding.Bindings.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.Assert.*;

/**
 * Created by Joelg on 15/12/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)
public class RegisterControllerTest {
    @Autowired
    WebApplicationContext wac;
    @Autowired
    MockHttpSession session;
    @Autowired
    MockHttpServletRequest request;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void Statustest() throws Exception {
        Researcher user = new Researcher();
        user.setEmail("test@best.be");

        session.setAttribute("sessionParm",user);
        this.mockMvc.perform(get("/register").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
        System.out.println("blublublublublublub:" + mockMvc);

        this.mockMvc.perform(post("/register")
                .param("email", "")
                .param("firstName", "mvcfirst")
                .param("lastName", "mvclastname"))
                .andExpect(status().isOk());
           //     .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
              //  .andExpect(model().setViewName("page_error"));

    }

    @Test
    public void testModelandview() throws Exception {

        ModelAndView mav = new ModelAndView();

        Researcher user = new Researcher();
        user.setEmail("test@best.be");

    }
}