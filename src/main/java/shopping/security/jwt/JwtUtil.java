package shopping.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;
@Component
public class JwtUtil {

    private String secretKey = "GgOtk4nhSPpd-uj_4XSkGkZDo_MTDvqm3ooqceDvf38\r\n"; // 시크릿 키를 안전한 곳에 보관해야 합니다.
    // 생성자 만들어서 Base 64 인코딩 디코딩 활용

    // 토큰에서 사용자 이름 추출
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 토큰에서 만료 날짜 추출
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    //가져온 토큰의 본문을 
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    //토큰을 파싱하고 해당 토큰의 본문을 가져오는 부분이다 
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    // 토큰이 만료되었는지 확인
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 예: 10시간 후 만료
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }

    // 토큰이 유효한지 확인
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
