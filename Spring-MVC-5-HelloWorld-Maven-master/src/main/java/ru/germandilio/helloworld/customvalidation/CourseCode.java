package ru.germandilio.helloworld.customvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeValidator.class)
public @interface CourseCode {
    String value() default "LUV";

    String message() default "Must start with \"LUV\" prefix";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
