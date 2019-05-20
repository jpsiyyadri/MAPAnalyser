/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;
import mapanalyser.Record;

/**
 *
 * @author jaiprakash.siyyadri
 */
public class MAPAnalyser {
    private Record data[];
    private int nrecords;
    
    public MAPAnalyser(){
        // invoke loadFromTables
        this.loadFromTables();
        // after record creation sorting has to be done by id using sortByID
        this.sortByID();
    }
    
    public Record find(String id){
        for(int i=0; i<data.length; i++){
            if(data[i].getId() == id){
                return data[i];
            }
        }
        return  null;
    }
    
    public int lowest(){
        return 0;
    }
    
    public int highest(){
        return 0;
    }
    
    public int median(){
        return 0;
    }
    
    public Record[] find(int map1, int map2){
        Record[] r = new Record[0];
        return r;
    }
    
    private void sortByID(){
        // selection sort algorithm
        Record[] a = this.data;
        for (int i=0; i<a.length-1; i++) {
            for (int j=i+1; j<a.length; j++) {
               if (a[i].getId().compareTo(a[j].getId()) > 0) {
                  Record temp=a[j];
                  a[j]=a[i];
                  a[i]=temp;
               }
            }
        }
        this.data = a;
    }
    
    private void loadFromTables(){
        // iterates through 3 arrays and create Record object
        String[] id_list = {"s1", "s2", "s3", "s4", "s5"}; 
        int[] sbp_list = {60, 70, 80, 90, 100};
        int[] dbp_list = {65, 75, 85, 95, 105};
        
        // initialize class variables with length of arrays
        nrecords = id_list.length;
        data = new Record[nrecords];

        // iterate through id_list, sbp_list, dbp_list
        for(int i=0; i<id_list.length; i++){
            // calculate map value using formula given
            int map = (int) (1.0/3.0 * sbp_list[i] + 2.0 / 3.0 * dbp_list[i]);
            // get the category of the map value
            String category = this.classify(map);
            // create record object
            Record r = new Record(id_list[i], sbp_list[i], dbp_list[i], map, category);
            // store that into data array
            data[i] = r;
        }
        
    };
    
    private String classify(int map){
        if(map<=70){
            return "low";
        } else if(map<=100){
            return "medium";
        } else{
            return "high";
        }
    }
}
