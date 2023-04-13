/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import junit.framework.Assert;
import org.junit.Test;
/**
 *
 * @author ralu
 */
public class QueryTest {
    @Test
    public void createTask() {
        Query query = new Query(new Conn().getConnPostgresql());
        Assert.assertTrue(query.createTask("test", "Thu Apr 13 20:00:00 WEST 2023"));
    }
    
    @Test
    public void updateTask() {
        Query query = new Query(new Conn().getConnPostgresql());
        Assert.assertTrue(query.updateTask(1, "test", "Thu Apr 13 21:00:00 WEST 2023"));
    }
    
    @Test
    public void deleteTask() {
        Query query = new Query(new Conn().getConnPostgresql());
        Assert.assertTrue(query.deleteTask(1));
    }
    
     @Test
    public void readTask() {
        Query query = new Query(new Conn().getConnPostgresql());
        Task task = new Task(0, "test", "Thu Apr 13 22:00:00 WEST 2023", Boolean.TRUE);
        Assert.assertTrue(task.getClass() == query.readTask(2).getClass());
    }
    
     @Test
    public void readTasks() {
        Query query = new Query(new Conn().getConnPostgresql());
        Assert.assertTrue(new Task[]{}.getClass() == query.readTasks().getClass());
    }
    
    @Test
    public void howManyTasks() {
        Query query = new Query(new Conn().getConnPostgresql());
        Assert.assertEquals(8, query.readTasks().length);
    }
}
