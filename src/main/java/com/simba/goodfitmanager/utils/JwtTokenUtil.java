package com.simba.goodfitmanager.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

//    // 寻找证书文件
//    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks"); // 寻找证书文件
//    private static PrivateKey privateKey = null;
//    private static PublicKey publicKey = null;

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET = "secret";
    private static final String ISS = "simba";
    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = 3600L;
    // 选择了记住我之后的过期时间为7天
    private static final long EXPIRATION_REMEMBER = 604800L;
    // 添加角色的key
    private static final String ROLE_CLAIMS = "rol";

//    static { // 将证书文件里边的私钥公钥拿出来
//        try {
//            KeyStore keyStore = KeyStore.getInstance("JKS"); // java key store 固定常量
//            keyStore.load(inputStream, "123456".toCharArray());
//            privateKey = (PrivateKey) keyStore.getKey("jwt", "123456".toCharArray()); // jwt 为 命令生成整数文件时的别名
//            publicKey = keyStore.getCertificate("jwt").getPublicKey();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     * 生成token
//     * @param subject （主体信息）
//     * @param expirationSeconds 过期时间（秒）
//     * @param claims 自定义身份信息
//     * @return
//     */
    public static String generateToken(String username, String role, boolean isRememberMe) {
        long expirationSeconds = isRememberMe ? EXPIRATION_REMEMBER : EXPIRATION;
        Map<String, Object> claims = new HashMap<>();
        claims.put(ROLE_CLAIMS, role);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(claims)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
//                .signWith(SignatureAlgorithm.HS512, salt) // 不使用公钥私钥
//                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

//    /**
//     * 获取主体信息
//     * @param token
//     * @param salt
//     * @return
//     */
    public static String getUsername(String token) {
        String username = null;
        try {
            /*Claims claims = Jwts.parser()
//                    .setSigningKey(salt) // 不使用公钥私钥
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();*/
            username = getTokenBody(token).getSubject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    /**
     * // 是否已过期
     * @param token
     * @return
     */
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    //获取token自定义属性
//    public static Map<String,Object> getClaims(String token){
//        Map<String,Object> claims = null;
//        try {
//            claims = getTokenBody(token);
//        }catch (Exception e) {
//        }
//
//        return claims;
//    }
    public static String getUserRole(String token) {
        String role = null;
        try{
            role = (String) getTokenBody(token).get(ROLE_CLAIMS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }


    private static Claims getTokenBody(String token){
        return Jwts.parser()
//                .setSigningKey(publicKey)
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }


}
