package com.ssslinppp.controller;

import com.ssslinppp.dao.PersonDao;
import com.ssslinppp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: liulin
 * Date: 2017/7/18
 * Time: 16:24
 * Description：
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class DataController {
    @Autowired
    PersonDao personDao;

    @RequestMapping("/set") //1
    public void set() {
        Person person = new Person("1", "ssslinppp", 28);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr") //2
    public String getStr() {
        return personDao.getString();
    }

    @RequestMapping("/getPerson") //3
    public Person getPerson() {
        return personDao.getPerson();
    }

}
