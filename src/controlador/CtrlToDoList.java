/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Conn;
import modelo.Query;
import modelo.Task;
import vista.formTasks;

/**
 *
 * @author ralu
 */
public class CtrlToDoList implements ActionListener {
    private final Conn conn;
    private Query query;
    private final formTasks form;

    public CtrlToDoList() {
        this.conn = new Conn();
        this.form = new formTasks();
    }
    
    public void init() {
        this.form.setTitle("Task List");
        this.form.setLocationRelativeTo(null);
        this.form.setVisible(true);
        
        // Dejar Layouts e Ids no visibles. 
        this.cleanLayouts();
        this.cleanIds();
        
        // Mostrar los datos de bd.
        this.getTasks();
        
        // Poner como controlador de los eventos de botón a la misma clase.
        this.form.BtnAdd.addActionListener(this);
        this.form.BtnConfirmUpdate.addActionListener(this);
        this.activateBtnsUpdate();
        this.activateBtnsDrop();
    }
    
    private void activateBtnsDrop() {
        this.form.BtnDrop1.addActionListener(this);
        this.form.BtnDrop2.addActionListener(this);
        this.form.BtnDrop3.addActionListener(this);
        this.form.BtnDrop4.addActionListener(this);
        this.form.BtnDrop5.addActionListener(this);
        this.form.BtnDrop6.addActionListener(this);
        this.form.BtnDrop7.addActionListener(this);
        this.form.BtnDrop8.addActionListener(this);
    }
    
    private void activateBtnsUpdate() {
        this.form.BtnUpdate1.addActionListener(this);
        this.form.BtnUpdate2.addActionListener(this);
        this.form.BtnUpdate3.addActionListener(this);
        this.form.BtnUpdate4.addActionListener(this);
        this.form.BtnUpdate5.addActionListener(this);
        this.form.BtnUpdate6.addActionListener(this);
        this.form.BtnUpdate7.addActionListener(this);
        this.form.BtnUpdate8.addActionListener(this);
        this.form.Task1.addActionListener(this);
        this.form.Task2.addActionListener(this);
        this.form.Task3.addActionListener(this);
        this.form.Task4.addActionListener(this);
        this.form.Task5.addActionListener(this);
        this.form.Task6.addActionListener(this);
        this.form.Task7.addActionListener(this);
        this.form.Task8.addActionListener(this);
    }
    
    private void cleanIds() {
        this.form.IdUpdate.setVisible(false);
        this.form.IdTask1.setVisible(false);
        this.form.IdTask2.setVisible(false);
        this.form.IdTask3.setVisible(false);
        this.form.IdTask4.setVisible(false);
        this.form.IdTask5.setVisible(false);
        this.form.IdTask6.setVisible(false);
        this.form.IdTask7.setVisible(false);
        this.form.IdTask8.setVisible(false);
    }
    
    private void cleanLayouts() {
        this.form.LayoutTask1.setVisible(false);
        this.form.LayoutTask2.setVisible(false);
        this.form.LayoutTask3.setVisible(false);
        this.form.LayoutTask4.setVisible(false);
        this.form.LayoutTask5.setVisible(false);
        this.form.LayoutTask6.setVisible(false);
        this.form.LayoutTask7.setVisible(false);
        this.form.LayoutTask8.setVisible(false);
        this.setDefaultBg();
    }
    
    private void setDefaultBg() {
        String clrSel = Color.decode("#5888ce").toString(); // Color seleccionado para update
        ImageIcon uploadIcon = new ImageIcon("src/icons/uploadIcon.png");
        
        if (clrSel.equals(this.form.LayoutTask1.getBackground().toString())) {
            this.form.LayoutTask1.setBackground(Color.decode("#f2f2f2"));
            this.form.Task1.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate1.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask2.getBackground().toString())) {
            this.form.LayoutTask2.setBackground(Color.decode("#f2f2f2"));
            this.form.Task2.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate2.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask3.getBackground().toString())) {
            this.form.LayoutTask3.setBackground(Color.decode("#f2f2f2"));
            this.form.Task3.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate3.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask4.getBackground().toString())) {
            this.form.LayoutTask4.setBackground(Color.decode("#f2f2f2"));
            this.form.Task4.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate4.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask5.getBackground().toString())) {
            this.form.LayoutTask5.setBackground(Color.decode("#f2f2f2"));
            this.form.Task5.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate5.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask6.getBackground().toString())) {
            this.form.LayoutTask6.setBackground(Color.decode("#f2f2f2"));
            this.form.Task6.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate6.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask7.getBackground().toString())) {
            this.form.LayoutTask7.setBackground(Color.decode("#f2f2f2"));
            this.form.Task7.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate7.setIcon(uploadIcon);
        }
        
        if (clrSel.equals(this.form.LayoutTask8.getBackground().toString())) {
            this.form.LayoutTask8.setBackground(Color.decode("#f2f2f2"));
            this.form.Task8.setBackground(Color.decode("#f2f2f2"));
            this.form.BtnUpdate8.setIcon(uploadIcon);
        }
    }
    
    private void cleanInputText() {
        this.form.InputText.setText("");
    }
    
    private void cleanInputIdUpdate() {
        this.form.IdUpdate.setText(String.valueOf(0));
    }
    
    private void cleanControl() {
        this.cleanInputText();
        this.cleanInputIdUpdate();
    }
    
    private String alignItem(String str, int numSpaces) {
        return " ".repeat(numSpaces) + str;
    }
    
    private void getTasks() {
        this.query = new Query(this.conn.getConnPostgresql());
        
        Task[] tasks = this.query.readTasks();
        int IdTask1 = tasks[0].getId();
        int IdTask2 = tasks[1].getId();
        int IdTask3 = tasks[2].getId();
        int IdTask4 = tasks[3].getId();
        int IdTask5 = tasks[4].getId();
        int IdTask6 = tasks[5].getId();
        int IdTask7 = tasks[6].getId();
        int IdTask8 = tasks[7].getId();
        
        if (IdTask1 != 0) {
            this.form.IdTask1.setText(String.valueOf(IdTask1));
            this.form.Task1.setText(this.alignItem(tasks[0].getDescription(), 4));
            this.form.Task1.setSelected(tasks[0].getDone());
            this.form.Date1.setText(this.alignItem(tasks[0].getDate(), 8));
            this.form.LayoutTask1.setVisible(true);
        }

        if (IdTask2 != 0) {
            this.form.IdTask2.setText(String.valueOf(IdTask2));
            this.form.Task2.setText(this.alignItem(tasks[1].getDescription(), 4));
            this.form.Task2.setSelected(tasks[1].getDone());
            this.form.Date2.setText(this.alignItem(tasks[1].getDate(), 8));
            this.form.LayoutTask2.setVisible(true);
        }
        
        if (IdTask3 != 0) {
            this.form.IdTask3.setText(String.valueOf(IdTask3));
            this.form.Task3.setText(this.alignItem(tasks[2].getDescription(), 4));
            this.form.Task3.setSelected(tasks[2].getDone());
            this.form.Date3.setText(this.alignItem(tasks[2].getDate(), 8));
            this.form.LayoutTask3.setVisible(true);
        }

        if (IdTask4 != 0) {
            this.form.IdTask4.setText(String.valueOf(IdTask4));
            this.form.Task4.setText(this.alignItem(tasks[3].getDescription(), 4));
            this.form.Task4.setSelected(tasks[3].getDone());
            this.form.Date4.setText(this.alignItem(tasks[3].getDate(), 8));
            this.form.LayoutTask4.setVisible(true);
        }
        
        if (IdTask5 != 0) {
            this.form.IdTask5.setText(String.valueOf(IdTask5));
            this.form.Task5.setText(this.alignItem(tasks[4].getDescription(), 4));
            this.form.Task5.setSelected(tasks[4].getDone());
            this.form.Date5.setText(this.alignItem(tasks[4].getDate(), 8));
            this.form.LayoutTask5.setVisible(true);
        }

        if (IdTask6 != 0) {
            this.form.IdTask6.setText(String.valueOf(IdTask6));
            this.form.Task6.setText(this.alignItem(tasks[5].getDescription(), 4));
            this.form.Task6.setSelected(tasks[5].getDone());
            this.form.Date6.setText(this.alignItem(tasks[5].getDate(), 8));
            this.form.LayoutTask6.setVisible(true);
        }

        if (IdTask7 != 0) {
            this.form.IdTask7.setText(String.valueOf(IdTask7));
            this.form.Task7.setText(this.alignItem(tasks[6].getDescription(), 4));
            this.form.Task7.setSelected(tasks[6].getDone());
            this.form.Date7.setText(this.alignItem(tasks[6].getDate(), 8));
            this.form.LayoutTask7.setVisible(true);
        }

        if (IdTask8 != 0) {
            this.form.IdTask8.setText(String.valueOf(IdTask8));
            this.form.Task8.setText(this.alignItem(tasks[7].getDescription(), 4));
            this.form.Task8.setSelected(tasks[7].getDone());
            this.form.Date8.setText(this.alignItem(tasks[7].getDate(), 8));
            this.form.LayoutTask8.setVisible(true);
        }
    }
    
    @Override 
    public void actionPerformed(ActionEvent e) {
        this.query = new Query(this.conn.getConnPostgresql());
        
        if (e.getSource() == this.form.BtnAdd) { 
            String description = this.form.InputText.getText();
            String date = String.valueOf(this.form.InputDate.getDate());
            
            this.cleanControl();
            
            if ("".equals(description)) {
                JOptionPane.showMessageDialog(null, 
                        "Error al guardar. La tarea requiere de una descripción.");
            } else if ("null".equals(date)) {
                JOptionPane.showMessageDialog(null, 
                        "Error al guardar. La tarea requiere de una fecha.");
            } else if (this.query.createTask(description, date)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            } 
        } 
        
        this.ActionDelete(e);
        this.ActionUpload(e);
        this.ActionUpdate(e);
        this.ActionDone(e);    
    } 
    
    // Funciones de actualizar y borrar.
    
    private void ActionDelete(ActionEvent e) {
        int id;
        
        if (e.getSource() == this.form.BtnDrop1) {
            id = Integer.parseInt(this.form.IdTask1.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop2) {
            id = Integer.parseInt(this.form.IdTask2.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop3) {
            id = Integer.parseInt(this.form.IdTask3.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop4) {
            id = Integer.parseInt(this.form.IdTask4.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop5) {
            id = Integer.parseInt(this.form.IdTask5.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop6) {
            id = Integer.parseInt(this.form.IdTask6.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop7) {
            id = Integer.parseInt(this.form.IdTask7.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
        
        if (e.getSource() == this.form.BtnDrop8) {
            id = Integer.parseInt(this.form.IdTask8.getText());
            this.cleanControl();
            
            if (this.query.deleteTask(id)) {
                JOptionPane.showMessageDialog(null, "Registro Borrado");
                this.cleanLayouts();
                this.getTasks();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Borrar");
            } 
        }
    }
    
    private void ActionUpdate(ActionEvent e) {
        if (e.getSource() == this.form.BtnConfirmUpdate) {
            int id = Integer.parseInt(this.form.IdUpdate.getText());
            String description = this.form.InputText.getText();
            String date = String.valueOf(this.form.InputDate.getDate());
            this.cleanControl();
            
            if (id != 0) {
                if ("".equals(description) && "null".equals(date)) {
                    JOptionPane.showMessageDialog(null, 
                        "Error al guardar. La tarea requiere de una descripción o una fecha para ser actualizada.");
                } else if ("null".equals(date)) {
                    if (this.query.updateTaskByDescription(id, description)) {
                         JOptionPane.showMessageDialog(null, 
                        "La Tarea se ha actualizado con éxito.");
                        this.cleanLayouts();
                        this.cleanInputText();
                        this.cleanInputIdUpdate();
                        this.getTasks();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Actualizar.");
                    } 
                } else if ("".equals(description)) {
                     JOptionPane.showMessageDialog(null, 
                        "La Tarea se ha actualizado con éxito.");
                    if (this.query.updateTaskByDate(id, date)) {
                        this.cleanLayouts();
                        this.cleanInputText();
                        this.cleanInputIdUpdate();
                        this.getTasks();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Actualizar.");
                    } 
                } else {
                    if (this.query.updateTask(id, description, date)) {
                         JOptionPane.showMessageDialog(null, 
                        "La Tarea se ha actualizado con éxito.");
                        this.cleanLayouts();
                        this.cleanInputText();
                        this.cleanInputIdUpdate();
                        this.getTasks();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Actualizar.");
                    }
                } 
            }
        }
    }
    
    private void ActionUpload(ActionEvent e) {
        String clrSel = Color.decode("#5888ce").toString(); // Color seleccionado para update
        ImageIcon uploadIcon = new ImageIcon("src/icons/uploadIcon.png");
        ImageIcon uncheckIcon = new ImageIcon("src/icons/uncheckIcon.png");
        int id; 
        
        if (e.getSource() == this.form.BtnUpdate1) {
            if (clrSel.equals(this.form.LayoutTask1.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask1.setBackground(Color.decode("#f2f2f2"));
                this.form.Task1.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate1.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask1.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());

                this.setDefaultBg();
                this.form.LayoutTask1.setBackground(Color.decode("#5888ce"));
                this.form.Task1.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate1.setIcon(uncheckIcon);
            }
        } 
        
        if (e.getSource() == this.form.BtnUpdate2) {
            if (clrSel.equals(this.form.LayoutTask2.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask2.setBackground(Color.decode("#f2f2f2"));
                this.form.Task2.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate2.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask2.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());

                this.setDefaultBg();
                this.form.LayoutTask2.setBackground(Color.decode("#5888ce"));
                this.form.Task2.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate2.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate3) {
            if (clrSel.equals(this.form.LayoutTask3.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask3.setBackground(Color.decode("#f2f2f2"));
                this.form.Task3.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate3.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask3.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask3.setBackground(Color.decode("#5888ce"));
                this.form.Task3.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate3.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate4) {
            if (clrSel.equals(this.form.LayoutTask4.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask4.setBackground(Color.decode("#f2f2f2"));
                this.form.Task4.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate4.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask4.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask4.setBackground(Color.decode("#5888ce"));
                this.form.Task4.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate4.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate5) {
            if (clrSel.equals(this.form.LayoutTask5.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask5.setBackground(Color.decode("#f2f2f2"));
                this.form.Task5.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate5.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask5.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask5.setBackground(Color.decode("#5888ce"));
                this.form.Task5.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate5.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate6) {
            if (clrSel.equals(this.form.LayoutTask6.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask6.setBackground(Color.decode("#f2f2f2"));
                this.form.Task6.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate6.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask6.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask6.setBackground(Color.decode("#5888ce"));
                this.form.Task6.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate6.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate7) {
            if (clrSel.equals(this.form.LayoutTask7.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask7.setBackground(Color.decode("#f2f2f2"));
                this.form.Task7.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate7.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask7.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask7.setBackground(Color.decode("#5888ce"));
                this.form.Task7.setBackground(Color.decode("#5888ce"));
                 this.form.BtnUpdate7.setIcon(uncheckIcon);
            }
        }
        
        if (e.getSource() == this.form.BtnUpdate8) {
            if (clrSel.equals(this.form.LayoutTask8.getBackground().toString())) {
                
                this.cleanInputText();
                this.cleanInputIdUpdate();
                
                this.form.LayoutTask8.setBackground(Color.decode("#f2f2f2"));
                this.form.Task8.setBackground(Color.decode("#f2f2f2"));
                this.form.BtnUpdate8.setIcon(uploadIcon);
            } else {
                id = Integer.parseInt(this.form.IdTask8.getText());

                this.form.IdUpdate.setText(String.valueOf(id));
                this.form.InputText.setText(this.query.readTask(id).getDescription());


                this.setDefaultBg();
                this.form.LayoutTask8.setBackground(Color.decode("#5888ce"));
                this.form.Task8.setBackground(Color.decode("#5888ce"));
                this.form.BtnUpdate8.setIcon(uncheckIcon);
            }
        }
    }
    
    public void ActionDone(ActionEvent e) {
        int id;
        
        if (e.getSource() == this.form.Task1) {
            id = Integer.parseInt(this.form.IdTask1.getText());
   
            if (this.form.Task1.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task2) {
            id = Integer.parseInt(this.form.IdTask2.getText());
   
            if (this.form.Task2.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task3) {
            id = Integer.parseInt(this.form.IdTask3.getText());
   
            if (this.form.Task3.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task4) {
            id = Integer.parseInt(this.form.IdTask4.getText());
   
            if (this.form.Task4.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task5) {
            id = Integer.parseInt(this.form.IdTask5.getText());
   
            if (this.form.Task5.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task6) {
            id = Integer.parseInt(this.form.IdTask6.getText());
   
            if (this.form.Task6.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task7) {
            id = Integer.parseInt(this.form.IdTask7.getText());
   
            if (this.form.Task7.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
        
        if (e.getSource() == this.form.Task8) {
            id = Integer.parseInt(this.form.IdTask8.getText());
   
            if (this.form.Task8.getSelectedObjects() == null) {
                this.query.updateTaskDone(id, false);
            } else {
                this.query.updateTaskDone(id, true);
            } 
        }
    }
}
