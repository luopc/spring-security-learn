package com.luopc.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.luopc.security.browser.session.MyExpiredSessionStrategy;
import com.luopc.security.login.AbstractChannelSecurityConfig;
import com.luopc.security.login.sms.SmsCodeAuthenticationSecurityConfig;
import com.luopc.security.properties.SecurityProperties;
import com.luopc.security.validate.ValidateCodeSecurityConfig;

@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {
	
	
	@Autowired
	private SecurityProperties securityProperties;	
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private  UserDetailsService userDetailsService;
	
	@Bean
	public  PasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		applyPasswordAuthenticationConfig(http);
		
		http
			.apply(validateCodeSecurityConfig)
				.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
				.and()
			.sessionManagement()
				.invalidSessionUrl("/session/invalid")
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredSessionStrategy(new MyExpiredSessionStrategy()).and()
				.and()
			.authorizeRequests()
				.antMatchers("/authentication/require",
					securityProperties.getBrowser().getLoginPage(),
					"/code/*","/session/invalid","/session/invalid.html").permitAll() //xxx可以直接绕过验证
			.anyRequest()
			.authenticated()
			.and().csrf().disable();		
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("static/**")
//	}
	
	

}
