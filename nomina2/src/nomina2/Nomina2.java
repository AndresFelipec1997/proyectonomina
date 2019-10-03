/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina2;

import controladores.Empleadocontrolador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Empleado;

/**
 *
 * @author ASUS PC
 */
public class Nomina2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Empleadocontrolador empleadocontrolador = new Empleadocontrolador(); 
             
        Empleado empleado = new Empleado();
        empleado.setIdempleado(123456);
      
        
        try {
            //empleadocontrolador.create(empleado);
            empleadocontrolador.create(empleado);
           
        } catch (Exception ex) {
            Logger.getLogger(Nomina2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Listar todos los Estudiantes
        List<Empleado> listaEmpleado = null;
        try {
            listaEmpleado = empleadocontrolador.list();
        } catch (Exception ex) {
            Logger.getLogger(Nomina2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listaEmpleado);
        
        //Encontrar un estudiante
        Empleado estudiante = null;
        try {
            estudiante = empleadocontrolador.getById(123456);
        } catch (Exception ex) {
            Logger.getLogger(Nomina2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(estudiante);
    }  
    }
    


