package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Squad {
    private String name;
    private Integer size;
    private String cause;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();


    public Squad(String name,Integer size, String cause ) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();

    }

    public String getName() {
        return name;
    }
    public Integer getSize() {
        return size;
    }
    public String getCause() {
        return cause;
    }
    public static ArrayList<Squad> getAll(){
        return instances;
    }

    public static void clearAllSquads(){
        instances.clear();
    }
    public int getId() {
        return id;
    }
    public static Squad findById(int id){
        return instances.get(id-1);
    }

    }



