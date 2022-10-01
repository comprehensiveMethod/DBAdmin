package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Provider {
    private int id;
    private String bank_account;
    private String bank_name;
    private String company_name;
    private String inn;
    private String address;
}
