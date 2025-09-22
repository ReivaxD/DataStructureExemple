package arbre;


import java.util.ArrayList;

/*
 * Class for represent a priority search tree  
 */
public class PrioritySearchTree {

    // A table who represent a priority search tree  
    private ArrayList<Segment> tree;
    // The number element in this priority search tree  
    private int N;
    // The middle of the table 
    private int mid;


    /**
     * Constructor of the PrioritySearchTree class
     * @param tab a table with N segment.
     */
    public PrioritySearchTree(ArrayList<Segment> tab){
        this.mid=tab.size()/2;
        this.N=tab.size();
        MergeSortOfY.meg_sort(tab, 0, tab.size()-1); 
     
        createPST(tab,0,tab.size()-1);
        this.tree=tab;
    }

    /**
     * 
     * @param tab
     * @param debut
     * @param end
     * @return The y medians vallue.
     */
    private Double createPST(ArrayList<Segment> tab,int debut , int end){
        if(debut<end){
            int x_min=minTab(tab, debut, end);
            int middle=(end + debut+1)/2;
            echange(tab, middle, x_min);
            Double yMedOgLeft=createPST(tab, debut, middle-1);
            Double yMedOgRigth=createPST(tab, middle+1, end);
            if(yMedOgLeft!=null && yMedOgRigth!=null){
                tab.get(middle).setYmid((yMedOgLeft+yMedOgRigth)/2); 
                return tab.get(middle).getYmid();
            }
            else{
                if(yMedOgLeft==null){
                    tab.get(middle).setYmid(yMedOgRigth);
                    return tab.get(middle).getYmid();
                }
                else{
                    tab.get(middle).setYmid(yMedOgLeft);
                    return tab.get(middle).getYmid();
                }
            }
        }
        else{
            if(debut==end){
                return tab.get(debut).getYmid();
            }
            return null; 
        }
    }

    /**
     * 
     * @param tab
     * @param debut
     * @param end
     * @return
     */
    private int minTab(ArrayList<Segment> tab, int debut, int end){
        int j=debut;
        for(int i= debut+1; i<=end;i++){
            if(tab.get(j).getRepInArp().getX()>tab.get(i).getRepInArp().getX())
                j=i;
        }
        return j;
    }

    /**
     * 
     * @param tab
     * @param xMid
     * @param xMin
     */
    public void echange(ArrayList<Segment> tab, int xMid, int xMin){
        if(xMin!=xMid){
            Segment inter=tab.get(xMin);
            tab.set(xMin, tab.get(xMid));
            tab.set(xMid, inter);
        }
    }

    private void reportInSubtree(int indice, int debut , int end, Double x, Double xPrim , ArrayList<Segment> listSegment){ 
        if(debut < end && this.tree.get(indice).isRepInPstInXInetrvall(Double.NEGATIVE_INFINITY, xPrim)){
            if(this.tree.get(indice).isRepInPstInXInetrvall(x, Double.POSITIVE_INFINITY)){
                listSegment.add(tree.get(indice));
            }
                
            int newIndice=(indice + debut +1)/2;
            reportInSubtree(newIndice, debut, indice-1, x, xPrim,listSegment);
            int newIndice2=(end + indice +1)/2;
            reportInSubtree(newIndice2, indice+1, end, x, xPrim, listSegment);
        }
        else{
            if(debut == end && this.tree.get(indice).isRepInPstInXInetrvall(Double.NEGATIVE_INFINITY, xPrim)){
                if(this.tree.get(indice).isRepInPstInXInetrvall(x, Double.POSITIVE_INFINITY))
                    listSegment.add(tree.get(indice));
            }
        }
    }

    public ArrayList<Segment> queryPrioSearchTree(double x, double xPrim, double y, double yPrim){
        ArrayList<Segment> listSegment=new ArrayList<>();
        ZoneOfResearch nodeSplit=findNodeSplit(this.mid, 0, this.N-1, y, yPrim,x, xPrim, listSegment);
        ZoneOfResearch zoneLeft=new ZoneOfResearch((nodeSplit.getMid()+nodeSplit.getDebut())/2, nodeSplit.getDebut(), nodeSplit.getMid()-1);
        queryPrioSearchTreeLeft(zoneLeft, x, xPrim, y, yPrim, listSegment);
        ZoneOfResearch zoneRigth=new ZoneOfResearch((nodeSplit.getMid()+nodeSplit.getEnd()+2)/2, nodeSplit.getMid()+1, nodeSplit.getEnd());
        queryPrioSearchTreeRigth(zoneRigth, x, xPrim, y, yPrim,listSegment);
        return listSegment;
    }
    private void isWindow(int mid,Double y, Double yPrim,double x, double xPrim, ArrayList<Segment> listSegment){
        if(this.tree.get(mid).isRepInPstInInetrvall(x, xPrim, y, yPrim)){
            listSegment.add(tree.get(mid));
        }
    }

    private ZoneOfResearch findNodeSplit(int mid,int debut, int end,Double y, Double yPrim,double x, double xPrim, ArrayList<Segment> listSegment){
        isWindow(mid, y, yPrim, x, xPrim, listSegment);
        if(y<=tree.get(mid).getYmid() && tree.get(mid).getYmid()<=yPrim){
            return new ZoneOfResearch(mid,debut,end);}
        else{
            if(tree.get(mid).getYmid()<y)
                return findNodeSplit((end + mid+2)/2, mid+1, end, y, yPrim, x, xPrim, listSegment);
            else    
                 return findNodeSplit((mid + debut-1)/2, debut, mid-1, y, yPrim, x, xPrim,listSegment);
        }
    }

    public void queryPrioSearchTreeLeft(ZoneOfResearch zone,Double x, Double xPrim, Double y, Double yPrim,ArrayList<Segment> listSegment){
        if(zone.getEnd()==zone.getDebut()){
            if(this.tree.get(zone.getDebut()).isRepInPstInInetrvall(x, xPrim, y, yPrim))
                listSegment.add(tree.get(zone.getDebut()));
        }
        else{
            if(this.tree.get(zone.getMid()).isRepInPstInInetrvall(x, xPrim, y, yPrim)){
                listSegment.add(tree.get(zone.getMid()));
            }
            reportInSubtree((zone.getEnd() +zone.getMid()+2)/2, zone.getMid()+1, zone.getEnd(), x, xPrim, listSegment);
            queryPrioSearchTreeLeft(new ZoneOfResearch((zone.getMid() +zone.getDebut()-1)/2, zone.getDebut(), zone.getMid()-1), x, xPrim, y, yPrim, listSegment);
        }
    }

    public void queryPrioSearchTreeRigth(ZoneOfResearch zone,Double x, Double xPrim, Double y, Double yPrim,ArrayList<Segment> listSegment){
        if(zone.getEnd()<=zone.getDebut()){
            if(this.tree.get(zone.getEnd()).isRepInPstInInetrvall(x, xPrim, y, yPrim))
                listSegment.add(tree.get(zone.getEnd()));
        }
        else{
            if(this.tree.get(zone.getMid()).isRepInPstInInetrvall(x, xPrim, y, yPrim)){
                listSegment.add(tree.get(zone.getMid()));
            }
            reportInSubtree((zone.getMid() + zone.getDebut()-1)/2, zone.getDebut(), zone.getMid()-1, x, xPrim, listSegment);
            System.out.println(zone.getDebut()+" "+ zone.getMid() + " " +zone.getEnd());
            queryPrioSearchTreeRigth(new ZoneOfResearch((zone.getEnd() + zone.getMid()+2)/2, zone.getMid()+1, zone.getEnd()), x, xPrim, y, yPrim, listSegment);
        }
    }

    public ArrayList<Segment> getTree(){
        return this.tree;
    }



}
