import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}
class SignupForm {

    @NotBlank
    String username;

    @NotBlank
    @MaxLength(10)
    String password;

    SignupForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
class Validator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);

                String value = (String) field.get(obj);
                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength max = field.getAnnotation(MaxLength.class);

                    if (value != null && value.length() > max.value()) {
                        errors.add(field.getName()
                                + " cannot be more than "
                                + max.value() + " characters");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return errors;
    }
}
public class Main {
    public static void main(String[] args) {
        SignupForm form =
                new SignupForm("", "verylongpassword123");
        List<String> errors = Validator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}