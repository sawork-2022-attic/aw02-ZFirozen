package com.example.poshell.cli;

import com.example.poshell.biz.PosService;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PosCommand {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @ShellMethod(value = "List Products", key = "p")
    public String products() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Product product : posService.products()) {
            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(value = "New Cart", key = "n")
    public String newCart() {
        return posService.newCart() + " OK";
    }

    @ShellMethod(value = "Add a Product to Cart", key = "a")
    public String addToCart(String productId, int amount) {
        if (posService.add(productId, amount)) {
            return posService.getCart().toString();
        }
        return "ERROR";
    }

    @ShellMethod(value = "Print Cart", key = "c")
    public String printCart() {
        return posService.getCart().toString();
    }

    @ShellMethod(value = "Empty Current Cart", key = "e")
    public String emptyCart() {
        return posService.newCart().toString();
    }

    @ShellMethod(value = "Modify Item(s) in Current Cart", key = "m")
    public String modifyTheCart(String productId, int amountModified) {
        int itemsCount = posService.getCart().getItems().size();
        if (amountModified == 0) {
            return "Warn: The amount you want to modified is 0";
        }
        else if (posService.edit(productId, amountModified)) {
            if (amountModified > 0) {
                return "Amount of your designated item increased successfully\n" + posService.getCart();
            }
            else if (itemsCount - posService.getCart().getItems().size() == 0) {
                return "Amount of your designated item decreased successfully\n" + posService.getCart();
            }
            else {
                return "The item has been deleted as amount is 0\n" + posService.getCart();
            }
        }
        else {
            return "Modify failed: the item you designated is not existed in the current cart";
        }
    }
}
