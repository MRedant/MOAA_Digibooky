package com.moaa.domain.member;

import com.moaa.domain.member.databases.LibrarianDataBase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LibrarianRepository {

    @Inject
    private LibrarianDataBase librarianDataBase;

    public LibrarianRepository(LibrarianDataBase librarianDataBase) {
        this.librarianDataBase = librarianDataBase;
    }

    public Librarian createLibrarian (Librarian librarian){
        return librarianDataBase.createLibrarian(librarian);
    }
}
