package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class SupplyRegistration {
    private int supply_id;
    private int book_id;
    private int company_id;
    private Date date;
}
