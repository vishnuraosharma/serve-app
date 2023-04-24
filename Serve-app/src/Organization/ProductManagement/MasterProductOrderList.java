/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Organization.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author vraosharma
 */
public class MasterProductOrderList {
    ArrayList<ProductOrder> productOrderList;
    MasterProductOrderReport prodOrderReport;
    
    public MasterProductOrderList (){
        this.productOrderList = new ArrayList<>();
    }
    
    public ProductOrder addProductOrder(ProductOrder po){
        //ServiceOrder so = new ServiceOrder(client, s);
        this.productOrderList.add(po);
        return po;
    }

    public ArrayList<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public MasterProductOrderReport getProdOrderReport() {
        return prodOrderReport;
    }
    
    
    
}
