package com.moaa.domain.member.databases;

import com.moaa.domain.member.Librarian;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class LibrarianDataBase {

    private List<Librarian> librarianList;

    public LibrarianDataBase() {
        this.librarianList = new ArrayList<>();
    }

    public List<Librarian> getLibrarianList() {
        return Collections.unmodifiableList(librarianList);
    }

    public Librarian addLibrarian(Librarian librarian) {
        librarianList.add(librarian);
        return librarian;
    }
}
