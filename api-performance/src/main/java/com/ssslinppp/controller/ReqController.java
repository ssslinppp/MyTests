package com.ssslinppp.controller;

import com.ssslinppp.model.ReqModel;
import com.ssslinppp.services.ReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.List;

/**
 * Created by liulin on 2017/6/27.
 */
@RestController
@RequestMapping("/api")
public class ReqController {

    @Autowired
    private ReqService reqService;

    @RequestMapping("/getModel")
    public ReqModel getModel() {
        System.out.println("---getModel-----");
        return reqService.getModel();
    }

    @RequestMapping(value = "/parseModel", method = RequestMethod.POST)
    public ReqModel parseReqModel(@RequestBody ReqModel reqModel) {
        System.out.println(reqModel.toString());
        return reqModel;
    }
}
