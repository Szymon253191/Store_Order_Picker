package com.myGroup1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.myGroup1.DataAccess.JsonDataGetter;
import com.myGroup1.Models.OrderModel;
import com.myGroup1.Models.PickerModel;
import com.myGroup1.Models.StoreModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.myGroup1.Logic.*;

public class Application {
    public static void main(String[] args) {
        // Create Gson object
        Gson gson = new Gson();
        List<OrderModel> orders = new ArrayList<>();
        List<StoreModel> stores = new ArrayList<>();
        List<PickerModel> pickers = new ArrayList<>();

        //////////    ALMOST PROFESSIONAL TEST RESULTS    /////////////////////////
        //                                                                       //
        // advanced-allocation - myResult has no order-5                         //
        // advanced-optimize-order-value - Correct                               //
        // advanced-optimize-order-count - myResult has 1,2,4 instead of 1,2,3,5 //
        // any-order-length-is-ok - Correct                                      //
        // complete-by - Correct                                                 //
        // isf-end-time - Correct                                                //
        // logic-bomb - About 1 sec but there is no many operation in my Logic   //
        // optimize-order-count - Correct if sorted by time not by importance    //
        // optimize-order-value - Correct                                        //
        //                                                                       //
        ///////////////////////////////////////////////////////////////////////////

        // Defaults paths
        String storeFile = "self-test-data/optimize-order-value/store.json";
        String ordersFile = "self-test-data/optimize-order-value/orders.json";
        String resultFile = "self-test-data/optimize-order-value/output.txt";

        if (args.length == 2) {
            storeFile = args[0];
            ordersFile = args[1];
        }

        // Open file and get all data about store
        createStores(stores, storeFile, gson);

        // Open file and get all data about orders
        createOrders(orders, ordersFile, gson);

        getPickersFromStore(pickers, stores);

        sortOrdersByImportance(orders);
        for (OrderModel o: orders) {
            assignPicker(pickers, o);
            sortPickersByBusyTo(pickers);
        }

        for (OrderModel o: orders) {
            o.printAllOrderInfo();
        }

//        for manual testing
        printResult(resultFile);
    }
    public static void printResult(String path) {
        List<String> resultLines = null;
        try {
            resultLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(resultLines);
    }
    public static void getPickersFromStore(List<PickerModel> pickers, List<StoreModel> stores) {
        for (StoreModel eachStore:stores) {
            for (JsonElement picker : eachStore.getPickers()) {
                pickers.add(new PickerModel(picker.getAsString(), eachStore.getStartTime()));
            }
        }
    }

//  TODO Move this functions "createSomething" into ../DataAccess/JsonDataGetter
    public static void createOrders(List<OrderModel> orderModels, String ordersFile, Gson gson) {
        try (FileReader reader = new FileReader(ordersFile)) {
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
            // Loop through each element in the JsonArray
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                // Get values for each key in the JsonObject
                String orderId = jsonObject.get("orderId").getAsString();
                double orderValue = jsonObject.get("orderValue").getAsDouble();
                String pickingTime = jsonObject.get("pickingTime").getAsString();
                LocalTime completeBy = LocalTime.parse(jsonObject.get("completeBy").getAsString());
                // Create an Order object and add it to the list
                orderModels.add(new OrderModel(orderId, orderValue, pickingTime, completeBy));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createStores(List<StoreModel> storeModels, String storeFile, Gson gson) {
        try (FileReader reader = new FileReader(storeFile)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            JsonArray pickersJA = jsonObject.getAsJsonArray("pickers");
            LocalTime pickingStartTime = LocalTime.parse(jsonObject.get("pickingStartTime").getAsString());
            LocalTime pickingEndTime = LocalTime.parse(jsonObject.get("pickingEndTime").getAsString());
            storeModels.add(new StoreModel(pickersJA, pickingStartTime, pickingEndTime));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
