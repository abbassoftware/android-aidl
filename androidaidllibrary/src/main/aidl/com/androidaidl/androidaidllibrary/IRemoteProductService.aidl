// IRemoteProductService.aidl
package com.androidaidl.androidaidllibrary;

import com.androidaidl.androidaidllibrary.Product;

interface IRemoteProductService {

    void addProduct(String name , int quantity, float cost);
    Product getProduct(String name);
}
