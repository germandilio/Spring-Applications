package ru.germandilio.helloworld;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import ru.germandilio.helloworld.customvalidation.CourseCode;

import java.util.List;
import java.util.Locale;

@Getter
@Setter
public class Student {
    private static final String REQUIRED_MESSAGE = "Required field";

    @NotNull(message = REQUIRED_MESSAGE)
    @Size(min = 1, message = REQUIRED_MESSAGE)
    private String lastName;

    @NotNull(message = REQUIRED_MESSAGE)
    @Pattern(regexp = "^[^0-9]+$", message = "Name must not contain numbers")
    private String firstName;

    @NotNull(message = REQUIRED_MESSAGE)
    @Min(value = 1, message = "Min age: 1")
    @Max(value = 100, message = "Max age: 100")
    private Integer age;

    @NotNull(message = REQUIRED_MESSAGE)
    @Size(min = 1, message = REQUIRED_MESSAGE)
    private String country;

    @NotNull(message = REQUIRED_MESSAGE)
    private String favouriteLanguage;

    @Size(min = 1, message = "Choose at least one option")
    private List<String> operatingSystems;

    @CourseCode(message = "Course code should start with \"LUV\"")
    private String courseCode;

    public String getBeatifyCountry() {
        if (country != null && country.length() > 0) {
            return country.substring(0, 1).toUpperCase(Locale.ROOT) + country.substring(1).toLowerCase(Locale.ROOT).replace('_', ' ');
        }
        return country;
    }
}
