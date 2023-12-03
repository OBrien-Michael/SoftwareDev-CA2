package library;

import library.exceptions.LibraryItemException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {

    private AudioBook newAudioBookOne() throws LibraryItemException {

        return new AudioBook(1,"TestAudioBook",1,true,"1234567891012");

    }

    private AudioBook newAudioBookTwo() throws LibraryItemException {

        return new AudioBook(3,"TestAudioBookTwo",2,true,"9234567891012");

    }



    @Test
    void getIsbn() {
        try {
            assertEquals("1234567891012",newAudioBookOne().getIsbn());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setIsbn() {
        try {

            AudioBook audioBookTest = newAudioBookOne();

            audioBookTest.setIsbn("1111111111111");

            assertEquals("1111111111111",audioBookTest.getIsbn());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void testToString() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            String expectedToString = "AudioBook: Library Item ID = 1, Title=TestAudioBook, authorId=1, availability=true isbn=1234567891012\n";

            assertEquals(expectedToString,audioBookTest.toString());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getLibraryItemId() {
        try {
            assertEquals(1,newAudioBookOne().getLibraryItemId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setLibraryItemId() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            audioBookTest.setLibraryItemId(2);

            assertEquals(2,audioBookTest.getLibraryItemId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getTitle() {
        try {
            assertEquals("TestAudioBook",newAudioBookOne().getTitle());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setTitle() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            audioBookTest.setTitle("Learning Java");

            assertEquals("Learning Java",audioBookTest.getTitle());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getAuthorId() {
        try {
            assertEquals(1,newAudioBookOne().getAuthorId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setAuthorId() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            audioBookTest.setAuthorId(2);

            assertEquals(2,audioBookTest.getAuthorId());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void getAvailability() {
        try {
            assertTrue(newAudioBookOne().getAvailability());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void setAvailability() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            audioBookTest.setAvailability(false);

            assertFalse(audioBookTest.getAvailability());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }


    @Test
    void compareTo() {
        try {
            AudioBook audioBookTestOne = newAudioBookOne();
            AudioBook audioBookTestTwo = newAudioBookTwo();

            assertEquals(-1,audioBookTestOne.compareTo(audioBookTestTwo));


        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    @Test
    void convertToCommaDelimitedArray() {
        try {
            AudioBook audioBookTest = newAudioBookOne();

            ArrayList<String> expectedToStringArray = new ArrayList<>();
            expectedToStringArray.add("1");
            expectedToStringArray.add("TestAudioBook");
            expectedToStringArray.add("1");
            expectedToStringArray.add("1234567891012");
            expectedToStringArray.add("true");


            assertEquals(expectedToStringArray,audioBookTest.convertToCommaDelimitedArray());
        } catch (LibraryItemException libraryItemException) {
            fail();
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }


    }
}