package users;

import lombok.*;

/**
 * Created by isko on 9/24/17.
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class User {

    private Long id;
    private String login;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String bday;
    private String city;
    private String gender;
    private String telephone;
}
