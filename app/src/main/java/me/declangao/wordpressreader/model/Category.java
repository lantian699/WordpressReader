package me.declangao.wordpressreader.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Category object
 */
@DatabaseTable(tableName = "category")
public class Category extends ormliteModel{

    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
