package com.moaa.domain.member.databases;

import com.moaa.domain.member.Librarian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibrarianDataBase {

    private List<Librarian> librarianList;

    public LibrarianDataBase() {
        this.librarianList = new ArrayList<>();
    }

    public List<Librarian> getLibrarianList() {
        return Collections.unmodifiableList(librarianList);
    }
}
