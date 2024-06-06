package com.tequeno;

import com.tequeno.utils.HtDateUtil;
import org.junit.Test;

public class DateTest {

    @Test
    public void run() {

        String out = HtDateUtil.now();
        System.out.println(out);

        String out1 = HtDateUtil.nowDateNum();
        System.out.println(out1);
    }
}
