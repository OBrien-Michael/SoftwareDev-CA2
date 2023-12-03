package library.lambdas;

import library.LibraryUser;

import java.util.LinkedList;

@FunctionalInterface
public interface LibraryUserFinder {
    LibraryUser findLibraryUserById(LinkedList<LibraryUser> libraryUserLinkedList, int libraryUserId);
}
