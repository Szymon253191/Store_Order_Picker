package com.myGroup1;

import com.myGroup1.Models.OrderModel;
import com.myGroup1.Models.PickerModel;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

public class Logic {


//    TODO Create more assign algorithms like Backpack with values.
    public static void assignPicker (List<PickerModel> pickerModels, OrderModel orderModel) {
        for (PickerModel p: pickerModels) {
            LocalTime availableFrom = p.getBusyTo();

            if (availableFrom.isBefore(orderModel.getLatestStartTime()) || availableFrom==orderModel.getLatestStartTime()) {
                Duration duration = orderModel.getPickingTime();
                printOrderAndPicker(orderModel,p);
                p.setBusyTo(p.getBusyTo().plus(duration));
                break;
            }
        }
    }

    public static void assignPickerByImportance(List<PickerModel> picker, List<OrderModel> orders) {
        throw new UnsupportedOperationException("This method is not yet implemented");
    }
    public static void printOrderAndPicker(OrderModel order, PickerModel picker) {
        System.out.println(picker.getId() +" "+ order.getOrderId() +" "+ picker.getBusyTo());
    }
    public static void sortOrdersByCompleteBy(List<OrderModel> order) {

        order.sort(new OrderComparator());
    }

    public static void sortOptimal(List<OrderModel> order) {
        sortOrdersByImportance(order);
    }
    public static void sortOrdersByImportance(List<OrderModel> order) {
        order.sort(Comparator.comparing(OrderModel::getImportance).reversed());
    }
    public static void sortPickersByBusyTo(List<PickerModel> picker) {
        picker.sort(new PickerBusyToComparator());
    }

    static class OrderComparator implements Comparator<OrderModel> {
        public int compare(OrderModel o1, OrderModel o2) {
            return o1.getCompleteBy().compareTo(o2.getCompleteBy());
        }
    }

    static class PickerBusyToComparator implements Comparator<PickerModel> {
        public int compare(PickerModel p1, PickerModel p2) {
            return p1.getBusyTo().compareTo(p2.getBusyTo());
        }
    }
}
