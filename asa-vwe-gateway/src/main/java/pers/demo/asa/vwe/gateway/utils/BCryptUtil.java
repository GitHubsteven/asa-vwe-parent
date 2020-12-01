package pers.demo.asa.vwe.gateway.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/11/30
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BCryptUtil {

    /**
     * 给密码hash加密
     *
     * @param password 密码
     * @return 加密后的hash值
     */
    public static String hashPw(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * 比较密码和hash
     *
     * @param password 密码
     * @param hash     hash值
     * @return boolean型，true表示相等，false表示不等
     */
    public static boolean compare(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
