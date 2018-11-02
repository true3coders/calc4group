package org.calc4group.dtos;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class UserDto {

    private Integer id;

    private String name;

    private String email;

    private String password;

}
