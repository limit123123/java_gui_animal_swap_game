package Animal_game.view;

import javax.swing.*;
import java.awt.*;
import Animal_game.date.Animal;
import Animal_game.date.Point;
import Animal_game.date.ViewForAnimal;
import Animal_game.date.LeftAnimal;
import Animal_game.date.RightAnimal;
import java.util.*;
import java.awt.geom.*;
import java.io.File; 
public class GamePanel extends JPanel {
    public int animalCount = -1;
    public Point [] point ;
    Animal []  leftAnimal,rightAnimal; 
    public ViewForAnimal [] leftAnimalView,rightAnimalView;//������ͼ
    public int width =90,height=70;  //������ͼ�Ĵ�С
    public int gap = 2;              //����֮��ļ�϶           
    public JButton buttonRedo;//������ť
    public JButton buttonReStart;//���¿�ʼ��Ϸ
    public Stack<Point> saveAnimalStep; //��Ŷ����߶���λ�ã��Ա�ָ�
    HandleAnimalMove handleAnimalMove;//������MouseEvent�ļ�����
    HandleRedo handleRedo;           //����ActionEvent�ļ����� 
    HandleReStart handleReStart;    //����ActionEvent�ļ�����
    File leftImage,rightImage;
    int distance=100,grade=1,m=3,n=3;
    public GamePanel(){
       setLayout(null);
       
       buttonRedo = new JButton("����");
       buttonReStart = new JButton("���¿�ʼ");
       saveAnimalStep = new Stack<Point>();
    }
    public HandleAnimalMove getHandleAnimalMove(){

        return handleAnimalMove;

     }
   
    public void setAnimalCount(int n){
       if(n%2 != 0 ||n<=1) {
          System.out.println(n+"�ĸ���������");
          System.exit(0);
       } 
       removeAll();  //�����Ƴ�����ӵ��������е�ȫ�����
       animalCount = n;
       initPoitAndAnimal();  //��ʼ�������λ�ö���
       initLeftAnimalView(); //��ʼ����ߵĶ�����ͼ
       initRightAnimalView();
       registerListener();   //ע�������
    }
    private void initPoitAndAnimal(){//��ʼ�������λ�ö���
       point = new Point[animalCount+1];
       int posionX = width; //���λ�õ�x����
       int posionY = height;
       for(int i=0;i<point.length;i++) {
           point[i] = new Point();
           point[i].setX(posionX);
           point[i].setY(posionY);
           posionX = posionX+width+gap;
       } 
       int m = animalCount/2;
       leftAnimal = new LeftAnimal[m];
       rightAnimal = new RightAnimal[m];
       for(int i =0;i<leftAnimal.length;i++ ){
          leftAnimal[i] = new LeftAnimal();
          leftAnimal[i].setAtPoint(point[i]);
          leftAnimal[i].setAllCanAtPoint(point);
       } 
       for(int i =0;i<rightAnimal.length;i++ ){
          rightAnimal[i] = new RightAnimal();
          rightAnimal[i].setAtPoint(point[m+1+i]);
          rightAnimal[i].setAllCanAtPoint(point);
       }  
    }
    private void initLeftAnimalView(){//��ʼ����ߵĶ�����ͼ
       int m = animalCount/2;
       leftAnimalView = new ViewForAnimal[m];
       for(int i =0;i<leftAnimalView.length;i++ ){
          leftAnimalView[i] = new AnimalView();
          leftAnimal[i].setAnimalView(leftAnimalView[i]);
          Point p = leftAnimal[i].getAtPoint();
          int x = p.getX();
          int y = p.getY();
          add(leftAnimalView[i]);
          //������ͼ����λ�úͶ������ڵ���ͬ��
          leftAnimalView[i].setAnimalViewLocation(x,y);
          leftAnimalView[i].setAnimalViewSize(width,height);
       } 
    }
    private void initRightAnimalView(){//��ʼ���ұߵĶ�����ͼ
       int m = animalCount/2;
       rightAnimalView = new ViewForAnimal[m];
       for(int i =0;i<rightAnimalView.length;i++ ){
          rightAnimalView[i] = new AnimalView();
          rightAnimal[i].setAnimalView(rightAnimalView[i]);
          Point p = rightAnimal[i].getAtPoint();
          int x = p.getX();
          int y = p.getY();
          add(rightAnimalView[i]);
          rightAnimalView[i].setAnimalViewLocation(x,y);
          rightAnimalView[i].setAnimalViewSize(width,height);
       } 
    }
    private void registerListener(){
        handleAnimalMove = new HandleAnimalMove(this);
        //�����û��ڶ�����ͼ�ϴ�����MouseEvent�¼���
        for(int i =0;i<rightAnimalView.length;i++ ){
           rightAnimalView[i].addMouseListener(handleAnimalMove);
        }
        for(int i =0;i<leftAnimalView.length;i++ ){
           leftAnimalView[i].addMouseListener(handleAnimalMove);
        }
        handleRedo = new HandleRedo(this);
        handleReStart = new HandleReStart(this);
        //�����û��ڰ�ť�ϴ�����ActionEvent�¼���
        buttonRedo.addActionListener(handleRedo);
        buttonReStart.addActionListener(handleReStart);
    }
    
    
   
    
    public void setLeftAnimalImage(String pic){
      if(animalCount==-1)
           return;
       for(int i =0;i<leftAnimalView.length;i++ ){
          leftAnimalView[i].setImage(pic);
       } 
    }
    public void setRightAnimalImage(String pic){
      if(animalCount==-1)
           return;  
       for(int i =0;i<rightAnimalView.length;i++ ){
          rightAnimalView[i].setImage(pic);
       } 
    }
    public void paintComponent(Graphics g){
       int penHeight =12;  //���ʵĸ߶�
       super.paintComponent(g);
       int xStart =width+gap;
       int yStart =2*height+penHeight/2;
       int xEnd =(animalCount+2)*width+(animalCount+1)*2;
       int yEnd =2*height+penHeight/2;
       Line2D line=new Line2D.Double(xStart,yStart,xEnd,yEnd);
       Graphics2D g_2d=(Graphics2D)g;
       g_2d.setColor(Color.blue);
       BasicStroke bs=
       new BasicStroke(penHeight,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
       g_2d.setStroke(bs);
       g_2d.draw(line);
   }
}