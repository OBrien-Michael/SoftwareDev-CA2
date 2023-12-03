package library.lambdas;

import library.Author;

import java.util.LinkedList;

@FunctionalInterface
public interface AuthorFinder {
    Author findAuthorById(LinkedList<Author> authorLinkedList, int authorId);
}
