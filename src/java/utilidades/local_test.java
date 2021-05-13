/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import logica.OperProducto;
import dto.Producto;
import java.util.List;
/**
 *
 * @author CARITO
 */
public class local_test {
    
    public static void main(String[] args){
        Producto e = new Producto(
                "hola",
                "hola",
                "hola",
                "hola",
                22);
        
        OperProducto oper = new OperProducto();
       // oper.insert(e);
       // oper.delete(5);
       // oper.update(e, 2);
        
        List<Producto> lista = oper.getAll();
        for(int i = 0; i<lista.size(); i++){
            System.out.println(lista.get(i).toString()+"\n\n");
        }
        
        
        
    }
}
