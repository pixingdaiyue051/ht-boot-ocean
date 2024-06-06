package com.tequeno;

import com.tequeno.utils.HtEncoderUtil;
import org.junit.Test;

public class EncoderTest {

    @Test
    public void run() {
        String password = "123456";
        String salt = "4sgs12";

        String out = HtEncoderUtil.md5Encode(password, salt);
        System.out.println(out);

        String out1 = HtEncoderUtil.sha256Encode(password, salt);
        System.out.println(out1);
    }
}
