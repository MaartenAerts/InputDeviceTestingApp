package InputDeviceTesting.uantwerpen.model.tests;

import InputDeviceTesting.InputDeviceTestingAppApplication;
import InputDeviceTesting.uantwerpen.model.Researcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Joelg on 17/12/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = InputDeviceTestingAppApplication.class)

public class DashboardControllerTest {

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

     //   Researcher user = new Researcher();
     //   user.setEmail("test@best.be");

    //    session.setAttribute("sessionParm",user);
     //   this.mockMvc.perform(get("/dashboard").session(session)
     //           .accept(MediaType.TEXT_HTML))
     //           .andExpect(status().isOk())
      //          .andExpect(view().name("dashboard"));

    }

}