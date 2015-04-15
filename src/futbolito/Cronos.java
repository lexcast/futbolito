/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Dany Cast
 */
public class Cronos {
    int min,seg,con;Image []num=new Image[10];Image m1,m2,s1,s2,num1,num2,num3,num4,marco,logo1,logo2;
    public Cronos(){
        min=0;seg=0;con=0;
        for(int i=0;i<=9;i++){
            num[i]=new ImageIcon(getClass().getResource("numeros/"+i+".png")).getImage();
        }
        num1=num[0];num2=num[0];num3=num[0];num4=num[0];
        marco=new ImageIcon(getClass().getResource("numeros/marcador2.png")).getImage();
        logo1=new ImageIcon(getClass().getResource(MesaFutbol.jug.get(0).equipo+"/logo.png")).getImage();
        logo2=new ImageIcon(getClass().getResource(MesaFutbol.jug.get(1).equipo+"/logo.png")).getImage();
    }
    public void fisica(){
        if(MesaFutbol.pito==false&&MesaFutbol.change==false){
        con++;
        if(con>=15){seg++;con=0;}
        if(seg>=60){min++;seg=0;}
        if((min==45&&seg==0&&con==0)||(min==90&&seg==0&&con==0))MesaFutbol.pito=true;
        }
    }
    public void establecerScore1(){
        int gol=MesaFutbol.jug.get(0).goals;
        String gl=String.valueOf(gol);
        if(gol<10){
        num1=num[gol];
        num2=num[0];
        }
        if(gol>=10){
        num1=num[gl.charAt(1)];
        num2=num[gl.charAt(0)];
        }
    }
    public void establecerScore2(){
        int gol=MesaFutbol.jug.get(1).goals;
        String gl=String.valueOf(gol);
        if(gol<10){
        num3=num[gol];
        num4=num[0];
        }
        if(gol>=10){
        num3=num[gl.charAt(1)];
        num4=num[gl.charAt(0)];
        }
    }
    public void establecerTime(){
        if(min<10){
            m1=num[0];m2=num[min];
        }
        if(min>=10){
            m1=num[min/10];m2=num[min-((min/10)*10)];
        }
        if(seg<10){
            s1=num[0];s2=num[seg];
        }
        if(seg>=10){
            s1=num[seg/10];s2=num[seg-((seg/10)*10)];
        }
    }
    public void paint(Graphics2D g2d){
        establecerTime();
        g2d.drawImage(marco,315,20,270,30,null);
        g2d.drawImage(m1,420,20,15,30,null);
        g2d.drawImage(m2,435,20,15,30,null);
        g2d.drawImage(s1,450,20,15,30,null);
        g2d.drawImage(s2,465,20,15,30,null);
        g2d.drawImage(num1,345,20,15,30,null);
        g2d.drawImage(num2,330,20,15,30,null);
        g2d.drawImage(num3,555,20,15,30,null);
        g2d.drawImage(num4,540,20,15,30,null);
        g2d.drawImage(logo1,370,15,40,40,null);
        g2d.drawImage(logo2,490,15,40,40,null);
    }

}
