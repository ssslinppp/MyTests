package com.ssslinppp.services;

import com.ssslinppp.model.ReqModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liulin on 2017/6/27.
 */
@Service
public class ReqService {

    public ReqModel getModel() {
        return ReqModel.newDefaultReqModel();
    }
}
