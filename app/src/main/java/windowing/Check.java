package windowing;

public class Check {

    private static Notification notification;
    
    public static boolean checkNum(String word){
        char tab[] = word.toCharArray();
        // différent de "-" ET différent de "+" ET différent d'un chiffre entre 0 et 9 (vérification du 1er charactère)(ascii)
        if((int)tab[0] != 45 && ((int)tab[0] != 43) && !( ((int)tab[0] >= 48) && ((int)tab[0] <= 57) )){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("Premier charactere errone : " + tab[0]));
            return false;
        }
        // différent du singleton "-" ou "+" 
        if(tab.length == 1 && ((int)tab[0] == 45 || ((int)tab[0] == 43))){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("Charactere + ou - unique non autorise"));
            return false;
        }
        // vérifier que la suite de charactère restante n'est bien composée que de chiffres de 0 à 9
        for (int i = 1; i < tab.length; i++) {
            if(!( ((int)tab[i] >= 48) && ((int)tab[i] <= 57) )){
                notification = Notification.Instance();

                notification.addStack(new NotifMessage("Charactere " + (i+1) + " errone : "+ tab[i]));
                return false;
            }
        }
        return true;
    }

    public static boolean checkX1(String word, double ValX2){
        if (Double.parseDouble(word) >= ValX2){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("ou egal a X2 ("+ ValX2+")"));
            notification.addStack(new NotifMessage("X1 ("+ Double.parseDouble(word) +") plus grand "));
            return false;
        }
        return true;
    }

    public static boolean checkX2(String word, double ValX1) {
        if (Double.parseDouble(word) <= ValX1){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("ou egal a X1 ("+ ValX1+")"));
            notification.addStack(new NotifMessage("X2 ("+ Double.parseDouble(word) +") plus petit "));
            return false;
        }
        return true;     
    }

    public static boolean checkY1(String word, double ValY2){
        if (Double.parseDouble(word) >= ValY2){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("ou egal a Y2 ("+ ValY2+")"));
            notification.addStack(new NotifMessage("Y1 ("+ Double.parseDouble(word) +") plus grand "));
            return false;
        }
        return true;
    }

    public static boolean checkY2(String word, double ValY1){
        if (Double.parseDouble(word) <= ValY1){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("ou egal a Y1 ("+ ValY1+")"));
            notification.addStack(new NotifMessage("Y2 ("+ Double.parseDouble(word) +") plus petit "));
            return false;
        }
        return true;
    }

    public static boolean checkInterval(String word){
        double inter = Double.parseDouble(word);
        if(inter < 10 || inter > 30){
            notification = Notification.Instance();

            notification.addStack(new NotifMessage("10 et 30 (pour lisibilité)"));
            notification.addStack(new NotifMessage("Interval ("+ Double.parseDouble(word) +") non comprise entre "));
            return false;
        }
        return true;
    }
}