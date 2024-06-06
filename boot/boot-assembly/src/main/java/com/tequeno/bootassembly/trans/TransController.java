package com.tequeno.bootassembly.trans;

import com.tequeno.config.redis.RedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("trans")
public class TransController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("encrypt")
    @Encryption(Encryption.Type.ENCRYPT)
    public Map<String, String> encrypt() {
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

        Map<String, String> result = new HashMap<>();
        result.put("data", dataString);
        result.put("code", "0");

        return result;
    }

    @RequestMapping("decrypt")
    @Encryption(Encryption.Type.DECRYPT)
    public Map<String, String> decrypt(@RequestBody Map<String, String> map) {
        Map<String, String> res = new HashMap<>();
        res.put("data", map.get("param1"));
        res.put("code", "0");
        return res;
    }

    @RequestMapping("handshake")
    @Encryption
    public Map<String, String> handshake(@RequestBody Map<String, String> map) {
        Map<String, String> res = new HashMap<>();
        res.put("data", "hasta la vista baby");
        res.put("code", "0");
        return res;
    }

    @RequestMapping("exchange")
    public HtResultBinder exchange(@RequestParam String publicKey) {
        Map<String, String> keyPair = RsaUtil.genKeyPair();
        keyPair.put(RsaUtil.JS_PUBLIC_KEY, publicKey);
        redisUtil.hashMultiSetDefault(TransmissionAspect.ENC_KEY, keyPair);
        return HtResultInfoWrapper.success(keyPair.get(RsaUtil.PUBLIC_KEY));
    }
}