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
public class HistoryDTO implements  Serializable{
    String userName;
    String buyDate;
    String proName;
    String proImage;    
    int numOfPro;
    float price;

    public HistoryDTO() {
    }

    public HistoryDTO(String userName, String buyDate, String proName, String proImage, int numOfPro, float price) {
        this.userName = userName;
        this.buyDate = buyDate;
        this.proName = proName;
        this.proImage = proImage;
        this.numOfPro = numOfPro;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public int getNumOfPro() {
        return numOfPro;
    }

    public void setNumOfPro(int numOfPro) {
        this.numOfPro = numOfPro;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
