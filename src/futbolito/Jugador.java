/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;

/**
 *
 * @author Dany Cast
 */
public class Jugador {
    int n,jj,jg,gol;int[]ali;String equipo;int goals;
    public Jugador(int n){
        this.n=n;
        goals=0;
        ali=new int[3];
        imaginando();
    }
    public void imaginando(){
        if(n==0){
            jj=5;jg=3;gol=7;ali[0]=3;ali[1]=4;ali[2]=3;equipo="mexico";
        }
        if(n==1){
            jj=6;jg=3;gol=2;ali[0]=3;ali[1]=4;ali[2]=3;equipo="madrid";
        }
    }

}
