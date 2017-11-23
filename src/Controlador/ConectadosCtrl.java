/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author alulab14
 */
public class ConectadosCtrl extends Thread{
    private EmpleadoBL empCtrl;
    private ArrayList<Empleado> lis;
    public ConectadosCtrl(){
        empCtrl = new EmpleadoBL();
        lis = new ArrayList<Empleado>();
    }
    
    public void run(){
        try{
            while(true){
                Thread.sleep(3000);
                lis = empCtrl.getEmpleadosOnline();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()+e.getStackTrace());
        }
    }
}
