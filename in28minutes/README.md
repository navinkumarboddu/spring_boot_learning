### Course Link
Udemy - https://www.udemy.com/course/spring-boot-tutorial-for-beginners

### Tools used in the developing the project
    1. Java
    2. Spring Boot 3.2.5
    3. Spring Web, Security, Validation, Tomcat, Thymeleaf, Devtools
    4. Junit
    5. Webjars for BootStrap css and JQuery
    6. Maven and Plugins - spotless-maven-plugin, maven-compiler-plugin

### Issues faced in Spring Security
1. 
```xml
   In Spring Security 5.7.0-M2 we deprecated the WebSecurityConfigurerAdapter, as we encourage users to move towards a component-based security configuration.
      For more reference - Read : https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter   
```

2.
```xml
Facing 403 error : 
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu May 09 22:49:01 IST 2024
There was an unexpected error (type=Forbidden, status=403).
Forbidden

User
Request URL:
http://localhost:8080/add-todo
Request Method:
POST
Status Code:
403 Forbidden
Remote Address:
[::1]:8080
Referrer Policy:
strict-origin-when-cross-origin

If your Spring Security configuration includes CSRF protection, ensure that your form submission includes the CSRF token. Spring Security requires CSRF tokens for non-GET requests by default. You can include the CSRF token in your form using Thymeleaf's th:csrf attribute.

<!-- Include CSRF token -->
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
```