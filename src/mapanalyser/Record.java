/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;

/**
 *
 * @author jaiprakash.siyyadri
 */
public class Record {
    private String id;
    private int sbp;
    private int dbp;
    private int map;
    private String Category;
    
    public Record(String id, int sbp, int dbp, int map, String Category){
        
    }
    // getters for all attributes
    
    public String toString(){
        return "ID: "+id+", SBP: "+sbp+", DBP: "+dbp+", MAP: "+map+", Category: "+Category;
    }
}
