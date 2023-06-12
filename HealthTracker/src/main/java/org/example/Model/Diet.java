package org.example.Model;
public class Diet {
    private String name;
    private int calories;

    public Diet(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }


    public String getName() {
        return this.name;
    }

    public int getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}