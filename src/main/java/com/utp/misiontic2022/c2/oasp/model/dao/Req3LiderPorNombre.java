package com.utp.misiontic2022.c2.oasp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//Librerías para SQL y Base de Datos
import java.sql.SQLException;
//Estructura de datos
import java.util.ArrayList;

import com.utp.misiontic2022.c2.oasp.model.vo.O3LiderPorNombre;
import com.utp.misiontic2022.c2.oasp.util.JDBCUtilities;

public class Req3LiderPorNombre {
    //Obtener los proyectos por Tipo en la ciudad de Montería
    public ArrayList<O3LiderPorNombre> requerimiento3() throws SQLException {

        ArrayList<O3LiderPorNombre> respuesta = new ArrayList<O3LiderPorNombre>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "select id_lider, nombre, primer_apellido from Lider "+
                                "where Primer_Apellido like '%z' order by nombre asc";
                                
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while(resultado.next()){
                O3LiderPorNombre nombres = new O3LiderPorNombre();
                nombres.setNombre(resultado.getString("nombre"));
                nombres.setApellido(resultado.getString("primer_apellido"));
                nombres.setId_lider(resultado.getInt("id_lider"));
                respuesta.add(nombres);
            }
            resultado.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error en la consulta "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }     
}
