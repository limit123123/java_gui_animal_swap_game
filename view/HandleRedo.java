package Animal_game.view;

import Animal_game.date.Point;
import Animal_game.date.Animal;
import Animal_game.date.ViewForAnimal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class HandleRedo implements ActionListener {
     GamePanel panel;
     HandleRedo(GamePanel panel){
        this.panel = panel;
     } 
     public void actionPerformed(ActionEvent e){ //撤销移动动物的操作
           if(panel.saveAnimalStep.empty())
               return;
           Point pEnd = panel.saveAnimalStep.pop();
           Point pStart = panel.saveAnimalStep.pop();
           Animal animal = pEnd.getAtPointAnimal(); 
           pEnd.setIsHaveAnimal(false);
           pEnd.setAtPointAnimal(null);
           animal.setAtPoint(pStart);
           ViewForAnimal animalView =animal.getAnimalView();
           int x = pStart.getX();
           int y = pStart.getY();
           animalView.setAnimalViewLocation(x,y);//让动物视图所在位置和动物所在点相同
    } 
}

