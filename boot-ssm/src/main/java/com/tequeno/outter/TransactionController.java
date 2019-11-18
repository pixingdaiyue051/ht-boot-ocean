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
        for (int i = 0; i < 5; i++) {
            try {
                areaService.testInsertUser(i);
                areaService.testInsertArea(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return HtResultInfoWrapper.success();
    }
}