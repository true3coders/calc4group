package org.calc4group.dtos;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class UserDto {

    private Integer userId;
    private String name;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
