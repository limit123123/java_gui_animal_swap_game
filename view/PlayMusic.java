package Animal_game.view;
import java.net.URI;
import java.net.URL;
import java.io.File;
import java.applet.Applet;
import java.applet.AudioClip;
public class PlayMusic implements Runnable {
    String musicName;
    Thread threadPlay;
    AudioClip clip = null;
    public PlayMusic(){
        threadPlay = new Thread(this);
    }
    public void run() {
        clip.play();
    }
    public void playMusic(){
        threadPlay = new Thread(this);
        try{
            threadPlay.start();
        }
        catch(Exception exp) {}
    }
    public void setClipFile(String name){
        musicName = name;
        /*  if(musicName == null)
              musicName = "image/mine.wav";*/
        File file=new File(musicName);  //创建file对象
        try { URI uri=file.toURI();     //获取URI对象
            URL url=uri.toURL();      //获取URL对象
            clip=Applet.newAudioClip(url);
        }
        catch(Exception ee){}
    }
}
