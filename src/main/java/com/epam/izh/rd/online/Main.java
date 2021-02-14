package com.epam.izh.rd.online;

import com.epam.izh.rd.online.entity.Author;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Author author1=new Author("Nikita","Goncharov",LocalDate.of(1960, 12, 20) ,"Russia");
        Author author2 = new Author("Александр", "Козлов", LocalDate.of(1960, 12, 20), "Россия");

    }

}
