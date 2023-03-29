package com.myGroup1.DataAccess;

import com.myGroup1.Models.OrderModel;
import com.myGroup1.Models.PickerModel;
import com.myGroup1.Models.StoreModel;

public interface DataConnectors {
    void CreateOrders(OrderModel model, String pathToFile);
    void CreateStores(StoreModel model, String pathToFile);
    void CreatePickers(PickerModel model);
}
