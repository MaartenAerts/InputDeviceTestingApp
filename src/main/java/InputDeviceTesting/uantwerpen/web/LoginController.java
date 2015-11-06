/*package InputDeviceTesting.uantwerpen.web;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.service.CustomUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Niels on 3/11/2015.
 */
/*@Controller
public class LoginController extends WebMvcConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService ;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/dashboard").setViewName("dashboard");
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String  displayLogin(Model model)
    {
        model.addAttribute("researcher", new Researcher());
        return "login";
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }


    /*@RequestMapping(value="/login",met    hod=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
    {
        ModelAndView model= null;
        try
        {
            boolean isValidUser = customUserDetailsService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
            if(isValidUser)
            {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", loginBean.getUsername());
                model = new ModelAndView("welcome");
            }
            else
            {
                model = new ModelAndView("login");
                model.addObject("loginBean", loginBean);
                request.setAttribute("message", "Invalid credentials!!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return model;
    }
}*/
