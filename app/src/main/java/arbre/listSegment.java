package arbre;

import java.util.ArrayList;

public class listSegment {
    
    private ArrayList<Segment> h = new ArrayList<>();
    private ArrayList<Segment> v = new ArrayList<>();

    public listSegment(ArrayList<Segment> h, ArrayList<Segment> v){
        this.h=h;
        this.v=v;
    }

    public ArrayList<Segment> getHori(){
        return this.h;
    }
    public ArrayList<Segment> getVerti(){
        return this.v;
    }
}
