/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Dany Cast
 */
public class PanelJugadores extends JPanel{
    int jug;Image num1,num2,marco,fondo,logo;
    public PanelJugadores(boolean first){
        setSize(200,700);
        jug=1;
        if(first)jug=0;
        marco=new ImageIcon(getClass().getResource("numeros/marco.png")).getImage();
        fondo=new ImageIcon(getClass().getResource("texture.png")).getImage();
    }
    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        int gol=MesaFutbol.jug.get(jug).goals;
        String gl=String.valueOf(gol);
        if(gol<10){
        num1=new ImageIcon(getClass().getResource("numeros/"+gl.charAt(0)+".png")).getImage();
        num2=new ImageIcon(getClass().getResource("numeros/0.png")).getImage();
        }
        if(gol>=10){
        num1=new ImageIcon(getClass().getResource("numeros/"+gl.charAt(1)+".png")).getImage();
        num2=new ImageIcon(getClass().getResource("numeros/"+gl.charAt(0)+".png")).getImage();
        }
        g2d.drawImage(fondo,0,0,200,700,this);
        g2d.drawImage(num1,100,287,80,126, this);
        g2d.drawImage(num2,20,287,80,126, this);
        g2d.drawImage(marco,5,270,190,160, this);
        logo=new ImageIcon(getClass().getResource(MesaFutbol.jug.get(jug).equipo+"/logo.png")).getImage();
        g2d.drawImage(logo,5,480,190,160, this);
    }

}
