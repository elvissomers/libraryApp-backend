package wt.bookstore.backend.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    @Override
    public void initialize(NameConstraint emailNumber) {
    }

    @Override
    public boolean isValid(String nameField,
                           ConstraintValidatorContext cxt) {
        String namePattern = "^[a-zA-Z]{1}[a-zA-Z- ]{0,62}[a-zA-Z]{1}$";
        return patternMatches(nameField, namePattern);
    }


}
