package smartCare;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoomTest {

    @Test
    void testHasAvailableBed() {
        Room room = new Room(3, "Private", 5);
        
        assertTrue(room.has_available_bed());
    }

    @Test
    void testAssignBed() {
        Room room = new Room(4, "Private", 4);

        room.assign_bed();

        assertEquals(3, room.getAvailable_beds());
    }

    @Test
    void testReleaseBed() {
        Room room = new Room(1, "Private", 1);

        room.assign_bed();
        room.release_bed();

        assertEquals(1, room.getAvailable_beds());
    }
}