package arbre;

public class ZoneOfResearch {

    private int mid;
    private int debut;
    private int end;

    public ZoneOfResearch(int mid,int debut, int end){
        this.mid=mid;
        this.debut=debut;
        this.end=end;
    }

    public int getMid(){
        return this.mid;
    }

    public int getDebut(){
        return this.debut;
    }

    public int getEnd(){
        return this.end;
    }
    
}
