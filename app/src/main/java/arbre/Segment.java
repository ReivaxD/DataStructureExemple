package arbre;

import java.lang.Math;

/*
 * Class for represent a segment
 */
public class Segment {
    
    // The first point
    private Point p1;
    // The second point
    private Point p2;
    // The point associates at this segment in the priority search tree  
    private Point repInPst;

    private Orientation  orient;

    private Double Ymid;

    /**
     * constructor of the Segment class
     * @param p1 The first point
     * @param p2 The second point
     */
    public Segment(Point p1, Point p2){
        setUpPoint(p1, p2);
        if (p1.getX()==p2.getX()){
            this.repInPst=new Point(Math.min(p1.getY(),p2.getY()),p1.getX());
            orient=Orientation.VERTICAL;
            this.Ymid=this.repInPst.getY();
        }
        else{
            this.repInPst=new Point(Math.min(p1.getX(),p2.getX()),p1.getY());
            orient=Orientation.HORIZONTAL;
            this.Ymid=this.repInPst.getY();
        }  
    }
    private void setUpPoint(Point p1, Point p2){
        if(p1.compare(p2)>0){
            this.p1=p2;
            this.p2=p1;
        }
        else{
            this.p1=p1;
            this.p2=p2;
        }
    }

    /**
     * 
     * @return the representation of segment in the priority search tree  
     */
    public Point getRepInArp(){
        return this.repInPst;
    }
       
    public Point getP1(){
        return this.p1;
    }

    public Point getP2(){
        return this.p2;
    }


    public boolean isRepInPstInYInetrvall(double y, double yPrim){
        return (y<=this.repInPst.getY() && this.repInPst.getY()<=yPrim);
    }

    public boolean isRepInPstInXInetrvall(double x, double xPrim){
        switch(this.orient){
            case HORIZONTAL: return ((x<=this.repInPst.getX() && this.repInPst.getX()<=xPrim) || 
                                        (this.repInPst.getX()<x && (x<=this.p2.getX())));
            case VERTICAL: return ((x<=this.repInPst.getX() && this.repInPst.getX()<=xPrim) || 
                                        (this.repInPst.getX()<x && (x<=this.p2.getY())));
            default: return false;
        }
    }
    
    public boolean isRepInPstInInetrvall(double x, double xPrim, double y, double yPrim){
        return (isRepInPstInYInetrvall(y, yPrim) && isRepInPstInXInetrvall(x, xPrim));
    }

    public int compare(Segment outher){
        int firstCompa=this.p1.compare(outher.getP1());
        if(firstCompa !=0)
            return firstCompa;
        else
            return this.p2.compare(outher.getP2());

    }

    public double getYmid(){
        return this.Ymid;
    }

    public void setYmid(Double Ymid){
        this.Ymid=Ymid;
    }

    public Orientation getOrient(){
        return this.orient;
    }
} 
