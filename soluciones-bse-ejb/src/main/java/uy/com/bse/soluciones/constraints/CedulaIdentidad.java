package uy.com.bse.soluciones.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CedulaIdentidadValidator.class)
public @interface CedulaIdentidad {
	
	String message() default "{uy.com.bse.soluciones.cedulaIdentidad}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}