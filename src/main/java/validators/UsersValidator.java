package validators;

import java.sql.Date;

public class UsersValidator {

    public static boolean isCorrect(String login, String password, String cpassword,
                                    String name, String lastname, String city,
                                    Date bday, String telephone, String email) {

        return login != null &&
                password != null &&
                password.equals(cpassword) &&
                name != null &&
                lastname != null &&
                bday != null &&
                city != null &&
                email != null &&
                telephone != null;
    }
}
