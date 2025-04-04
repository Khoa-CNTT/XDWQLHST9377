package com.example.TanKhoaLearningCenterBE.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    public static String genrateToken(User user){
        return Jwts
                .builder()
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 5000000))
                .signWith(getSigninKey())
                .compact();
    }

    public static Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean isTokenValid(String token){
        return !isTokenExpried(token);
    }

    public static boolean isTokenExpried(String token){
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private static SecretKey getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode("6e5f9db3f11f7585ceaeb35550270e36ffd731f3961600dc349a92415cfdfdc7");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
