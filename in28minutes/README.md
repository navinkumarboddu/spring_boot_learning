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

Solution --->

If your Spring Security configuration includes CSRF protection, ensure that your form submission includes the CSRF token. Spring Security requires CSRF tokens for non-GET requests by default. You can include the CSRF token in your form using Thymeleaf's th:csrf attribute.

<!-- Include CSRF token -->
<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
```

3.
```xml
<fieldset class="form-group">
    <label for="targetDate">Target Date</label>
    <!-- <input type="date" id="targetDate" th:field="*{targetDate}" class="form-control" required="required" /> -->
    <input type="date" id="targetDate" th:value="${#dates.format(todo.targetDate, 'yyyy-MM-dd')}" required="required"/>
    <br/>
    <small class="form-text text-warning" th:if="${#fields.hasErrors('targetDate')}" th:errors="*{targetDate}"></small>
</fieldset>

org.springframework.validation.BeanPropertyBindingResult: 1 errors
Field error in object 'todo' on field 'targetDate': rejected value [2024-05-17]; codes [typeMismatch.todo.targetDate,typeMismatch.targetDate,typeMismatch.java.util.Date,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [todo.targetDate,targetDate]; arguments []; default message [targetDate]]; default message [Failed to convert property value of type 'java.lang.String' to required type 'java.util.Date' for property 'targetDate'; Failed to convert from type [java.lang.String] to type [java.util.Date] for value [2024-05-17]]

Solution --->

        #1 
           a. Create a class that implements Converter<String, Date>, where String is the source type (String representation of the date) and Date is the target type (java.util.Date).
           b. Implement the convert method to perform the conversion logic. 
        Check -> https://github.com/navinkumarboddu/spring_boot_learning/tree/main/in28minutes/src/main/java/com/in28minutes/springboot/web/conmverter/StringToDateConverter.java

        #2 Register the converter in your Spring MVC configuration.
        Check -> https://github.com/navinkumarboddu/spring_boot_learning/blob/main/in28minutes/src/main/java/com/in28minutes/springboot/web/WebMvcConfig.java


```