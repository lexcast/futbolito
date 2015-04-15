/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package futbolito;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
/**
 *
 * @author Dany Cast
 */
public class Audios {
    Clip sonido;
    public Audios(){
        try{
        sonido = AudioSystem.getClip();
        sonido.open(AudioSystem.getAudioInputStream(getClass().getResource("toc.wav")));
        }catch(Exception e){}
    }
    public void repro(double v){
        FloatControl gainControl = (FloatControl)sonido.getControl(FloatControl.Type.MASTER_GAIN);
        double gain = (Math.abs(v)-100)/1000;    // number between 0 and 1 (loudest)
        if(gain>1)gain=1;
        float dB = (float)(Math.log(gain)/Math.log(10.0)*20.0);
        gainControl.setValue(dB);
        sonido.stop();
        sonido.start();
    }

}
