package Animal_game.test;

import Animal_game.date.*;
public class AppTest {
   public static void main(String [] args) {
       Point [] point = new Point[7];
       for(int i=0;i<point.length;i++) {
           point[i] = new Point();
           point[i].setX(i);
           point[i].setY(10);
       } 
       Animal [] left = new Animal[3];
       Animal [] right = new Animal[3];
       for(int i =0;i<left.length;i++ ){
          left[i] = new LeftAnimal();
          left[i].setName("è"+i);
          left[i].setAtPoint(point[i]);
          left[i].setAllCanAtPoint(point);
       } 
       for(int i =0;i<right.length;i++ ){
          right[i] = new RightAnimal();
          right[i].setName("��"+i);
          right[i].setAtPoint(point[4+i]);
          right[i].setAllCanAtPoint(point);
       } 
       input(point);
       if(right[0].move())
         input(point);
       if(left[2].move())
         input(point);
       if(left[1].move())
         input(point);
       if(right[0].move())
         input(point);
       if(right[1].move())
         input(point); 
       if(right[2].move())
         input(point); 
       if(left[2].move())
         input(point);
       if(left[1].move())
         input(point);
       if(left[0].move())
         input(point);
       if(right[0].move())
         input(point); 
       if(right[1].move())
         input(point);
       if(right[2].move())
         input(point); 
       if(left[1].move())
         input(point);
       if(left[0].move())
         input(point); 
       if(right[2].move())
         input(point);  
    }
    static void input(Point [] point){
       for(int i=0;i<point.length;i++){
          Animal animal=point[i].getAtPointAnimal();
          if(animal!=null)
             System.out.print(animal.getName());
          else
            System.out.print("   ");  
       } 
       System.out.println();
    }
}