package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.AgentDTO;
import hello.AgentLogin;
import hello.UserInfo2;
import repository.DBService;

@RestController
public class APIController {

    private final DBService service;

    @Autowired
    APIController(DBService service) {
        this.service = service;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AgentDTO> user(@RequestBody AgentLogin login) {
        // If the combination of email and password is correct, the data of the user is returned
        // If not, 404 NOT FOUND is returned

        UserInfo2 user = service.getAgent(login.getLogin(), login.getPassword(),login.getKind());
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            AgentDTO agent = new AgentDTO(user);
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }

    }

}