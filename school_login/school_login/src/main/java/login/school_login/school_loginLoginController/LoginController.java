package login.school_login.school_loginLoginController;

import login.school_login.school_loginLoginDomain.Login;
import login.school_login.school_loginLoginService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @Autowired
    private LoginService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") Login user ) {

        Login oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);

        if(Objects.nonNull(oauthUser))
        {
            ModelAndView mav = new ModelAndView("index");
            mav.addObject("user", oauthUser);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("user", new Login());
            return mav;
        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {


        return "redirect:/login";
    }

}
