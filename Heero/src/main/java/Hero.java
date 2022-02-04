package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String powers;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();


    public Hero(String name, Integer age, String powers, String weakness) {
        this.name = name;
        this.age = age;
        this.powers = powers;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();

    }

    public String getName() {
        return name;
    }
    public Integer getAge(){
        return age;
    }
    public String getPowers() {
        return powers;
    }
    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getAll(){
        return instances;
    }

    public static void clearAllHeros(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }

}


