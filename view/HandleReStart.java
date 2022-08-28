package Animal_game.view;

import Animal_game.date.ViewForAnimal;
import java.awt.event.*;
public class HandleReStart implements ActionListener {
     GamePanel panel;
     HandleReStart(GamePanel panel){
        this.panel = panel;
     } 
     public void actionPerformed(ActionEvent e){ //�������¿�ʼ
       panel.saveAnimalStep.clear();
       for(int i=0;i<panel.point.length;i++) {
           panel.point[i].setIsHaveAnimal(false);
       } 
       for(int i =0;i<panel.leftAnimal.length;i++ ){
           panel.leftAnimal[i].setAtPoint(panel.point[i]);
           int x = panel.point[i].getX();
           int y = panel.point[i].getY();
           //�ö�����ͼ����λ�úͶ������ڵ���ͬ
           ViewForAnimal animalView =panel.leftAnimal[i].getAnimalView();
           animalView.setAnimalViewLocation(x,y);
       } 
       for(int i =0;i<panel.rightAnimal.length;i++ ){
           int m = panel.animalCount/2;
           panel.rightAnimal[i].setAtPoint(panel.point[m+1+i]);
           int x = panel.point[m+1+i].getX();
           int y = panel.point[m+1+i].getY();
           //�ö�����ͼ����λ�úͶ������ڵ���ͬ
           ViewForAnimal animalView =panel.rightAnimal[i].getAnimalView();
           animalView.setAnimalViewLocation(x,y);
       }  
    
     } 
}