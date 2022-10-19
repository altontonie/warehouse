package thashort.gamer.warehouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class testController {

    @GetMapping(path = "/")
    public String test(){
        return "OK";
    }
}
