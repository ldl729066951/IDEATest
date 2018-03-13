package com.castor.base.event;

public class DemoEvent {

    public static DemoEvent create(String name) {
        return new DemoEvent(name);
    }

    public DemoEvent(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
