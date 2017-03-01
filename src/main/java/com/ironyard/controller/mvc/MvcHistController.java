package com.ironyard.controller.mvc;

import com.ironyard.data.AppUser;
import com.ironyard.data.Hist;
import com.ironyard.repo.HistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@Controller
@RequestMapping(path = "/mvc/hist")
public class MvcHistController
{
    @Autowired
    private HistRepo histRepo;

    @RequestMapping(path = "/show", method = RequestMethod.GET)
    public String show(HttpServletRequest request, Model model)
    {
        Integer page = 0;
        Integer pageSize = 5;

        Sort sort;
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "timeStamp");
        sort = new Sort(order1);

        PageRequest pr = new PageRequest(page, pageSize, sort);
        AppUser appUser = (AppUser)request.getSession().getAttribute("appUser");
        Page<Hist> histList = histRepo.findByAppUser(appUser, pr);

        model.addAttribute("histList", histList);

        return "/secure/history";
    }

}
