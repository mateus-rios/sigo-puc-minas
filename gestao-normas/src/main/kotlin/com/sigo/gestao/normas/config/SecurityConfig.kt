package com.sigo.gestao.normas.config

import com.sigo.gestao.normas.config.filter.JwtFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig @Autowired constructor(
        private val jwtFilter: JwtFilter
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http
                ?.authorizeRequests()
                ?.antMatchers(HttpMethod.POST,"/auth")?.permitAll()
                ?.anyRequest()?.authenticated()
                ?.and()?.csrf()?.disable()
                ?.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
                ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

    }

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Bean
    fun inMemoryUserDetailsManager(): UserDetailsService {
        
        val simpleUser = User
                .withUsername("simpleUser")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("simpleUserPoc123")
                .roles("USER").build()

        val managerUser = User
                .withUsername("simpleManager")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("simpleManagerPoc123")
                .roles("ADMIN").build()

        val inMemoryDetails = InMemoryUserDetailsManager()
        inMemoryDetails.createUser(simpleUser)
        inMemoryDetails.createUser(managerUser)


        return inMemoryDetails
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}