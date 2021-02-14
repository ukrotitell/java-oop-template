package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.service.AuthorService;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[]{};
    public static int currentNumber = 0;

    // private AuthorRepository authorRepository;
    @Override
    public boolean save(SchoolBook book) {
        //author = authorService.findByFullName(books[0].getAuthorName(), books[0].getAuthorLastName());

        schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length + 1);
        schoolBooks[schoolBooks.length - 1] = book;
        return true;
      /*  if (currentNumber == schoolBooks.length) {
            return true;
        } else return false;*/

    }

    @Override
    public SchoolBook[] findByName(String name) {// ищет все книги по имени
        int foundBooks = 0;

            for (int i = 0; i <schoolBooks.length ; i++) {
            if (schoolBooks[i].getName().equals(name)) {
                foundBooks++;
            }
        }

        SchoolBook[] foundSchoolBooks = new SchoolBook[foundBooks];

            for (int j = 0; j <schoolBooks.length ; j++) {
            if (schoolBooks[j].getName().equals(name)) {
                foundSchoolBooks[j++] = schoolBooks[j];
            }
        }
        return foundSchoolBooks;
    }

    @Override
    public boolean removeByName(String name) {
        int foundBooks = 0;
        SchoolBook[] newMas = new SchoolBook[schoolBooks.length];
        for (int i = 0; i < schoolBooks.length; i++) {

            if (name.equals(schoolBooks[i].getName())) {
                foundBooks++;
                newMas[i] = schoolBooks[i];
                //currentNumber--;
            }
        }
        schoolBooks = Arrays.copyOf(newMas, schoolBooks.length - foundBooks);
        if (foundBooks == 0) return false;
        else {
            return true;
        }

    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
