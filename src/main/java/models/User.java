package models;

import lombok.*;

import java.sql.Date;

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
    private Date bday;
    private String city;
    private boolean gender;
    private String telephone;
    private String salt;

}
