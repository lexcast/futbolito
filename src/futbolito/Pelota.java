/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

/**
 *
 * @author Dany Cast
 */
public class Pelota {
    double x,y,vx,vy,desx,desy;int wh,rot;Image balon;double cuadro=0;Audios aud;
    public Pelota(float x,int y){
        aud=new Audios();
        wh=20;vx=0;vy=0;
        this.x=x-(wh/2);this.y=y-(wh/2);
        cargarImagen();
    }
    public void redefinir(float x,int y,int ladox,int ladoy){
        vx=80*ladox;vy=300*ladoy;
        this.x=x-(wh/2);this.y=y-(wh/2);
    }
    public void fisica(float dt){
        x += vx * dt;
        y += vy * dt;
        if ((vx < 0 && x <= 120 || vx > 0 && x + wh >= 780)&&(((int)y<=290-8)||((int)y>=410-8))){vx = -vx;new Audios().repro(vx);}
        if ((vx < 0 && x <= 70|| vx > 0 && x + wh >= 830)&&(((int)y>290+8)||((int)y<410-8))){vx=-vx/10;vy=vy/10;new Audios().repro(vx*10);}
        if ((vy < 0 && y < 150 || vy > 0 && y + wh >= 550)||((x+8<=120||x+wh-8>=780)&&(vy<0&&y<=290||vy>0&&y+wh>=410))){vy = -vy;new Audios().repro(vy);}
        if(x+wh>=780||x<=120){
            if((x>=780||x+wh<=120)&&MesaFutbol.goal==false&&MesaFutbol.pito==false){
                MesaFutbol.goal=true;
                if(x>=780){
                    MesaFutbol.lastgoal=1;
                    if(MesaFutbol.secondtime==false){MesaFutbol.jug.get(0).goals++;Ventana.mf.crono.establecerScore1();}
                    if(MesaFutbol.secondtime){MesaFutbol.jug.get(1).goals++;Ventana.mf.crono.establecerScore2();}
                }
                if(x+wh<=120){
                    MesaFutbol.lastgoal=-1;
                    if(MesaFutbol.secondtime==false){MesaFutbol.jug.get(1).goals++;Ventana.mf.crono.establecerScore2();}
                    if(MesaFutbol.secondtime){MesaFutbol.jug.get(0).goals++;Ventana.mf.crono.establecerScore1();}
                }
            }
        double pvx= vx;double pvy= vy;
        double ang=Math.toDegrees(Math.atan(vy/vx));
        if(780<=(int)x+wh-3&&780>=(int)x+wh-8){
            if(410<=(int)y+wh-3&&410>=(int)y+wh-8){
                if((pvx>=0&&pvy>=0)||ang<-45){
                    vx=pvy/2;vy=pvx/2;
                    vx=-vx;
                    vy=-vy;
                }
            }
            if(290>=(int)y+3&&290<=(int)y+8){
                if((pvx>=0&&pvy<=0)||(ang<45&&ang>=0)){
                    vx=pvy/2;vy=pvx/2;
                }
                            }
        }
        if(120>=(int)x+3&&120<=(int)x+8){
            if(410<=(int)y+wh-3&&410>=(int)y+wh-8){
                if((pvx<=0&&pvy>=0)||(ang<45&&ang>=0)){
                    vx=pvy/2;vy=pvx/2;
                }
            }
            if(290>=(int)y+3&&290<=(int)y+8){
                if((pvx<=0&&pvy<=0)||ang<-45){
                    vx=pvy/2;vy=pvx/2;
                    vx=-vx;
                    vy=-vy;
                }
            }
        }
        }
        for(int i=0;i<8;i++){
            int ax=(int)Ventana.mf.v.get(i).fig.get(0).ax;
            int aw=ax+(int)Ventana.mf.v.get(i).fig.get(0).aw;
            if((int)x<=aw&&(int)x>=ax-20)Ventana.mf.v.get(i).colision(i);
        }
        double des=(Math.pow(Math.pow(vx,2)+Math.pow(vy,2),0.5))/5;
        if(des*5>=30){
        desx=(vx*Math.pow(Math.abs(vx)+Math.abs(vy),-1)*100)*(float)des*dt;
        desy=(vy*Math.pow(Math.abs(vx)+Math.abs(vy),-1)*100)*(float)des*dt;
        vy-=desy*dt;vx-=desx*dt;
        }
        cuadro+=des*5*dt;
        if(cuadro>=70)cuadro=0;
    }
    public void cargarImagen(){
        balon=new ImageIcon(getClass().getResource("pelota/pelota2.png")).getImage();
    }
    public void paint(Graphics2D g2d){
        g2d.setTransform(new AffineTransform());
        if(vx==0)g2d.rotate(Math.atan(vy/vx)+Math.PI,x+10,y+10);
        if(vy==0&&vx<0)g2d.rotate(Math.atan(vy/vx),x+10,y+10);
        if(vy==0&&vx>0)g2d.rotate(Math.atan(vy/vx)+Math.PI,x+10,y+10);
        if(vx<0&&vy<0)g2d.rotate(Math.atan(vy/vx),x+10,y+10);
        if(vx>0&&vy<0)g2d.rotate(Math.atan(vy/vx)+Math.PI,x+10,y+10);
        if(vx<0&&vy>0)g2d.rotate(Math.atan(vy/vx),x+10,y+10);
        if(vx>0&&vy>0)g2d.rotate(Math.atan(vy/vx)+Math.PI,x+10,y+10);
        g2d.drawImage(balon,(int)x,(int)y,(int)x+wh,(int)y+wh,20*((int)cuadro/10),0,20*((int)cuadro/10)+20,20, null);
        g2d.setTransform(new AffineTransform());
    }

}
