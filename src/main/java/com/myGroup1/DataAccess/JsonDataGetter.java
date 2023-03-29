package com.myGroup1.DataAccess;

import com.myGroup1.Models.OrderModel;
import com.myGroup1.Models.PickerModel;
import com.myGroup1.Models.StoreModel;


public class JsonDataGetter implements DataConnectors{

    @Override
    public void CreateOrders(OrderModel model, String pathToFile) {
        throw new UnsupportedOperationException("This method is not yet implemented");
    }

    @Override
    public void CreateStores(StoreModel model, String pathToFile) {
        throw new UnsupportedOperationException("This method is not yet implemented");
    }
    @Override
        public    void CreatePickers(PickerModel model) {
        throw new UnsupportedOperationException("This method is not yet implemented");
    }
}
