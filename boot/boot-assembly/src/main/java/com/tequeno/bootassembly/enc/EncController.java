package com.tequeno.bootassembly.enc;

import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("enc")
public class EncController {

    @RequestMapping("encrypt")
    public Map<String, Object> encrypt() throws Exception {

        long l1 = System.currentTimeMillis();

        String dataString = "Do not go gentle into that good night\n" +
                "\tDylan Thomas\n" +
                "\t\n" +
                "Do not go gentle into that good night\n" +
                "Old age should burn and rave at close of day\n" +
                "Rage,rage against the dying of the light\n" +
                "\n" +
                "Though wise man at their end know dark is right\n" +
                "Because their words had forked no lightning they\n" +
                "Do not go gentle into that good night\n" +
                "\n" +
                "Good men,the last wave by,crying how bright\n" +
                "Their frail deeds might have danced in a green bay\n" +
                "Rage,rage against the dying of the light\n" +
                "\n" +
                "Wild men who caught and sang the sun in flight\n" +
                "And lean,too late,they grieved it on its way\n" +
                "Do not go gentle into that good night\n" +
                "\n" +
                "Grave men,near death,who see with blinding sight\n" +
                "Blind eyes counld blaze like meteors and be gay\n" +
                "Rage,rage against the dying of light\n" +
                "\n" +
                "And you,myfather,there no the sad height,\n" +
                "Curse,bless,me now with your fierce tears,I pray\n" +
                "Do not go gentle into that good night\n" +
                "Rage,rage against the dying of the light";
        String key = AesUtil.getKey();
        String data = AesUtil.encrypt(dataString, key);
        String cipher = RsaUtil.encrypt(key, RsaUtil.getJsPublicKey());

        Map<String, Object> result = new HashMap<>();
        result.put("data", data);
        result.put("cipher", cipher);
        result.put("success", true);
        result.put("code", "0");


        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        return result;
    }

    @RequestMapping("decrypt")
    public HtResultBinder decrypt(@RequestBody Map<String, String> map) throws Exception {

        long l1 = System.currentTimeMillis();

        String aesKey = RsaUtil.decrypt(map.get("cipher"));
        String decrypt = AesUtil.decrypt(map.get("data"), aesKey);

        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);

        return HtResultInfoWrapper.success(decrypt);
    }

    @RequestMapping("exchange")
    public String exchange(@RequestParam String publicKey) {
        RsaUtil.putJsPublicKey(publicKey);
        return RsaUtil.getPublicKey();
    }
}