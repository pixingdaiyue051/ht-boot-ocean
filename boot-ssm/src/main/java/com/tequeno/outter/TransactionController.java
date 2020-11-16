package com.tequeno.outter;

import com.tequeno.bootssm.service.area.AreaService;
import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/tran")
public class TransactionController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("test1")
    public HtResultBinder test1() {
        areaService.testInsertArea1();
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("test2")
    public HtResultBinder test2() {
        areaService.testInsertArea2();
        return HtResultInfoWrapper.success();
    }
}