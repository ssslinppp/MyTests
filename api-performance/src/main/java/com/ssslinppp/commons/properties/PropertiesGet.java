package com.ssslinppp.commons.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by liulin on 2017/6/28.
 */
@Component
@PropertySource("classpath:my.properties")
public class PropertiesGet {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    public String printInfo() {
        System.out.println("book name is:" + bookName + "  and book author is:" + bookAuthor);
        return bookName + ", " + bookAuthor;
    }
}
