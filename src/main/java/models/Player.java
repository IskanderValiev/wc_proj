package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
public class Player {

    private Long id;
    private int number;
    private String position;
    private String name;
    private String lastname;
    private int age;
    private String club;
    private String country;

}
