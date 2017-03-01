package com.ironyard.controller.mvc;

import com.ironyard.data.AppUser;
import com.ironyard.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jasonskipper on 2/6/17.
 */
@Controller
public class LoginController {

    @Autowired
    private AppUserRepo appUserRepo;


    @RequestMapping(path = "/mvc/weather/authenticate", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model data, @RequestParam(name = "username") String usr, @RequestParam String password)
    {

        AppUser found = appUserRepo.findByUsernameAndPassword(usr, password);
        String destinationView;
        if(found == null)
        {
            data.addAttribute("notify", 1);
            data.addAttribute("notifyMsg", "Invalid credentials!");
            destinationView = "/open/login";
        }
        else
        {
            data.addAttribute("notify", 0);
            request.getSession().setAttribute ("appUser", found);
            destinationView = "redirect:/mvc/weather/show";
        }
        return destinationView;
    }


    @RequestMapping(path = "/mvc/weather/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return "redirect:/secure";
    }
}
