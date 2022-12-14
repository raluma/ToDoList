/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ralu
 */
public class Task {
    private final int id;
    private final String description;
    private final String date;
    private final Boolean done;
    
    public Task(int id, String description, String date, Boolean done) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return this.description;
    }
    
    public String getDate() {
        return date;
    }
    
     public Boolean getDone() {
        return done;
    }
}
