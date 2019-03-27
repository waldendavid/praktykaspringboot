package pl.karololejniczak.springbootcourse.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karololejniczak.springbootcourse.model.UserDTO;

@RestController
@RequestMapping(value = "/")
public class Controller {

    @GetMapping(value = "/hello")
    public String hello() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Karol");
        return "Hello End UserDTO";
    }
}
