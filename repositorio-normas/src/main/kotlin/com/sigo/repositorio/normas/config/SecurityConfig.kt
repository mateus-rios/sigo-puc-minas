package com.sigo.repositorio.normas.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http
                ?.authorizeRequests()
                ?.anyRequest()?.authenticated()
                ?.and()?.csrf()?.disable()
                ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ?.and()?.httpBasic()

    }

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Bean
    fun inMemoryUserDetailsManager(): UserDetailsService {

        val simpleUser = User
                .withUsername("gestao_normas")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("@123456ab")
                .roles("USER").build()

        val inMemoryDetails = InMemoryUserDetailsManager()
        inMemoryDetails.createUser(simpleUser)

        return inMemoryDetails
    }
}