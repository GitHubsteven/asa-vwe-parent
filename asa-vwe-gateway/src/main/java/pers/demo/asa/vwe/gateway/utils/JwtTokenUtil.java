package pers.demo.asa.vwe.gateway.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pers.demo.asa.vwe.gateway.bean.UserBean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author jet.xie
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: jwt辅助工具类
 * @date: Created at 19:50 2019/8/29.
 */
@Component
public class JwtTokenUtil implements Serializable {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static final long serialVersionUID = -2550185165626007488L;
    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationdateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }


    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //check if the token has expired
    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationdateFromToken(token);
        return expiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserBean userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * while creating the token
     * 1. Define claims of the token, like issuer, expiration, subject,and the id
     * 2. Sign the jwt using the HS512 algorithm and secret key
     * 3. According to jws compact serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)compaction of the JWT to a URL-safe string )
     *
     * @param claims
     * @param subject
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * validate token
     *
     * @param token       token
     * @param userDetails 用户信息
     * @return 检测结果
     */
    public boolean validateToken(String token, UserBean userDetails) {
        if (userDetails == null) {
            throw new RuntimeException("User not existed!");
        }
        final String username = getUsernameFromToken(token);
        if (isTokenExpired(token)) {
            throw new RuntimeException("Token is expired!");
        }
        if (!Objects.equals(username, userDetails.getUsername())) {
            throw new RuntimeException("Username and token not matched");
        }
        return true;
    }
}