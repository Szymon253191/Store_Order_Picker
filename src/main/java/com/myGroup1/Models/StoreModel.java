package com.myGroup1.Models;

import com.google.gson.JsonArray;

import java.time.LocalTime;

public class StoreModel {
    private JsonArray pickers;
    private LocalTime pickingStartTime;
    private LocalTime pickingEndTime;

    public StoreModel(JsonArray pickers, LocalTime pickingStartTime, LocalTime pickingEndTime) {
        this.pickers = pickers;
        this.pickingStartTime = pickingStartTime;
        this.pickingEndTime = pickingEndTime;
    }

    public JsonArray getPickers() {
        return pickers;
    }

    public LocalTime getStartTime() {
        return pickingStartTime;
    }

    public LocalTime getEndTime() {
        return pickingEndTime;
    }
}