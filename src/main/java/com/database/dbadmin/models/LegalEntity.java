package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LegalEntity {
    private int id;
    private String FIO_header;
    private String address;
    private String phone_number;
    private String bank_name;
    private String bank_account;
    private String inn;
    private String customer_name;
}
