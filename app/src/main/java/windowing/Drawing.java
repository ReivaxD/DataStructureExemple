package windowing;

import java.util.ArrayList;

import arbre.Segment;
import arbre.listSegment;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Date;
import java.util.Timer;
public class Drawing {
    
    /**
     * Method to draw grid on a canvas (by side Effect)
     * @param canvas the canvas (is a graphicsContext) that will receive a grid
     * @param HDim width of the canvas
     * @param VDim height of the canvas
     */
    public static void drawCanvas(GraphicsContext gc, int HDim, int VDim, double ValX1, double ValX2, double ValY1, double ValY2, double intervalX, double intervalY, listSegment seg, boolean drawGril) {
        gc.clearRect(0, 0, HDim, VDim);
        gc.setLineWidth(0.2);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        double interX = Math.abs(ValX2 - ValX1)/intervalX;
        double interY = Math.abs(ValY2 - ValY1)/intervalY;

        long startTime = System.currentTimeMillis();
    

        //Set-up Horizontal lines on canvas
        for (int x = 1; x <= intervalX; x++) {

            if(drawGril){
                //Set Lines
                gc.moveTo(x*(HDim/intervalX), 0);
                gc.lineTo(x*(HDim/intervalX), VDim);
                gc.stroke();
            }

            //Set text
            gc.fillText(Integer.toString((int)(ValX1 + x*interX) ), x*(HDim/intervalX), (VDim/intervalY)/2);
        }

        //Set-up Vertical lines on canvas
        for (int y = 1; y <= intervalY; y++) {
            if(drawGril){
                gc.moveTo(0, y*(VDim/intervalY));
                gc.lineTo(HDim, y*(VDim/intervalY));
                gc.stroke();
            }

            //Set text
            gc.fillText(Integer.toString((int)(ValY1 + y*interY)), 0, y*(VDim/intervalY));
        }

        gc.moveTo(0, 0);
        gc.lineTo(0, VDim);
        gc.stroke();

        gc.moveTo(0, 0);
        gc.lineTo(HDim, 0);
        gc.stroke();

        int count = 0;
        if(!seg.getHori().isEmpty()){
            for (Segment s : seg.getHori()) {
                drawSeg(gc, s, HDim, VDim, ValX1, ValX2, ValY1, ValY2, intervalX, intervalY);
                count++;
            }
        }
        
        if(!seg.getVerti().isEmpty()){
            for (Segment s : seg.getVerti()) {
                
                drawSeg(gc, s, HDim, VDim, ValX1, ValX2, ValY1, ValY2, intervalX, intervalY);
                long stopTime = System.currentTimeMillis();
                //System.out.println(stopTime - startTime);
            }
        }

        //long stopTime = System.currentTimeMillis();
        //long elapsedTime = stopTime - startTime;
        //System.out.println(elapsedTime);
        //System.out.println(count);
    }

    public static void drawSeg(GraphicsContext gc, Segment seg, int HDim, int VDim, double ValX1, double ValX2, double ValY1, double ValY2, double intervalX, double intervalY){
        gc.moveTo((seg.getP1().getX()-ValX1)/Math.abs(ValX2-ValX1)*HDim , (seg.getP1().getY()-ValY1)/Math.abs(ValY2-ValY1)*VDim );
        gc.lineTo((seg.getP2().getX()-ValX1)/Math.abs(ValX2-ValX1)*HDim , (seg.getP2().getY()-ValY1)/Math.abs(ValY2-ValY1)*VDim );
        gc.stroke();
    }

}
