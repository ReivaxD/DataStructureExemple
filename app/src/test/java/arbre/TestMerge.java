package arbre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestMerge {

    Segment s1 = new Segment(new Point(11, 4), new Point(11, 0));
    Segment s2 = new Segment(new Point(13, -89), new Point(110, -89));
    Segment s3 = new Segment(new Point(-100, 7), new Point(-100, -758));  
    Segment s4= new Segment(new Point(30, 4), new Point(-5, 4));
    Segment s5= new Segment(new Point(52, -5), new Point(52, -87));
    Segment s6 = new Segment(new Point(10, 0), new Point(11, 0));
    ArrayList<Segment> tab;

    void init(){
        tab = new ArrayList<>();
        tab.add(s1);
        tab.add(s2);
        tab.add(s3);
        tab.add(s4);
        tab.add(s5);
        tab.add(s6);
       
    }
    

   // ={s1,s2,s3,s4, s5,s6};

    @Test
    void MergeSort(){
        init();
        ArrayList<Segment> sortTab=new ArrayList<>();
        sortTab.add(s3);
        sortTab.add(s2);
        sortTab.add(s5);      
        sortTab.add(s1);      
        sortTab.add(s6);      
        sortTab.add(s4);
        MergeSortOfY.meg_sort(tab,0,5);
        for(int i=0; i>6;i++)
            assertEquals(tab.get(i).compare(sortTab.get(i)), 0);
    }
}
