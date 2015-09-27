package com.androidaidl.androidaidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.androidaidl.androidaidllibrary.IRemoteProductService;
import com.androidaidl.androidaidllibrary.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Created by abbas on 27/9/15.
 */
public class ProductService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final IRemoteProductService.Stub mBinder = new IRemoteProductService.Stub() {

        List <Product> products = Collections.synchronizedList(new ArrayList<Product>());

        @Override
        public void addProduct(String name, int quantity, float cost) throws RemoteException {
            //Add product called on the service.
            //Idealy you should store the product in a local data base
            //or in some remote service.
            //You can add that code here . We are just storing in In memory list.
            Product product = new Product(name, quantity, cost);
            products.add(product);
        }

        @Override
        public Product getProduct(String name) throws RemoteException {
            //getProduct product called on the service.
            //Idealy you should store the product in a local data base
            //or in some remote service. Hence the product should be fetched from there.
            //You can add that code here .
            //We are just storing in In memory list.So fetching from in memory list.
            for(Product product : products) {
                if(product.getName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null;
        }
    };

}
