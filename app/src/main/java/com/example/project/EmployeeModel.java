package com.example.project;

import com.google.gson.annotations.SerializedName;

public class EmployeeModel {
    @SerializedName("name") //employee_name
    String name;
    @SerializedName("email")  //employee_salary
    String email;

    public EmployeeModel(String employee_name, String employee_salary) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String salary) {
        this.email = email;
    }
}
