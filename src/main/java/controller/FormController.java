package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hello.UserInfo2;
import repository.DBService;

/**
 * Created by guille on 19/02/2017.
 */
@Controller
public class FormController {
    private final DBService service;

    @Autowired
    FormController(DBService service) {
        this.service = service;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, @RequestParam(value = "login") String login, 
    		@RequestParam(value = "password") String password, 
    		@RequestParam(value = "kind") String kind ) {
        // If the combination of login, password and kind is correct, the data of the user is returned
        // If not, 404 NOT FOUND is returned
        UserInfo2 user = service.getAgent(login, password,kind);

        if (user == null)
            return "usererror";
        else {
            model.addAttribute("name", user.getName());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("location", user.getLocation());
            model.addAttribute("kind", user.getKind());
            model.addAttribute("kindCode", user.getKindCode());

            //model.addAttribute("nif", citizen.NIF);
            return "info";
        }

    }
}
