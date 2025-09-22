package windowing;

import java.util.Stack;

import javafx.scene.canvas.GraphicsContext;

public class Notification {
    
    private static Notification notification;
    private static Stack<NotifMessage> stack;

    /**
     * Cree une instance de Notification si celle ci n'existe pas deja
     * @return Une instance de Notification
     */
    public static Notification Instance(){
        if(notification==null){
            notification= new Notification();
            stack = new Stack<NotifMessage>();
        }
        return notification;
    }

    public static void drawNotif(GraphicsContext gc){
        int square = 200;

        gc.clearRect(0, 0, square, square);
        gc.setLineWidth(1.0);
        gc.moveTo(0, 0);
        gc.lineTo(0, square);
        gc.stroke();
        gc.moveTo(0, 0);
        gc.lineTo(square, 0);
        gc.stroke();

        gc.moveTo(0, square);
        gc.lineTo(square, square);
        gc.stroke();
        gc.moveTo(square, 0);
        gc.lineTo(square, square);
        gc.stroke();

        gc.fillText("Notification(s) : ", 5, 10);
        DrawNotif(gc);
    }

    public void addStack(NotifMessage message) {
        stack.push(message);
    }

    public static String GetMessage() {
        return stack.pop().GetMessage();
    }

    public static void DrawNotif(GraphicsContext gc) {
        for (int i = 1; i < 15; i++) {
            if(!stack.empty())
                gc.fillText(GetMessage(), 5, 10+ (15*i));
        }
    }
}
