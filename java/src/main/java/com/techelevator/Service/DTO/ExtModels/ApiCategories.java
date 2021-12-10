package com.techelevator.Service.DTO.ExtModels;

public class ApiCategories {

    private String alias;
    private String title;


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApiCategories() {
    }

    public ApiCategories(String alias, String title) {
        this.alias = alias;
        this.title = title;
    }

}