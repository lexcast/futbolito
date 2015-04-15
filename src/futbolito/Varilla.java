/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Dany Cast
 */
public class Varilla {
    int n,x,vc,vy,u;float y,c=62;int nfig=1,jug;int[] im,a;String equipo;boolean arriba,abajo,derecha,izquierda;
    ArrayList<Figura> fig=new ArrayList<Figura>();Image var;
    public Varilla(int n){
        this.n=n;
        if((n==0||n==1||n==3||n==5)&&MesaFutbol.crono.min==0)jug=0;
        if((n==0||n==1||n==3||n==5)&&MesaFutbol.crono.min==45)jug=1;
        if((n==2||n==4||n==6||n==7)&&MesaFutbol.crono.min==0)jug=1;
        if((n==2||n==4||n==6||n==7)&&MesaFutbol.crono.min==45)jug=0;
        if(jug==0){
            equipo=MesaFutbol.jug.get(jug).equipo;
            if(n==1)nfig=MesaFutbol.jug.get(jug).ali[0];
            if(n==3)nfig=MesaFutbol.jug.get(jug).ali[1];
            if(n==5)nfig=MesaFutbol.jug.get(jug).ali[2];
            if(n==6)nfig=MesaFutbol.jug.get(jug).ali[0];
            if(n==4)nfig=MesaFutbol.jug.get(jug).ali[1];
            if(n==2)nfig=MesaFutbol.jug.get(jug).ali[2];
        }
        if(jug==1){
            equipo=MesaFutbol.jug.get(jug).equipo;
            if(n==6)nfig=MesaFutbol.jug.get(jug).ali[0];
            if(n==4)nfig=MesaFutbol.jug.get(jug).ali[1];
            if(n==2)nfig=MesaFutbol.jug.get(jug).ali[2];
            if(n==1)nfig=MesaFutbol.jug.get(jug).ali[0];
            if(n==3)nfig=MesaFutbol.jug.get(jug).ali[1];
            if(n==5)nfig=MesaFutbol.jug.get(jug).ali[2];
        }
            im=new int[8];
            if(jug==0)for(int i=0;i<8;i++)im[i]=i+1;
            if(jug==1)for(int i=0;i<8;i++)im[i]=8-i;
            if(jug==0){a=new int[]{1,2,3,4,5,6,7,8};}
            if(jug==1){a=new int[]{4,5,6,7,8,1,2,3};}
            u=a[2];
        x=160+((580/7)*n);y=55;
        for(int i=0;i<nfig;i++){
            int ix=x-38;int iy=(150+((400/nfig)*(i+1)))-((400/nfig)/2)-16;
            boolean por=false;
            if(n==7||n==0)por=true;
            fig.add(new Figura(i,equipo,ix,iy,jug,por));
        }
    }
    public void colision(int j){
        for(int i=0;i<nfig;i++){
            int py=(int)Ventana.mf.p.y;
            int ay=(int)fig.get(i).ay;
            int ah=ay+(int)fig.get(i).ah;
            if(py>=ay-20&&py<=ah)fig.get(i).colision(vc,vy);
        }
    }
    public void cargarImagen(){
        var=new ImageIcon(getClass().getResource("varilla/varilla"+im[u-1]+".png")).getImage();
    }
    public void fisica(float dt){
        vy=0;
        vc=0;
        if(arriba==true)vy=-200;
        if(abajo==true)vy=200;
        if(derecha==true)vc=-500;
        if(izquierda==true)vc=500;
        float f=fig.get(0).y+vy*dt;float g=fig.get(nfig-1).y+31+(vy*dt);
        if(f>150&&g<550){
        y+=vy*dt;
        for(int i=0;i<nfig;i++){
            fig.get(i).fisica(dt, vy, vc);
        }
        }
        c+=vc*dt;
        if(c>200)c=0;
        else if(c<0)c=200;
        actionZone();
    }
    public void actionZone(){
        if(c<=25)u=a[0];
        if(c>25&&c<=50)u=a[1];
        if(c>50&&c<=75)u=a[2];
        if(c>75&&c<=100)u=a[3];
        if(c>100&&c<=125)u=a[4];
        if(c>125&&c<=150)u=a[5];
        if(c>150&&c<=175)u=a[6];
        if(c>175)u=a[7];
    }
    public void paint(Graphics2D g2d){
        cargarImagen();
        if(jug==0)g2d.drawImage(var,x-8,(int)y,21,642,null);
        if(jug==1)g2d.drawImage(var,x+13,(int)y+642,-21,-642,null);
        for(int i=0;i<nfig;i++){
            fig.get(i).paint(g2d);
        }
    }
}
