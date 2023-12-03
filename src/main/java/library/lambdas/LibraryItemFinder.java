package library.lambdas;

import library.abstracts.LibraryItem;

import java.util.LinkedList;

@FunctionalInterface
public interface LibraryItemFinder {
    LibraryItem findLibraryItemById(LinkedList<LibraryItem> libraryUserLinkedList, int libraryItemId);
}
