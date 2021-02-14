package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    public static int currentNumber = 0;
    private Author authors[] = new Author[]{};


    @Override
    public boolean save(Author author) {
        //int currentNumber= authors.length;
        //  authors[currentNumber++] = author;
        Author[] newMas = new Author[1];
        if (authors.length == 0) {

            Arrays.fill(newMas, author);
            authors = Arrays.copyOf(newMas, authors.length + 1);
        } else {
            for (int i = 0; i < authors.length; i++) {
                if (author == findByFullName(authors[i].getName(), authors[i].getLastName())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        //if(authors.length==0) return null;
        if (authors.length == 0) {
            return null;
        }
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(name) && authors[i].getLastName().equals(lastname)) {
                return authors[i];
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        // Author[] newAuthors=new Author[authors.length-1];
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getName().equals(author.getName()) && authors[i].getLastName().equals(author.getLastName())) {
                authors = ArrayUtils.remove(authors, i);
                //--currentNumber;
                return true;
            }

        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
