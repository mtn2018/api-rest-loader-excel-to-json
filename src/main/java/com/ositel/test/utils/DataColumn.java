package com.ositel.test.utils;

import java.io.Serializable;


/**
 * Created by DEFARTECH on 22/09/2018.
 */
public class DataColumn implements Serializable {
    private String name = "";
    private int columnIndex;

    public DataColumn(){

    }

    public DataColumn(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public DataColumn makeCopy(){
        DataColumn c = new DataColumn(name);
        c.setColumnIndex(columnIndex);
        return c;
    }


    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getColumnIndex(){
        return columnIndex;
    }
}
