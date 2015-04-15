/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Dany Cast
 */
public class MesaFutbol extends JPanel{
    static boolean goal=false,pito=true,change=false,secondtime=false;static int conteo=0,lastgoal;static Cronos crono;
    static ArrayList<Varilla> v=new ArrayList();
    static ArrayList<Jugador>jug=new ArrayList<Jugador>();
    static Pelota p=new Pelota(450,350);
    Image goalIma=new ImageIcon(getClass().getResource("gol.png")).getImage();
    Image silbato=new ImageIcon(getClass().getResource("silbato.png")).getImage();
    Image floor=new ImageIcon(getClass().getResource("suelo4.png")).getImage();
    Image mesa=new ImageIcon(getClass().getResource("wood3.png")).getImage();
    Image cancha=new ImageIcon(getClass().getResource("cancha3.png")).getImage();
    public MesaFutbol(){
        setSize(900,700);
        setDoubleBuffered(true);
        for(int i=0;i<2;i++){
            jug.add(new Jugador(i));
        }
        crono=new Cronos();
        for(int i=0;i<8;i++){
            v.add(new Varilla(i));
        }
    }
    public int importancia(Jugador j1,Jugador j2){
        int a=0;
        if (j1.jg>j2.jg){
            a=0;
        }
        if (j1.jg<j2.jg){
            a=1;
        }
        if (j1.jg==j2.jg&&j1.gol>j2.gol){
            a=0;
        }
        if (j1.jg==j2.jg&&j1.gol<j2.gol){
            a=1;
        }
        return a;
    }

    public void paint(Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.drawImage(floor,0,0,900,700,this);
        g2d.drawImage(cancha,120,150,660,400,this);
        g2d.drawImage(cancha,70,290,120,410,110,10,160,130,this);
        g2d.drawImage(cancha,780,290,830,410,110,10,160,130,this);
        p.paint(g2d);
        for(int i=0;i<v.size();i++){
            v.get(i).paint(g2d);
        }
        g2d.drawImage(mesa,0,0,900,700,this);
        if(goal==true)g2d.drawImage(goalIma,250, 200, 500, 210,this);
        if(pito==true)g2d.drawImage(silbato,350, 200, 200, 119,this);
        crono.paint(g2d);

    }

    


}
