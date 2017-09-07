/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Votacion2;
import Extra.MyIcon;
import Extra.MyIconT;
import Extra.OtherIcon;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *6
 * @author Margareth Milano
 */
public class Votacion2 {
    
    public static void main(String[] args) {
        
        JFrame ventana= new JFrame("Centro de votacion de la Republica Argentina");
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container= ventana.getContentPane();
        container.setLayout( new FlowLayout());
        JLabel mensaje= new JLabel("Bienvenido al proceso automatizado de votacion");
        container.add(mensaje);
        ventana.setVisible(true);
       
        int rta= JOptionPane.showConfirmDialog(ventana, "Desea iniciar el proceso?", "Pregunta", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        String nombre;
        int edad;
        int eleccion;
        int votosMacri= 0;
        int votosKirchner= 0;
        int faltante;
        MyIcon icon = new MyIcon();
        OtherIcon icon2 = new OtherIcon();
        MyIconT icon3 = new MyIconT();
        while (rta==0){
          
            nombre= JOptionPane.showInputDialog(ventana, "Ingrese su nombre", "Escriba su nombre aqui");
            edad= Integer.parseInt(JOptionPane.showInputDialog(ventana, "Que edad tienes " +nombre+ "?", "Pregunta", 
                    JOptionPane.QUESTION_MESSAGE));
            faltante= 18-edad;
            
            if (edad>= 18){
                eleccion= Integer.parseInt(JOptionPane.showInputDialog(ventana, "Seleccione su candidato:\n1.Macri   "
                        + "2.Kirchner", "Escoja 1 o 2"));
                if (eleccion==1){
                    votosMacri= votosMacri+1; 
                }
                else {
                    votosKirchner= votosKirchner+1;  
                }
            }
            else{
                JOptionPane.showMessageDialog(ventana, "Lo sentimos, aun no puedes votar. Vuelve en "+ faltante+ " anios",
                        "Informacion", JOptionPane.DEFAULT_OPTION, icon3);
            }
            
            rta= JOptionPane.showConfirmDialog(ventana, "Desea realizar otra votacion?", "Pregunta", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
       
        JOptionPane.showMessageDialog(ventana, "El candidato Macri obtuvo "+ votosMacri+ " votos y "
                + "la canditata Kirchner obtuvo "+ votosKirchner+ " votos", "Resultado", 
                JOptionPane.DEFAULT_OPTION, icon2);
        if (votosMacri>votosKirchner){
            JOptionPane.showMessageDialog(ventana, "Macri es el ganador", "Resultado", JOptionPane.DEFAULT_OPTION, icon);
        }
        else{
            if (votosMacri==votosKirchner){
                JOptionPane.showMessageDialog(ventana, "Hay un empate entre los candidatos");
            }
            else{
                JOptionPane.showMessageDialog(ventana, "Kirchner es la ganadora", "Resultado", JOptionPane.DEFAULT_OPTION,
                icon);
            }
        }
       
    }
    
}