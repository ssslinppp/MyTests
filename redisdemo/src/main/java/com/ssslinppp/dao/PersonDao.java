package com.ssslinppp.dao;

import com.ssslinppp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: liulin
 * Date: 2017/7/18
 * Time: 16:10
 * Description：
 * To change this template use File | Settings | File Templates.
 */
//@SuppressWarnings("ALL")
@Repository
public class PersonDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate; //1

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr; //3

    @Autowired
    RedisTemplate<Object, Object> redisTemplate; //2

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps; //4

    public void stringRedisTemplateDemo() { //5
        valOpsStr.set("xx", "yy");
    }

    public String getString() {//7
        return valOpsStr.get("xx");
    }

    public void save(Person person) { //6
        valOps.set(person.getId(), person);
    }

    public Person getPerson() {//8
        return (Person) valOps.get("1");
    }

}
