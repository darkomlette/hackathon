package com.hcl.hackathon.annotation;

import com.hcl.hackathon.constant.RemoveInvalidCharactersValidator;
import org.springframework.messaging.handler.annotation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
@Constraint(validatedBy = RemoveInvalidCharactersValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoveInvalidCharacters {
    String message() default "Invalid characters found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
