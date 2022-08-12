package com.mak.hoxify.user;

import lombok.Data;

//Lombok plays constructor getter setters and others
@Data
public class User {
    private String userName;
    private String displayName;
    private String password;
}
