/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



/**
 *
 * @author Dany Cast
 */
public class Ventana extends JFrame{
    static MesaFutbol mf;int[] dir={0,1,2,3,4,5,6,7};
    boolean volt=false,tN,tM,tUP,tDOWN,tLEFT,tRIGHT,tB,tV,tW,tA,tS,tD,t4,t5,t6,tADD;
    public Ventana(){
        setSize(900,700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        iniciarComponentes();
        setVisible(true);
        this.setLocationRelativeTo(null);
        addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_H)volt=!volt;
        if(e.getKeyCode()==KeyEvent.VK_N)tN=true;
        if(e.getKeyCode()==KeyEvent.VK_M)tM=true;
        if(e.getKeyCode()==KeyEvent.VK_UP)tUP=true;
        if(e.getKeyCode()==KeyEvent.VK_DOWN)tDOWN=true;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)tRIGHT=true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT)tLEFT=true;
        if(e.getKeyCode()==KeyEvent.VK_B)tB=true;
        if(e.getKeyCode()==KeyEvent.VK_V)tV=true;
        if(e.getKeyCode()==KeyEvent.VK_W)tW=true;
        if(e.getKeyCode()==KeyEvent.VK_A)tA=true;
        if(e.getKeyCode()==KeyEvent.VK_S)tS=true;
        if(e.getKeyCode()==KeyEvent.VK_D)tD=true;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD4)t4=true;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD5)t5=true;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD6)t6=true;
        if(e.getKeyCode()==KeyEvent.VK_ADD)tADD=true;
    }
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_N)tN=false;
        if(e.getKeyCode()==KeyEvent.VK_M)tM=false;
        if(e.getKeyCode()==KeyEvent.VK_UP)tUP=false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN)tDOWN=false;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)tRIGHT=false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT)tLEFT=false;
        if(e.getKeyCode()==KeyEvent.VK_B)tB=false;
        if(e.getKeyCode()==KeyEvent.VK_V)tV=false;
        if(e.getKeyCode()==KeyEvent.VK_W)tW=false;
        if(e.getKeyCode()==KeyEvent.VK_A)tA=false;
        if(e.getKeyCode()==KeyEvent.VK_S)tS=false;
        if(e.getKeyCode()==KeyEvent.VK_D)tD=false;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD4)t4=false;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD5)t5=false;
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD6)t6=false;
        if(e.getKeyCode()==KeyEvent.VK_ADD)tADD=false;
    }    
        });
        motor();
    }
    public void iniciarComponentes(){
        mf=new MesaFutbol();
        add(mf);
    }
    public void fisicaTeclado(){
        if(tB==false&&tN==false&&tM==false&&tV&&tW)arriba(dir[0],true);else arriba(dir[0],false);
        if(tB==false&&tN==false&&tM==false&&tV&&tS)abajo(dir[0],true);else abajo(dir[0],false);
        if(tB==false&&tN==false&&tM==false&&tV&&tD)derecha(dir[0],true);else derecha(dir[0],false);
        if(tB==false&&tN==false&&tM==false&&tV&&tA)izquierda(dir[0],true);else izquierda(dir[0],false);
        if(tV==false&&tN==false&&tM==false&&tB&&tW)arriba(dir[1],true);else arriba(dir[1],false);
        if(tV==false&&tN==false&&tM==false&&tB&&tS)abajo(dir[1],true);else abajo(dir[1],false);
        if(tV==false&&tN==false&&tM==false&&tB&&tD)derecha(dir[1],true);else derecha(dir[1],false);
        if(tV==false&&tN==false&&tM==false&&tB&&tA)izquierda(dir[1],true);else izquierda(dir[1],false);
        if(tB==false&&tV==false&&tM==false&&tN&&tW)arriba(dir[3],true);else arriba(dir[3],false);
        if(tB==false&&tV==false&&tM==false&&tN&&tS)abajo(dir[3],true);else abajo(dir[3],false);
        if(tB==false&&tV==false&&tM==false&&tN&&tD)derecha(dir[3],true);else derecha(dir[3],false);
        if(tB==false&&tV==false&&tM==false&&tN&&tA)izquierda(dir[3],true);else izquierda(dir[3],false);
        if(tB==false&&tN==false&&tV==false&&tM&&tW)arriba(dir[5],true);else arriba(dir[5],false);
        if(tB==false&&tN==false&&tV==false&&tM&&tS)abajo(dir[5],true);else abajo(dir[5],false);
        if(tB==false&&tN==false&&tV==false&&tM&&tD)derecha(dir[5],true);else derecha(dir[5],false);
        if(tB==false&&tN==false&&tV==false&&tM&&tA)izquierda(dir[5],true);else izquierda(dir[5],false);
        if(t5==false&&t6==false&&tADD==false&&t4&&tUP)arriba(dir[2],true);else arriba(dir[2],false);
        if(t5==false&&t6==false&&tADD==false&&t4&&tDOWN)abajo(dir[2],true);else abajo(dir[2],false);
        if(t5==false&&t6==false&&tADD==false&&t4&&tRIGHT)derecha(dir[2],true);else derecha(dir[2],false);
        if(t5==false&&t6==false&&tADD==false&&t4&&tLEFT)izquierda(dir[2],true);else izquierda(dir[2],false);
        if(t4==false&&t6==false&&tADD==false&&t5&&tUP)arriba(dir[4],true);else arriba(dir[4],false);
        if(t4==false&&t6==false&&tADD==false&&t5&&tDOWN)abajo(dir[4],true);else abajo(dir[4],false);
        if(t4==false&&t6==false&&tADD==false&&t5&&tRIGHT)derecha(dir[4],true);else derecha(dir[4],false);
        if(t4==false&&t6==false&&tADD==false&&t5&&tLEFT)izquierda(dir[4],true);else izquierda(dir[4],false);
        if(t5==false&&t4==false&&tADD==false&&t6&&tUP)arriba(dir[6],true);else arriba(dir[6],false);
        if(t5==false&&t4==false&&tADD==false&&t6&&tDOWN)abajo(dir[6],true);else abajo(dir[6],false);
        if(t5==false&&t4==false&&tADD==false&&t6&&tRIGHT)derecha(dir[6],true);else derecha(dir[6],false);
        if(t5==false&&t4==false&&tADD==false&&t6&&tLEFT)izquierda(dir[6],true);else izquierda(dir[6],false);
        if(t5==false&&t6==false&&t4==false&&tADD&&tUP)arriba(dir[7],true);else arriba(dir[7],false);
        if(t5==false&&t6==false&&t4==false&&tADD&&tDOWN)abajo(dir[7],true);else abajo(dir[7],false);
        if(t5==false&&t6==false&&t4==false&&tADD&&tRIGHT)derecha(dir[7],true);else derecha(dir[7],false);
        if(t5==false&&t6==false&&t4==false&&tADD&&tLEFT)izquierda(dir[7],true);else izquierda(dir[7],false);

        
}
    public void arriba(int nv,boolean pressed){
        mf.v.get(nv).arriba=pressed;
    }
    public void abajo(int nv,boolean pressed){
        mf.v.get(nv).abajo=pressed;
    }
    public void derecha(int nv,boolean pressed){
        mf.v.get(nv).derecha=pressed;
    }
    public void izquierda(int nv,boolean pressed){
        mf.v.get(nv).izquierda=pressed;
    }
        public void motor() {
        while (true) {
            if(volt){
            fisicaTeclado();
            mf.p.fisica((float)0.015);
            for(int i=0;i<8;i++){
            mf.v.get(i).fisica((float)0.015);
            mf.crono.fisica();
            if(MesaFutbol.goal){
                MesaFutbol.conteo++;
                if(MesaFutbol.conteo>=1500||MesaFutbol.pito){
                    if(MesaFutbol.conteo>=1500)MesaFutbol.p.redefinir(450,350,MesaFutbol.lastgoal,-1);
                    MesaFutbol.conteo=0;
                    MesaFutbol.goal=false;
                }
            }
            if(MesaFutbol.pito){
                MesaFutbol.conteo++;
                if(MesaFutbol.conteo>=1500){
                    MesaFutbol.conteo=0;
                    MesaFutbol.pito=false;
                    int min=mf.crono.min;
                    if(min==0)MesaFutbol.p.redefinir(450,350,-1,-1);
                    else if(min==45&&MesaFutbol.change){MesaFutbol.change=false;MesaFutbol.secondtime=true;MesaFutbol.p.redefinir(450,350,-1,-1);}
                    else if(min==45&&MesaFutbol.change==false){MesaFutbol.p.redefinir(450,350,0,0);MesaFutbol.change=true;}
                    else if(min==90)System.exit(0);
                }
            }
            if(MesaFutbol.change&&MesaFutbol.pito==false){
                MesaFutbol.conteo++;
                if(MesaFutbol.conteo>=500){
                    for(int j=0;j<8;j++){
                    mf.v.remove(0);
                    }
                    for(int j=0;j<8;j++){
                    mf.v.add(new Varilla(j));
                    }
                    dir=new int[]{2,4,0,6,1,7,3,5};
                }
                if(MesaFutbol.conteo>=1000){
                    MesaFutbol.conteo=0;
                    MesaFutbol.pito=true;
                }
            }
            }}
            dibuja();
        }
    }
    public void dibuja(){
        try{
        new Thread().start();
        Thread.sleep(10);
                   mf.repaint();
        }catch(Exception e){}
    }

}
