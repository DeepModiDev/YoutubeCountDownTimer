package com.deepmodi.youtubecountdowntimer.Model;

public class Category {

    private String id;
    private String product;
    private String time;

    public Category() {
    }

    public Category(String id, String product, String time) {
        this.id = id;
        this.product = product;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
