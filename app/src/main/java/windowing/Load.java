package windowing;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

import arbre.Orientation;
import arbre.Point;
import arbre.Segment;
import arbre.listSegment;

public class Load {

    private static Notification notification;

    public static listSegment extract(String word){
        String name = "src/main/java/windowing/" + word;
        ArrayList<String> seg = new ArrayList<>();
        try {
            File doc = new File(name);
            Scanner obj = new Scanner(doc);

            //première ligne non utilisée
            obj.nextLine();
            
            while(obj.hasNextLine()){
                seg.add(obj.nextLine());
            }
            obj.close();

        } catch (Exception e) {
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("non present dans windowing"));
            notification.addStack(new NotifMessage("Fichier \""+ word +"\""));
        }
        return convert(seg);
    }

    public static listSegment convert(ArrayList<String> str){
        ArrayList<Segment> h = new ArrayList<>();
        ArrayList<Segment> v = new ArrayList<>();
        
        for (String mot : str) {
            String[] sepMot = mot.split("\\s+");
            Segment temp = new Segment(new Point(Double.parseDouble(sepMot[0]), Double.parseDouble(sepMot[1])), new Point(Double.parseDouble(sepMot[2]), Double.parseDouble(sepMot[3])));
            if(temp.getOrient()==Orientation.HORIZONTAL)
                h.add(temp);
            if(temp.getOrient()==Orientation.VERTICAL)
                v.add(temp);
        }
        return new listSegment(h, v);
    }
}