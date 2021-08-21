package com.utp.misiontic2022.c2.oasp;
import com.utp.misiontic2022.c2.oasp.view.VistaRequerimientos;

import java.awt.EventQueue;

public class App {
    public static void main( String[] args ){        

        /*//Requerimiento 1 - Reto3
        VistaRequerimientos.requerimiento1();
        System.out.println();

         //Requerimiento 2 - Reto3
        VistaRequerimientos.requerimiento2();
         System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientos.requerimiento3();
        System.out.println();*/
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run(){
            try{
                VistaRequerimientos ventana = new VistaRequerimientos();
                ventana.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
            }

        } ); 
    }
}
