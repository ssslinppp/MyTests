package com.ssslinppp.controller;

import com.ssslinppp.enumConvert.baseEnumImpl.FuncEnum;
import com.ssslinppp.model.EnumModel;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: liulin
 * Date: 2017/6/30
 * Time: 20:53
 * Description：
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/enum")
public class EnumController {
    @RequestMapping("/get")
    @ResponseBody
    public EnumModel get(){
        EnumModel enumModel = new EnumModel();
        enumModel.setFuncEnum(FuncEnum.AVG);
        return enumModel;
    }

    @RequestMapping("/print")
    public String printEnums(@RequestBody EnumModel enumModel, @RequestParam("pathEnum") FuncEnum pathEnum) {
        System.out.println("[" + enumModel.getFuncEnum().getName() + ":" + enumModel.getFuncEnum().getDesc() + "]");
        System.out.println("[" + pathEnum.getName() + ":" + pathEnum.getDesc() + "]");
        return "[" + pathEnum.getName() + ":" + pathEnum.getDesc() + "]";
    }
}
