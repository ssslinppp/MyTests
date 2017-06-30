package com.ssslinppp.controller;

import com.ssslinppp.commons.properties.PropertiesGet;
import com.ssslinppp.model.PropertiesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liulin on 2017/6/28.
 */
@RestController
@RequestMapping("/prop")
public class PropController {

    @Autowired
    private PropertiesGet propertiesGet;

    @Autowired
    private PropertiesList propertiesList;

    @RequestMapping("/print")
    public String print(){
        return propertiesGet.printInfo();
    }

    @RequestMapping("/printProps")
    public String printProps(){
        System.out.println(propertiesList.toString());
        return propertiesList.toString();
    }

}
