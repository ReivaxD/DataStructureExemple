package arbre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestPrioritySearchTree {

    Segment sV1= new Segment(new Point(-100, 7), new Point(-100, 758));       //repInPst=(7;-100)
    Segment sV2= new Segment(new Point(11, 4), new Point(11, 0));       //repInPst=(0;11)
    Segment sV3= new Segment(new Point(52, -5), new Point(52, -87));        //repInPst=(-87;52)
    Segment sV4= new Segment(new Point(-10, 4), new Point(-10, 78));        //repInPst=(4;-10)
    Segment sV5= new Segment(new Point(0, 7), new Point(0, 8));         //repInPst=(7;0)
    Segment sV6= new Segment(new Point(-1000, 98), new Point(-1000, 958));   //repInPst=(98;-1000)

    Segment sH1 = new Segment(new Point(13, -89), new Point(110, -89));      //repInPst=(13;-89)
    Segment sH2= new Segment(new Point(10, 785), new Point(-5, 789));     //repInPst=(-5;785)
    Segment sH3= new Segment(new Point(10, 0), new Point(11, 0));      //repInPst=(10;0)
    Segment sH4 = new Segment(new Point(-78, 200), new Point(1,200));    //repInPst=(-78;200)
    Segment sH5 = new Segment(new Point(30, 4), new Point(-5, 4));      //repInPst=(-5;4)
    Segment sH6= new Segment(new Point(0, 4), new Point(42, 4));     //repInPst=(0;4)
    
    PrioritySearchTree h;
    PrioritySearchTree v;


    void initVerti(){   
        ArrayList<Segment> sVertical= new ArrayList<>();
        sVertical.add(sV1);
        sVertical.add(sV2);
        sVertical.add(sV3);
        sVertical.add(sV4);
        sVertical.add(sV5);
        sVertical.add(sV6);  
        v=new PrioritySearchTree(sVertical);
    }

    void initHori(){
        ArrayList<Segment> sHorizontal= new ArrayList<>();
        sHorizontal.add(sH1);
        sHorizontal.add(sH2);
        sHorizontal.add(sH3);
        sHorizontal.add(sH4);
        sHorizontal.add(sH5);
        sHorizontal.add(sH6);  
        h=new PrioritySearchTree(sHorizontal);
    }

     @Test
    void PriorityShearchTreeHoriziontal(){
        initHori();
        ArrayList<Segment> horizonatal= new ArrayList<>();
        horizonatal.add(sH1);
        horizonatal.add(sH5);
        horizonatal.add(sH3);
        horizonatal.add(sH4);
        horizonatal.add(sH6);
        horizonatal.add(sH2);  

        assertEquals(h.getTree().get(0).compare(horizonatal.get(0)), 0);
        assertEquals(h.getTree().get(1).compare(horizonatal.get(1)), 0);   
        assertEquals(h.getTree().get(2).compare(horizonatal.get(2)), 0);   
        assertEquals(h.getTree().get(3).compare(horizonatal.get(3)), 0);   
        assertEquals(h.getTree().get(4).compare(horizonatal.get(4)), 0);   
        assertEquals(h.getTree().get(5).compare(horizonatal.get(5)), 0);
    }
    @Test
    void PriorityShearchTreeVertical(){
        initVerti();
        ArrayList<Segment> vertical= new ArrayList<>();
        vertical.add(sV6);
        vertical.add(sV4);
        vertical.add(sV1);
        vertical.add(sV3);
        vertical.add(sV5);
        vertical.add(sV2);  

        assertEquals(v.getTree().get(0).compare(vertical.get(0)), 0);
        assertEquals(v.getTree().get(1).compare(vertical.get(1)), 0);
        assertEquals(v.getTree().get(2).compare(vertical.get(2)), 0);
        assertEquals(v.getTree().get(3).compare(vertical.get(3)), 0);
        assertEquals(v.getTree().get(4).compare(vertical.get(4)), 0);
        assertEquals(v.getTree().get(5).compare(vertical.get(5)), 0);
    }
    
    @Test
    void reshearchSegmentInWindoH(){
        initHori();
        ArrayList<Segment> segmentInWintdow= this.h.queryPrioSearchTree(-10, 100, -90, 5);

        ArrayList<Segment> horizonatal= new ArrayList<>();
        horizonatal.add(sH5);
        horizonatal.add(sH3);
        horizonatal.add(sH1);
        horizonatal.add(sH6);

        assertEquals(segmentInWintdow.get(0).compare(horizonatal.get(0)), 0);
        assertEquals(segmentInWintdow.get(1).compare(horizonatal.get(1)), 0);   
        assertEquals(segmentInWintdow.get(2).compare(horizonatal.get(2)), 0);   
        assertEquals(segmentInWintdow.get(3).compare(horizonatal.get(3)), 0);   
    }
    @Test
    void reshearchSegmentInWindoV(){
        initVerti();
        ArrayList<Segment> segmentInWintdow= this.v.queryPrioSearchTree(-90, 8, 0, 100);
        ArrayList<Segment> vertical= new ArrayList<>();
       
        vertical.add(sV3);
        vertical.add(sV2);
        vertical.add(sV5);  

        assertEquals(segmentInWintdow.get(0).compare(vertical.get(0)), 0);
        assertEquals(segmentInWintdow.get(1).compare(vertical.get(1)), 0);
        assertEquals(segmentInWintdow.get(2).compare(vertical.get(2)), 0);
    }
}
