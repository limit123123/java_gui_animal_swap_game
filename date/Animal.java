package Animal_game.date;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

public abstract class Animal {
    String name ;
    Point [] allCanAtPoint;    //ȫ����λ��
    Point point;               //���ﵱǰ���ڵĵ�λ��
    ViewForAnimal animalView;  //����������ͼ
    public void setAtPoint(Point p) {
        if(p!=null){
           point = p;
           point.setIsHaveAnimal(true);
           point.setAtPointAnimal(this);
        } 
    }
    public Point getAtPoint() {
        return point;
    }
    public void setAllCanAtPoint(Point [] point){
        allCanAtPoint = point;
    }
    public void setAnimalView(ViewForAnimal animalView) {
        this.animalView = animalView;
        animalView.setAnimal(this);
    }
    public ViewForAnimal getAnimalView() {
         return animalView;
    }
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
    
    public abstract boolean move();
	
}