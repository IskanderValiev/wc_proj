package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class News {

    private Long id;
    private String header;
    private String content;
    private String image;
    private Date date;
    private String type;
}