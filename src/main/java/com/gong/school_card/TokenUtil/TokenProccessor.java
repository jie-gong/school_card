package com.gong.school_card.TokenUtil;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * @author zhous
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.TokenUtil.TokenProccessor
 * @Date: 2022年10月12日 14:20
 * @Description: 生成Token的工具类
 */
public class TokenProccessor {

    private TokenProccessor() {
    }

    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     *
     * @return
     */
    public static String makeToken(String str) {
        String token = (System.currentTimeMillis() + new Random().nextInt()) +str;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return makeToken(str);
    }
}
