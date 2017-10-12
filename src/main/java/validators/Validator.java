package validators;

public class Validator {

    public static boolean isCorrect(String login, String password, String name,
                                    String lastname, String cpassword, String gender,
                                    String city, String bday, String telephone, String email) {

        return login != null &&
                password != null &&
                password.equals(cpassword) &&
                name != null &&
                lastname != null &&
                gender != null &&
                bday != null &&
                city != null &&
                email != null &&
                telephone != null;
    }
}
