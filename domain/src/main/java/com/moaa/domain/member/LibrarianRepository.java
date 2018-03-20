package com.moaa.domain.member;

import com.moaa.domain.member.databases.LibrarianDataBase;

import javax.inject.Named;

@Named
public class LibrarianRepository {

    private LibrarianDataBase librarianDataBase;

    public LibrarianRepository(LibrarianDataBase librarianDataBase) {
        this.librarianDataBase = librarianDataBase;
    }

    public Librarian createLibrarian (Librarian librarian){
        return librarianDataBase.addLibrarian(librarian);
    }

    public Librarian getLibrarian (Librarian librarian){
        return null;
    }

    public Librarian updateLibrarian (){
        return null;
    }

    public Librarian deleteLibrarian (){
        return null;
    }
}
