package arbre;

import java.util.ArrayList;

public class MergeSortOfY{

    public static void meg_sort(ArrayList<Segment> tab, int debut, int end){
        if( debut < end){
            int mid=(end + debut)/2;
            meg_sort(tab,debut,mid);
            meg_sort(tab, mid+1, end);
            merge(tab, debut, mid, end);
        }
    }

    public static void merge(ArrayList<Segment> tab, int debut, int mid, int end){
        int n1=mid - debut +1;
        int n2=end - mid;
        Segment[] l1 = new Segment[n1];
        Segment[] l2 = new Segment[n2];
        for(int i=0; i< n1; i++){
            l1[i]=tab.get(debut+i);
        }
        for(int j=0; j< n2; j++){
            l2[j]=tab.get(mid+1+j);
        }
        int i=0;
        int j=0;
        for(int k=debut;k<=end;k++){
            if (i<n1 && j<n2){
                if((l1[i].getRepInArp().getY()<l2[j].getRepInArp().getY()) || ((l1[i].getRepInArp().getY()==l2[j].getRepInArp().getY()) && (l1[i].getRepInArp().getX()<=l2[j].getRepInArp().getX()) )){
                    tab.set(k, l1[i]);
                    i++;
                }
                else{
                    tab.set(k, l2[j]);
                    j++;
                }
            }
            else{
                if(i==n1){
                    tab.set(k, l2[j]);
                    j++;
                }
                else{
                    tab.set(k, l1[i]);
                    i++;
                }
            }
        }
    }
    
}