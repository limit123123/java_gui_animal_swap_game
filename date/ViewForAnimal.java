package Animal_game.date;



import javax.swing.JPanel;
public abstract class ViewForAnimal extends JPanel {
    public abstract void setAnimal(Animal animal);
    public abstract void setImage(String pic);
    public abstract Animal getAnimal();
    public abstract void setAnimalViewLocation(int x,int y);
    public abstract void setAnimalViewSize(int w,int h);
	
}