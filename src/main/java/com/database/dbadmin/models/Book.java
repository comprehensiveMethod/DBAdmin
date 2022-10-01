package com.database.dbadmin.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private Long id;
    private String author;
    private String book_name;
    private Date publication_date;
    private String publisher_name;
    private String genre;
    private int pages;
    private String book_brief_description;

}
