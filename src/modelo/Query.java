/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ralu
 */
public class Query {
    PreparedStatement ps;
    Connection conn;
    

    public Query(Connection conn) {
        this.conn = conn;
        this.ps = null;
    }
    
    private String getDateLikeString(String date) {
        String month = date.substring(4, 10);
        String year = date.substring(24, 29);
        
        return month + year;
    }
    
    public boolean createTask(String description, String date) {
        String sql = "INSERT INTO Tasks (description, date) VALUES (?, ?) ";
        date = this.getDateLikeString(date);
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, description);
            this.ps.setString(2, date);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean updateTask(int id, String description, String date) {
        String sql = "UPDATE Tasks SET description = ?, date = ? WHERE id = ?";
        date = this.getDateLikeString(date);
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, description);
            this.ps.setString(2, date);
            this.ps.setInt(3, id);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean updateTaskByDescription(int id, String description) {
        String sql = "UPDATE Tasks SET description = ? WHERE id = ?";
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, description);
            this.ps.setInt(2, id);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean updateTaskByDate(int id, String date) {
        String sql = "UPDATE Tasks SET date = ? WHERE id = ?";
        date = this.getDateLikeString(date);
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setString(1, date);
            this.ps.setInt(2, id);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public Task readTask(int id) {
        String sql = "SELECT * FROM Tasks WHERE id = ?";
        ResultSet rs;
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, id);
            String description = null;
            String date = null;
            Boolean done = false;
            rs = ps.executeQuery();
            
            if (rs.next()) {
                description = rs.getString("description");
                date = rs.getString("date");
                done = rs.getBoolean("done");
            }
            
            return new Task(id, description, date, done);
            
        } catch (SQLException e) {
            System.err.println(e);
            
            return new Task(0, null, null, false);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean deleteTask(int id) {
        String sql = "DELETE FROM Tasks WHERE id = ?";
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setInt(1, id);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
     
    public Task[] readTasks() {
        String sql = "SELECT * FROM Tasks";
        Task[] tasks = new Task[8];
        
        tasks[0] = new Task(0, null, null, false);
        tasks[1] = new Task(0, null, null, false);
        tasks[2] = new Task(0, null, null, false);
        tasks[3] = new Task(0, null, null, false);
        tasks[4] = new Task(0, null, null, false);
        tasks[5] = new Task(0, null, null, false);
        tasks[6] = new Task(0, null, null, false);
        tasks[7] = new Task(0, null, null, false);
        
        ResultSet rs;
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
              
            while (rs.next() && i < 8) {
                int idTask = rs.getInt("id");
                String descriptionTask = rs.getString("description");
                String dateTask = rs.getString("date"); 
                Boolean doneTask = rs.getBoolean("done");
                
                tasks[i] = new Task(
                        idTask, 
                        descriptionTask,
                        dateTask, 
                        doneTask
                );
                i++;
            }
            
            
            return tasks;
        } catch (SQLException e) {
            System.err.println(e);
            
            return tasks;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
      
    public boolean updateTaskDone(int id, Boolean done) {
        String sql = "UPDATE Tasks SET done = ? WHERE id = ?";
        
        try {
            this.ps = this.conn.prepareStatement(sql);
            this.ps.setBoolean(1, done);
            this.ps.setInt(2, id);
            this.ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }  
}
