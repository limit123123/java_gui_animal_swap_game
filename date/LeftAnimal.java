package Animal_game.date;

public class LeftAnimal extends Animal{
	   public boolean move(){
	      int k = -1;
	      boolean successMove = false;
	      Point p = getAtPoint();
	      for(int i=0;i<allCanAtPoint.length;i++){
	         if(allCanAtPoint[i].equals(p)){ 
	            k = i; //�ҵ����ﵱǰ������λ��:allCanAtPoint[k]
	            break;
	         }
	      } 
	      if(k==allCanAtPoint.length-1){//�Ѿ���������ĵ�λ��
	          return false;
	      }
	      if(allCanAtPoint[k+1].isHaveAnimal()==false) { //ǰ��λ����û�ж���
	         this.setAtPoint(allCanAtPoint[k+1]);
	         successMove = true;
	         p.setAtPointAnimal(null);
	         return successMove ;
	      }
	      if((k+1)==allCanAtPoint.length-1){ //ǰ��λ�������Ѿ������յ�Ķ���
	          return false;
	      }
	      if(allCanAtPoint[k+2].isHaveAnimal()==false) {//ǰ����λ��û�ж���
	         this.setAtPoint(allCanAtPoint[k+2]);
	         successMove = true;
	         p.setAtPointAnimal(null);
	         return successMove ;
	      }
	      return successMove ;  
	   }

	   
}
