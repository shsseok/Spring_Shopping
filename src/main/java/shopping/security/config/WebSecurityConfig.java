package shopping.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import shopping.security.jwt.JwtRequestFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/user/login.do", "/user/register.do").authenticated()
            .and()
            .formLogin()
            // 로그인 페이지를 제공하는 URL을 설정함
            .loginPage("view/main.do")
            // 로그인 성공 URL을 설정함
            .successForwardUrl("view/main.do")
            // 로그인 실패 URL을 설정함
            .failureForwardUrl("view/main.do")
            .permitAll()
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
            // JWT 인증 필터를 기본 인증 필터 전에 추가합니다.
    }

    // 필요한 경우 추가적인 Bean 구성이나 설정을 여기에 추가합니다.
}
