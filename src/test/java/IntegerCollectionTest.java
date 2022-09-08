import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCollectionTest {

    static private IntegerCollection testCollection = new IntegerCollection();

    @BeforeEach
    void configure() {
        testCollection.clear();
    }

    @Test
    void getSize() {
        assertEquals(0, testCollection.getSize());
        testCollection.add(1, 2, 3, 4, 5);
        assertEquals(5, testCollection.getSize());
    }

    @Test
    void empty() {
        assertEquals(true, testCollection.empty());
        testCollection.add(1);
        assertEquals(false, testCollection.empty());
    }

    @Test
    void add() {
        int elementToAdd = 1, startSize = testCollection.getSize();
        testCollection.add(elementToAdd);
        assertEquals(elementToAdd, testCollection.get(startSize));
    }

    @Test
    void get() {
        int elementToAdd = 1;
        testCollection.add(elementToAdd);
        assertEquals(elementToAdd, testCollection.get(testCollection.getSize())-1);
    }

    @Test
    void delete() {
        testCollection.add(1, 2, 3, 4, 5);
        testCollection.delete(2);
        IntegerCollection checkingCollection = new IntegerCollection(1,2,4,5);
        assertEquals(testCollection, checkingCollection);
    }
}