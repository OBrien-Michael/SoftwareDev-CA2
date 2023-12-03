package library;

import library.exceptions.LibraryItemException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book newBookOne() throws LibraryItemException {

        return new Book(1,"TestBook",1,true,"1234567891012");

    }

    private Book newBookTwo() throws LibraryItemException {

        return new Book(3,"TestBookTwo",2,true,"9234567891012");

    }



    @Test
    void getIsbn() {
        try {
            assertEquals("1234567891012",newBookOne().getIsbn());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setIsbn() {
        try {
            Book bookTest = newBookOne();

            bookTest.setIsbn("1111111111111");

            assertEquals("1111111111111",bookTest.getIsbn());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void testToString() {
        try {
            Book bookTest = newBookOne();

            String expectedToString = "Library Item ID = 1, Title=TestBook, authorId=1, availability=true isbn=1234567891012";

            assertEquals(expectedToString,bookTest.toString());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getLibraryItemId() {
        try {
            assertEquals(1,newBookOne().getLibraryItemId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setLibraryItemId() {
        try {
            Book bookTest = newBookOne();

            bookTest.setLibraryItemId(2);

            assertEquals(2,bookTest.getLibraryItemId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getTitle() {
        try {
            assertEquals("TestBook",newBookOne().getTitle());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setTitle() {
        try {
            Book bookTest = newBookOne();

            bookTest.setTitle("Learning Java");

            assertEquals("Learning Java",bookTest.getTitle());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getAuthorId() {
        try {
            assertEquals(1,newBookOne().getAuthorId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setAuthorId() {
        try {
            Book bookTest = newBookOne();

            bookTest.setAuthorId(2);

            assertEquals(2,bookTest.getAuthorId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getAvailability() {
        try {
            assertTrue(newBookOne().getAvailability());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setAvailability() {
        try {
            Book bookTest = newBookOne();

            bookTest.setAvailability(false);

            assertFalse(bookTest.getAvailability());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }


    @Test
    void compareTo() {
        try {
            Book bookTestOne = newBookOne();
            Book bookTestTwo = newBookTwo();

            assertEquals(-1,bookTestOne.compareTo(bookTestTwo));


        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void convertToCommaDelimitedArray() {
        try {
            Book bookTest = newBookOne();

            ArrayList<String> expectedToStringArray = new ArrayList<>();
            expectedToStringArray.add("1");
            expectedToStringArray.add("TestBook");
            expectedToStringArray.add("1");
            expectedToStringArray.add("1234567891012");
            expectedToStringArray.add("true");


            assertEquals(expectedToStringArray,bookTest.convertToCommaDelimitedArray());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }


    }
}