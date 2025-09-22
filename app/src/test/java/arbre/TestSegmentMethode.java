package arbre;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class TestSegmentMethode {
    
    private Segment s1=new Segment(new Point(8.0, 14.0),new Point(100.0, 14.0));

    private Segment s2=new Segment(new Point(10.0, 14.0),new Point(10.0, -42.0));


    @Test
    void RepresentationOfHorizontalSegment(){
        assertEquals(s1.getRepInArp().getX(),8.0);
        assertEquals(s1.getRepInArp().getY(), 14.0);
    }

    @Test
    void RepresentationOfVeticalSegment(){
        assertEquals(s2.getRepInArp().getX(),-42.0);
        assertEquals(s2.getRepInArp().getY(), 10.0);
    }

    @Test
    void horizontalSegmentIsInTHeWindo(){
        assertTrue(s1.isRepInPstInInetrvall(2, 50, 0, 50));
    }

    @Test
    void horizontalSegmentIsNotInTHeWindo(){
        assertFalse(s1.isRepInPstInInetrvall(-100, 7.9, 0, 50));
    }

    @Test
    void verticalSegmentIsInTHeWindo(){
        assertTrue(s2.isRepInPstInInetrvall(7, 50, 0, 50));
    }

    @Test
    void varticalSegmentIsNotInTHeWindo(){
        assertFalse(s2.isRepInPstInInetrvall(14.1, 100, 0, 50));
    }

    @Test
    void compareSegment(){
        assertEquals(s1.compare(s2), -1);
    }



}
