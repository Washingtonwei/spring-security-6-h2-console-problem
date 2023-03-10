# spring-security-6-h2-console-problem
There seems to be a problem accessing the H2 console page from the browser in Spring Security 6.

When I upgraded my Spring Boot 2.7.7 project to Spring Boot 3.0.1, the H2 console browser access is denied (403).

Please take a look at the SecurityConfiguration class under package configuration.

For Spring Boot 2.7.7, here is the code.
```java
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/h2-console/**").permitAll()
                )
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringAntMatchers("/h2-console/**"));
        return http.build();
    }

}
``` 

For Spring Boot 3.0.1, here is the updated code.
```java
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                )
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**"));
        return http.build();
    }

}
``` 

In Spring Security 6 (Spring Boot 3.0.1), the access to the H2 console page is denied (403).

To reproduce this, check out the first commit (Spring Boot 2.7.7 version), launch the project, and type "localhost:8080/h2-console" in the browser address bar. You should see the H2 console page.

Then, check out the second commit (Spring Boot 3.0.1 version), launch the project, and type "localhost:8080/h2-console" in the browser address bar. H2 console page is denied.
