package spring.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailValidator.class) //marks an annotation as being a Bean Validation constraint. The element validatedBy specifies the classes implementing the constraint.
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE }) // define if this annotation can be annotated to a class, method, field ...
@Retention(RetentionPolicy.RUNTIME) //specifies how the marked annotation is stored. We choose RUNTIME, so it can be used by the runtime environment.
@Documented //annotation is included in javadoc
public @interface ValidEmail {
	String message() default "Invalid email";	//defines the message that will be showed when the input data is not valid

	Class<?>[] groups() default {};	//lets the developer select to split the annotations into different groups to apply different validations to each group

	Class<? extends Payload>[] payload() default {}; //Payloads are typically used to carry metadata information consumed by a validation client.
}
