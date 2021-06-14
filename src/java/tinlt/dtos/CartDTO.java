/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.dtos;

import java.util.Map;

/**
 *
 * @author Ray Khum
 */
public class CartDTO {
    String UserName;
    Map<String, ProductDTO> map;

    public CartDTO(String UserName, Map<String, ProductDTO> map) {
        this.UserName = UserName;
        this.map = map;
    }

    public CartDTO() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Map<String, ProductDTO> getMap() {
        return map;
    }

    public void setMap(Map<String, ProductDTO> map) {
        this.map = map;
    }

    
}
