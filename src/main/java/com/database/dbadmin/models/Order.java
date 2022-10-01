package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private int id;
    private int natural_person_id;
    private int legal_entity_id;
    private int book_id;
    private int sum;
    private Date date;
}
