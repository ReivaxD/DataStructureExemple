package arbre;

/**
 * Class for represent a point
 */
public class Point{

    // the x-coordinate
    private double x;
    // the y-coordinate
    private double y;


    /**
     * Constructor of the Point class
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }

    /**
     * @return the x_coordinate.
     */
    public double getX(){
        return this.x;
    }

    /**
     * @return the y_coordinate.
     */
    public double getY(){
        return this.y;
    }

    public int compare(Point outher){
        if(this.x < outher.getX())
            return -1;
        if(this.x  > outher.getX())
            return 1;
        else{
            if(this.y < outher.getY())
                return -1;
            if(this.y > outher.getY())
                return 1;
            else
                return 0;
        }

    }


}