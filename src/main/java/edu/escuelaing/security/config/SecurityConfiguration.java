package edu.escuelaing.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
        public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        JwtRequestFilter jwtRequestFilter;
        public SecurityConfiguration( @Autowired JwtRequestFilter jwtRequestFilter )
        {
                this.jwtRequestFilter = jwtRequestFilter;
        }

        @Override
        protected void configure( HttpSecurity http )
                throws Exception
        {

                http.addFilterBefore( jwtRequestFilter,
                        BasicAuthenticationFilter.class ).cors().and().csrf().disable().authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/securityInfo/health" )
                        .permitAll().antMatchers( HttpMethod.POST, "/user" )
                        .permitAll().antMatchers( HttpMethod.POST, "/securityInfo/auth/user" )
                        .permitAll().antMatchers( HttpMethod.GET, "/user" )
                        .permitAll().antMatchers( HttpMethod.POST, "/user/stole" )
                        .permitAll().antMatchers( HttpMethod.GET, "/user/zone" )
                        .permitAll().antMatchers( HttpMethod.GET, "/user/verifyZone" )
                        .permitAll().anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS );

        }
}