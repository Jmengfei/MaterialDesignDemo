package com.example.mengfeijia.materialtest;

/**
 * Created by mengfeijia on 2017/8/12.
 */

public class Girl {
    private String name;
    private int imageId;

    public Girl(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
