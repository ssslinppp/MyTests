package com.ssslinppp.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: liulin
 * Date: 2017/7/18
 * Time: 16:08
 * Description：
 * To change this template use File | Settings | File Templates.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;

    public Person() {
        super();
    }

    public Person(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
