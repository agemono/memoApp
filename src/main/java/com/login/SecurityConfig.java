package com.login;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	LoginUserDetailService uds;
	
	@Autowired
	private DataSource datasource;
	
	private static final String USER_SQL = "SELECT * "
											+ "FROM user_info WHERE user_id = ? ";
	
	private static final String ROLE_SQL = "SELECT user_id, role FROM user_info WHERE user_id = ?";

	@Override
	public void configure(WebSecurity web) throws Exception {
		//静的リソース除外
		web.ignoring().antMatchers( "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/loginprocessing").permitAll()
				.antMatchers("/error").permitAll()
				.antMatchers("/SignUp").permitAll() //ログイン、ユーザー登録はじかりんくOK 
				.anyRequest().authenticated();

		//ログイン処理

		http
				.formLogin()
				.loginPage("/login") 						//ログインページ
				.loginProcessingUrl("/loginprocessing")									
				.usernameParameter("user_id")
				.passwordParameter("password") 				//パスワード
				.failureUrl("/error")
				.defaultSuccessUrl("/memo", true); 			//ログイン成功後の遷移先
				
		//http.csrf().disable();
		//ログアウト処理
		
		/*http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login");*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//ユーザーデータの取得

			auth.jdbcAuthentication()
				.dataSource(datasource)
				.usersByUsernameQuery(USER_SQL)
				.authoritiesByUsernameQuery(ROLE_SQL)
				.passwordEncoder(passwordEncoder());
				
		//auth.userDetailsService(uds).passwordEncoder(passwordEncoder());
				
	}
}
