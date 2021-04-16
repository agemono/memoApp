package com.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	public void configure(WebSecurity web)throws Exception
	{
		//静的リソース除外
		web.ignoring().antMatchers(".webjars/**","/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/webjars/**").permitAll()			//webjarsにアクセス許可
				.antMatchers(".webjars/**","/css/**").permitAll()
				.antMatchers("/login").permitAll()			
				.antMatchers("/SignUp").permitAll()					//ログイン、ユーザー登録はじかりんくOK 
				.anyRequest().authenticated();
		
		
			//ログイン処理
		
		http
			.formLogin()
				.loginProcessingUrl("/login")
				
			
	}
}
