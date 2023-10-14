package com.zht.pojo;

public class Manager {
    private Integer manager_id;
    private String manager_name;
    private String college_name;

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", manager_name='" + manager_name + '\'' +
                ", college_id=" + college_name +
                '}';
    }

    public Manager() {
    }

    public Manager(Integer manager_id, String manager_name,String college_name) {
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.college_name = college_name;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_id(String college_name) {
        this.college_name = college_name;
    }
}
