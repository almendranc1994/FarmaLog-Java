/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alulab14
 */
public class ConectadosCtrl extends Thread{
    private EmpleadoBL empCtrl;
    public ArrayList<Empleado> lis;
    
    public ConectadosCtrl(){
        empCtrl = new EmpleadoBL();
        lis = new ArrayList<Empleado>();
        lis = empCtrl.getEmpleadosOnline();
        
    }
    
    public void run(){
        try{
            while(true){
                Thread.sleep(3000);
                lis = empCtrl.getEmpleadosOnline();
//                DefaultTableModel model = (DefaultTableModel)jt.getModel();
//                Object [] fila = new Object[1];
//                for(int i=0;i<lis.size();i++){
//                    fila[0] = lis.get(i).getNombres();
//                    model.addRow(fila);
//                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()+e.getStackTrace());
        }
    }
}
