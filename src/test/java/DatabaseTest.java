import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

class DatabaseTest {
    Database database = new Database();

    @BeforeEach
    void setUp() {

    }

    @Test
    void addMedlemToDatabaseTest() {
        int expectedObjectsInDatabase = 2;

        Medlem testMedlem = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        Medlem testMedlem2 = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        database.addMedlemToDatabase(testMedlem);
        database.addMedlemToDatabase(testMedlem2);

        assertEquals(expectedObjectsInDatabase, database.getMedlemsDatabase().size());
    }

    @Test
    void searchMedlemTest() {
        Medlem expectedMedlem = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        Medlem expectedMedlem2 = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        ArrayList<Medlem> expectedShowMedlemmer = new ArrayList<>();
        expectedShowMedlemmer.add(expectedMedlem);
        expectedShowMedlemmer.add(expectedMedlem2);

        Medlem testMedlem = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        Medlem testMedlem2 = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        database.addMedlemToDatabase(testMedlem);
        database.addMedlemToDatabase(testMedlem2);

        assertEquals(expectedShowMedlemmer.get(0).getNavn(), database.searchMedlem("X").get(0).getNavn());
        assertEquals(expectedShowMedlemmer.get(1).getNavn(), database.searchMedlem("X").get(1).getNavn());
    }

    @Test
    void editMedlem() {
        Medlem expectedMedlem = new Medlem("Y", 2, 'f', 2020, 12, 12, "passivt", "konkurrencesvømmer");
        Medlem testMedlem = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");

        database.editMedlem(testMedlem, expectedMedlem);

        assertEquals(testMedlem.getNavn(), expectedMedlem.getNavn());
        assertEquals(testMedlem.getIndmeldelsesDato(), expectedMedlem.getIndmeldelsesDato());
    }

    @Test
    void deleteMedlem() {
        int expectedObjectsInDatabase = 1;

        Medlem testMedlem = new Medlem("X", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        Medlem testMedlem2 = new Medlem("Y", 1, 'm', 2000, 1, 1, "aktivt", "motionist");
        database.addMedlemToDatabase(testMedlem);
        database.addMedlemToDatabase(testMedlem2);

        database.deleteMedlem("X");

        assertEquals(expectedObjectsInDatabase, database.getMedlemsDatabase().size());
    }
}