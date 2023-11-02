package dat108.oblig4.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {

	String message() default "Fields values don't match!";

    String field();

    String fieldMatch();
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
	
}
