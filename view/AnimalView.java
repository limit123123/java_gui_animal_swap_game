package Animal_game.view;
import java.awt.*;
import java.io.File;

import Animal_game.date.Animal;
import Animal_game.date.ViewForAnimal;

public class AnimalView extends ViewForAnimal{
   Animal animal;
   Image image;
   Image image2;
   Image image3;
   Toolkit tool;
   boolean isLeft;
   File leftImage, rightImage;
   public AnimalView() {
      tool = getToolkit();
   }
   	
		
   public void setAnimal(Animal animal){
      this.animal = animal;
   }
   public void setImage(String name){
      image = tool.getImage(name);
      repaint();  //  repaint()方法对界面重绘。 
   }
 
   public Animal getAnimal() {
      return animal;
   }
   public void setAnimalViewLocation(int x,int y){
      setLocation(x,y);
   }
   public void setAnimalViewSize(int w,int h){
      setSize(w,h);
   }
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int w=getBounds().width;
      int h=getBounds().height;
      g.drawImage(image,0,0,w,h,this);
  
  			}
      
     
   }
