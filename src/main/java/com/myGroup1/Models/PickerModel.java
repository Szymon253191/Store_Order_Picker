package com.myGroup1.Models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PickerModel {
    private String id;
    private LocalTime busyTo;

//    Tired to make list of 2D array having start-stop hours for each order the picker has taken but its too much memory and operations later.
//    private List<List<LocalTime>> busyHours;

    public PickerModel(String id, LocalTime startPickingTime) {
        this.id = id;
        this.busyTo = startPickingTime;
//        this.busyHours = null;
    }

    public String getId() {
        return id;
    }

//    public List<List<LocalTime>> getBusyHours() {
//        return busyHours;
//    }

    public void setBusyTo(LocalTime time) {
        this.busyTo = time;
    }

    public LocalTime getBusyTo() {
        return busyTo;
    }


    public void printPicker() {
        System.out.println("Picker ID: "+id.toString()+"\t|\tBusy to: "+busyTo.toString());
    }
}