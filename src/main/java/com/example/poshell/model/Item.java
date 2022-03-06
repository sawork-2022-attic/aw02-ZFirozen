package com.example.poshell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int amount;

    @Override
    public String toString(){
        return product.toString() +"\t" + amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public boolean editAmount(int amountModified) {
        if (amount + amountModified <= 0) {
            // the boolean return doesn't mean the edit success or not
            // it only represents whether the original amount is enough to be decreased or not
            // thus the Cart could identify should it delete the whole item
            return false;
        }
        else {
            amount += amountModified;
            return true;
        }
    }
}
