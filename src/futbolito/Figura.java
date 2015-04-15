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
public class Figura {
    int n,x,u;float y,c=62,ax,ay,aw,ah;String equipo;Image equ;int jug;int[] im,a;boolean por;
    public Figura(int n,String equipo,int x,int y,int jug,boolean por){
        this.n=n;
        this.equipo=equipo;
        this.x=x;this.y=y;
        this.por=por;
        if(MesaFutbol.crono.min==0){
            this.jug=jug;
            im=new int[8];
            if(jug==0)for(int i=0;i<8;i++)im[i]=i+1;
            if(jug==1)for(int i=0;i<8;i++)im[i]=8-i;
            if(jug==0){a=new int[]{1,2,3,4,5,6,7,8};}
            if(jug==1){a=new int[]{4,5,6,7,8,1,2,3};}
            u=a[2];
            }
        if(MesaFutbol.crono.min==45){
            if(jug==0)this.jug=1;
            if(jug==1)this.jug=0;
            im=new int[8];
            if(jug==1)for(int i=0;i<8;i++)im[i]=i+1;
            if(jug==0)for(int i=0;i<8;i++)im[i]=8-i;
            if(jug==1){a=new int[]{1,2,3,4,5,6,7,8};}
            if(jug==0){a=new int[]{4,5,6,7,8,1,2,3};}
            u=a[2];
        }
    }
    public void cargarImagen(){
        if(por==false)equ=new ImageIcon(getClass().getResource(equipo+"/"+equipo+im[u-1]+".png")).getImage();
        if(por==true)equ=new ImageIcon(getClass().getResource(equipo+"/portero"+im[u-1]+".png")).getImage();
    }
    public void colision(int vc,int vy){
        int px=(int)Ventana.mf.p.x;int py=(int)Ventana.mf.p.y;
        int pwh=Ventana.mf.p.wh;double pvx=Ventana.mf.p.vx;double pvy=Ventana.mf.p.vy;
        double ang=Math.toDegrees(Math.atan(pvy/pvx));
        double fuerza=Math.sin(Math.PI/4)*Math.pow((vc*vc)+(vy*vy),0.5);
        if(py+9>=(int)ay-4&&py+12<=(int)ay+(int)ah+4){
            if(px<=(int)ax+(int)aw&&px>=(int)ax+(int)aw-6){
                if(pvx<0){Ventana.mf.p.vx=-pvx/2;}
            Ventana.mf.p.vx-=vc;
            }
            if(px+pwh>=(int)ax&&px+pwh<=(int)ax+6){
                if(pvx>0){Ventana.mf.p.vx=-pvx/2;}
            Ventana.mf.p.vx-=vc;
            }
        }
        if(px+9>=(int)ax-4&&px+12<=(int)ax+(int)aw+4){
            if(py<=(int)ay+(int)ah&&py>=(int)ay+(int)ah-6){
                if(pvy<0){Ventana.mf.p.vy=-pvy/2;}
            Ventana.mf.p.vy+=vy;
            }
            if(py+pwh>=(int)ay&&py+pwh<=(int)ay+6){
                if(pvy>0){Ventana.mf.p.vy=-pvy/2;}
            Ventana.mf.p.vy+=vy;
            }
        }
        if((int)ax<=px+pwh-3&&(int)ax>=px+pwh-8){
            if((int)ay<=py+pwh-3&&(int)ay>=py+pwh-8){
                if((pvx>=0&&pvy>=0)||ang<-45){
                    Ventana.mf.p.vx=pvy/2;Ventana.mf.p.vy=pvx/2;
                    Ventana.mf.p.vx=-Ventana.mf.p.vx;
                    Ventana.mf.p.vy=-Ventana.mf.p.vy;            
                }
                Ventana.mf.p.vx-=fuerza;Ventana.mf.p.vy-=fuerza;
            }
            if((int)ay+(int)ah>=py+3&&(int)ay+(int)ah<=py+8){
                if((pvx>=0&&pvy<=0)||(ang<45&&ang>=0)){
                    Ventana.mf.p.vx=pvy/2;Ventana.mf.p.vy=pvx/2;
                }
                Ventana.mf.p.vx-=fuerza;Ventana.mf.p.vy+=fuerza;
            }
        }
        if((int)ax+(int)aw>=px+3&&(int)ax+(int)aw<=px+8){
            if((int)ay<=py+pwh-3&&(int)ay>=py+pwh-8){
                if((pvx<=0&&pvy>=0)||(ang<45&&ang>=0)){
                    Ventana.mf.p.vx=pvy/2;Ventana.mf.p.vy=pvx/2;
                }
                Ventana.mf.p.vx+=fuerza;Ventana.mf.p.vy-=fuerza;
            }
            if((int)ay+(int)ah>=py+3&&(int)ay+(int)ah<=py+8){
                if((pvx<=0&&pvy<=0)||ang<-45){
                    Ventana.mf.p.vx=pvy/2;Ventana.mf.p.vy=pvx/2;
                    Ventana.mf.p.vx=-Ventana.mf.p.vx;
                    Ventana.mf.p.vy=-Ventana.mf.p.vy;                   
                }
                Ventana.mf.p.vx+=fuerza;Ventana.mf.p.vy+=fuerza;
            }
        }
    }
    public void actionZone(int vc){
        if(c<=25){u=a[0];ax=0;ay=0;}
        if(c>25&&c<=50){u=a[1];if(vc!=0){ax=(x+62)-(c-30);}if(vc==0){ax=(x+62)-(25-30);}ay=y+9;aw=5;ah=15;}
        if(c>50&&c<=75){u=a[2];ax=x+37;ay=y+9;aw=11;ah=15;}
        if(c>75&&c<=100){u=a[3];if(vc!=0){ax=(x+37)-(c-75);}if(vc==0){ax=(x+37)-(100-75);}ay=y+9;aw=5;ah=15;}
        if(c>100&&c<=125){u=a[4];ax=0;ay=0;}
        if(c>125&&c<=150){u=a[5];if(vc!=0){ax=(x+62)-(c-130);}if(vc==0){ax=(x+62)-(130-130);}ay=y+11;aw=5;ah=10;}
        if(c>150&&c<=175){u=a[6];ax=x+37;ay=y+11;aw=11;ah=10;}
        if(c>175){u=a[7];if(vc!=0){ax=(x+37)-(c-175);}if(vc==0){ax=(x+37)-(200-175);}ay=y+11;aw=5;ah=10;}
    }
    public void fisica(float dt,int vy,int vc){
        y+=vy*dt;
        c+=vc*dt;
        if(c>200)c=0;
        else if(c<0)c=200;
        actionZone(vc);
    }
    public void paint(Graphics2D g2d){
        cargarImagen();
        if(jug==0)g2d.drawImage(equ,x,(int)y,81,32,null);
        if(jug==1)g2d.drawImage(equ,x+81,(int)y,-81,32,null);

    }

}
