package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NaturalPerson {
    private int id;
    private String fio;
    private String telephone;
    private String passport;
}
