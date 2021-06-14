/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.dtos;

import java.io.Serializable;

/**
 *
 * @author Ray Khum
 */
public class ProductDTO implements Serializable{
    
    int proID;
    String proName;
    float proPrice;
    int quantity;
    String description;
    String proImage;
    boolean status;
    String createDate;
    String expiryDate;
    String categoryID;

    public ProductDTO() {
    }

    public ProductDTO(int proID, String proName, float proPrice, int quantity, String description, String proImage, boolean status, String createDate, String expiryDate, String categoryID) {
        this.proID = proID;
        this.proName = proName;
        this.proPrice = proPrice;
        this.quantity = quantity;
        this.description = description;
        this.proImage = proImage;
        this.status = status;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.categoryID = categoryID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    
}
