package arbre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPoint {
    
    Point p1 =new Point(10, 45);
    Point p2= new Point(+-79, 74);
    @Test
    void ComparePoint(){
        assertEquals(p1.compare(p2), 1);
        assertEquals(p2.compare(p1), -1);
        assertEquals(p1.compare(p1), 0);
    }
}
