package project1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
			
	
	@Bean
	public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
							.requestMatchers("/mydb-console/**",
												"/api/**")
							.permitAll()
							.requestMatchers("/api/student/login").permitAll()
							.anyRequest().authenticated()
//							 .and()
//				               .formLogin()
//				               .loginPage("/login")
//				               .loginProcessingUrl("/login")
//				               .usernameParameter("email")
//				               .passwordParameter("password")
//				               .defaultSuccessUrl("/home", true)
//				               .failureUrl("/login?error")
//				               .permitAll()
//							   .and()
//							   .logout()
//							   .logoutUrl("/logout")
//							   .logoutSuccessUrl("logout?success")
//							   .and()
//							   .httpBasic();
							)
		.cors().disable().csrf().disable().headers().frameOptions().disable();
		
		return http.build();
	}

}
