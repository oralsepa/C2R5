package com.utp.misiontic2022.c2.oasp.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.utp.misiontic2022.c2.oasp.controller.CtrlReq;
import com.utp.misiontic2022.c2.oasp.model.vo.O1LiderPorSalario;
import com.utp.misiontic2022.c2.oasp.model.vo.O2ProyectoPorTipo;
import com.utp.misiontic2022.c2.oasp.model.vo.O3LiderPorNombre;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaRequerimientos extends JFrame{
    
    public static final CtrlReq controlador = new CtrlReq();

    private JPanel contentPane;
    private static JTextArea areaDeTexto;
    private JComboBox<String> cb;

    public VistaRequerimientos(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 50, 800, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);;

        JLabel etiqueta = new JLabel("Reportes - Constructora Construyendo Sueños");
        etiqueta.setBounds(28,10,500,16);
        contentPane.add(etiqueta);

        JScrollPane barra = new JScrollPane();
        barra.setBounds(28, 35, 740, 450);
        contentPane.add(barra);

        areaDeTexto = new JTextArea();
        barra.setViewportView(areaDeTexto);

        JButton btnconsulta1 = new JButton("Consultar");
        btnconsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String reporte =(String) cb.getSelectedItem();
                if(reporte == "Reporte por Salario"){
                    requerimiento1();
                }else if (reporte == "Reporte por Estratro"){
                    requerimiento2();
                }else {
                    requerimiento3();
                }
            }
        });
        btnconsulta1.setBounds(350, 500, 120, 30);
        contentPane.add(btnconsulta1);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                areaDeTexto.setText("");
            }
        });
        btnLimpiar.setBounds(600, 500, 120, 30);
        contentPane.add(btnLimpiar);

        cb = new JComboBox<>();
        cb.addItem("Reporte por Salario");
        cb.addItem("Reporte por Estratro");
        cb.addItem("Reporte por Nombre");
        cb.setBounds(28,500,300,30);
        contentPane.add(cb);

    }


    public static void requerimiento1(){
        //System.out.println("*** Lideres por Salario ***");
        try{
            ArrayList<O1LiderPorSalario> listaLideres = controlador.Requerimiento_1();
            String salida = "*** Lideres por Salario ***\n\nNombre\tPrimer Apellido\tID del Lider\tSalario\n\n";

            for(O1LiderPorSalario salarios : listaLideres){
              //  System.out.printf("El Lider %s %s con Id %d Tiene un salario de  %d %n",
                    salida += salarios.getNombre();
                    salida += "\t";
                    salida += salarios.getApellido();
                    salida += "\t";
                    salida += salarios.getId_lider();
                    salida += "\t";
                    salida += salarios.getSalario();
                    salida += "\n";
            }
            areaDeTexto.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    }

    public static void requerimiento2(){     
        //System.out.println("*** Proyectos por Tipo ***");
        try{
            ArrayList<O2ProyectoPorTipo> listaProyectos = controlador.Requerimiento_2();
            String salida = "*** Proyectos por Tipo ***\n\nID_Proyecto\tConstructora\t\tCiudad\tEstrato\n\n";
            
            for(O2ProyectoPorTipo proyectos : listaProyectos){
                //System.out.printf("El proyecto con ID_Proyecto %d de la constructora: %s de la ciudad %s, tiene un estrato asignado de %d %n",
                    salida += proyectos.getId_proyecto();
                    salida += "\t";
                    //salida += proyectos.getConstructora();
                    String cnst = proyectos.getConstructora();
                    if (cnst.contains("Pegaso")){
                        salida += proyectos.getConstructora()+"\t";
                    }else{
                        salida += proyectos.getConstructora();
                    }
                    salida += "\t";
                    salida += proyectos.getCiudad();
                    salida += "\t";
                    salida += proyectos.getEstrato();
                    salida += "\n";
            }
            areaDeTexto.setText(salida);
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        //System.out.println("*** Lideres por Nombre ***");
        try{
            ArrayList<O3LiderPorNombre> nombreLideres = controlador.Requerimiento_3();  
            String salida = "*** Lideres por Nombre ***\n\nID del Lider\tNombre\tPrimer Apellido\n\n";
            for(O3LiderPorNombre nombres : nombreLideres){
                //System.out.printf("El Lider con ID %d se llama %s %s %n",
                   salida += nombres.getId_lider();
                   salida += "\t";
                   salida += nombres.getNombre();
                   salida += "\t";
                   salida += nombres.getApellido();
                   salida += "\n";
            }
            areaDeTexto.setText(salida);
        }catch(SQLException e){
            System.err.println(e);
        }
    }

}
