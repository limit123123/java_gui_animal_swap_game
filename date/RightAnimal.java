package Animal_game.date;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;

public class RightAnimal extends Animal{
	boolean isLeft;
	   File leftImage, rightImage;
	   Toolkit tool;
	   public boolean move(){
	      int k = -1;
	      boolean successMove = false;
	      Point p = getAtPoint();
	      for(int i=0;i<allCanAtPoint.length;i++){
	         if(allCanAtPoint[i].equals(p)){
	            k = i;
	            break;
	         }
	      } 
	      if(k==0){  //�Ѿ���������ĵ�λ��
	          return false;
	      }
	      if(allCanAtPoint[k-1].isHaveAnimal()==false) {//ǰ��λ����û�ж���
	         this.setAtPoint(allCanAtPoint[k-1]);//���ﵽ��allCanAtPoint[k-1]��
	         successMove = true;
	         p.setAtPointAnimal(null);           //p������Ϊ�޶���
	         return successMove ;
	      }
	      if((k-1)==0){   //ǰ��λ�������Ѿ������յ�Ķ���
	          return false;
	      }  
	      if(allCanAtPoint[k-2].isHaveAnimal()==false) {//ǰ����λ��û�ж���
	         this.setAtPoint(allCanAtPoint[k-2]); //���ﵽ��allCanAtPoint[k-2]��
	         successMove = true;
	         p.setAtPointAnimal(null);           //p������Ϊ�޶���
	         return successMove ;
	      }
	      return successMove ;  
	   }
}