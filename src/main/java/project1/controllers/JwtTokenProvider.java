//package project1.controllers;
//
//import java.nio.file.attribute.UserPrincipal;
//import java.security.Signature;
//import java.sql.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class JwtTokenProvider {
//
//	@Value("${app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;
//
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        Date now = new Date(jwtExpirationInMs);
//        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
//
//        return Jwt.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date())
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public String getUsernameFromToken(String token) {
//        Claims claims = Jwt.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    private boolean isTokenExpired(String token) {
//        Date expirationDate = getExpirationDateFromToken(token);
//        return expirationDate.before(new Date(jwtExpirationInMs));
//    }
//
//    private Date getExpirationDateFromToken(String token) {
//        Claims claims = Jwt.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//        return claims.getExpiration();
//    }
//}
