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
public class ProductErrorDTO implements Serializable{
    String proNameError;
    String proPriceError;
    String quantityError;
    String descriptionError;
    String proImageError;
    String statusError;
    String createDateError;
    String expiryDateError;
    String categoryIDError;

    public ProductErrorDTO() {
    }

    public ProductErrorDTO(String proNameError, String proPriceError, String quantityError, String descriptionError, String proImageError, String statusError, String createDateError, String expiryDateError, String categoryIDError) {
        this.proNameError = proNameError;
        this.proPriceError = proPriceError;
        this.quantityError = quantityError;
        this.descriptionError = descriptionError;
        this.proImageError = proImageError;
        this.statusError = statusError;
        this.createDateError = createDateError;
        this.expiryDateError = expiryDateError;
        this.categoryIDError = categoryIDError;
    }

    public String getProNameError() {
        return proNameError;
    }

    public void setProNameError(String proNameError) {
        this.proNameError = proNameError;
    }

    public String getProPriceError() {
        return proPriceError;
    }

    public void setProPriceError(String proPriceError) {
        this.proPriceError = proPriceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getProImageError() {
        return proImageError;
    }

    public void setProImageError(String proImageError) {
        this.proImageError = proImageError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getCreateDateError() {
        return createDateError;
    }

    public void setCreateDateError(String createDateError) {
        this.createDateError = createDateError;
    }

    public String getExpiryDateError() {
        return expiryDateError;
    }

    public void setExpiryDateError(String expiryDateError) {
        this.expiryDateError = expiryDateError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }
    
    
}
