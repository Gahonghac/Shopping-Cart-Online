/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author flami
 */
public class Cart {

    private Map<String, Tea> cart;

    public Cart() {
    }

    public Cart(Map<String, Tea> map) {
        this.cart = map;
    }

    public Map<String, Tea> getCart() {
        return cart;
    }

    public void setCart(Map<String, Tea> map) {
        cart = map;
    }

    public void add(Tea tea) {
        if (cart == null) {
            cart = new HashMap<>();
        }
        String id = tea.getId();
        if (cart.containsKey(id)) {
            tea.setQuantity(tea.getQuantity() + cart.get(id).getQuantity());
        }
        cart.put(id, tea);
        //thêm 1 cặp key - value, nếu key đã có sẵn thì thay đổi value
        //bằng giá trị mới
    }

    public void delete(String id) {
        if (cart == null) {
            return;
        }
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
    }

    public void update(String id, Tea newTea) {
        if (cart == null) {
            return;
        }
        if (cart.containsKey(id)) {
            cart.replace(id, newTea);
        }
    }
}
