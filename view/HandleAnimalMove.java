
package Animal_game.view;
import java.awt.event.*;
import javax.swing.JOptionPane;
import Animal_game.date.Point;
import Animal_game.date.Animal;
import Animal_game.date.ViewForAnimal;
import Animal_game.date.LeftAnimal;
import Animal_game.date.RightAnimal;
public class HandleAnimalMove extends MouseAdapter {
    GamePanel panel;
    PlayMusic PlayMusic;
    HandleAnimalMove( GamePanel panel){
        this. panel = panel;
    }
    public void mousePressed(MouseEvent e){
        ViewForAnimal animalView = (ViewForAnimal)e.getSource();
        Animal animal = animalView.getAnimal();
        PlayMusic = new PlayMusic();
        PlayMusic. setClipFile("image/dog.wav");
        PlayMusic. playMusic();
        Point pStart = animal.getAtPoint(); //得到动物移动前所在点
        if(animal.move()) {
            Point pEnd = animal.getAtPoint();//得到动物移动后所在点
            int x = pEnd.getX();
            int y = pEnd.getY();
            animalView.setAnimalViewLocation(x,y);//让动物视图所在位置和动物所在点相同
            panel.saveAnimalStep.push(pStart);
            panel.saveAnimalStep.push(pEnd);
        }
    }
    public void mouseReleased(MouseEvent e){
        boolean success = true;
        PlayMusic = new PlayMusic();
        PlayMusic. setClipFile("image/cat.wav");
        PlayMusic. playMusic();
        int n =panel.animalCount/2;
        for(int i=0;i<n;i++){
            Animal animal=panel.point[i].getAtPointAnimal();
            success = success&&(animal instanceof RightAnimal);
            animal=panel.point[n+1+i].getAtPointAnimal();
            success = success&&(animal instanceof LeftAnimal);
            if(success == false)
                break;
        }
        if(success) {
            JOptionPane.showMessageDialog(null,"您成功了","消息框",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
