package com.dss.girl.controller;

import com.dss.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value="/hello",method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "id: == " + id;
        //return girlProperties.getCupSize() + "=====" + girlProperties.getAge();
    }
}
