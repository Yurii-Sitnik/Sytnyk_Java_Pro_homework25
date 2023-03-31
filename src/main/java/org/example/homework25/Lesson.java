package org.example.homework25;

import java.sql.Date;

public class Leson {
    private int id;
    private String name;
    private Date updated_at;
    private int homework_id;

    public Leson (){

    }

    public Leson(int id, String name, Date updateAt, int homework_id) {
        this.id = id;
        this.name = name;
        this.updated_at = updateAt;
        this.homework_id = homework_id;
    }

    public Leson(int id, String name, Date updateAt) {
        this.id = id;
        this.name = name;
        this.updated_at = updateAt;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Date getUpdateAt() {
        return updated_at;
    }


    public int getHomework_id() {
        return homework_id;
    }
}

