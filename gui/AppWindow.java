package Animal_game.gui;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Animal_game.date.Animal;
//import Animal_game.date.ShowRecordDialog;
import Animal_game.view.GamePanel;

public class AppWindow extends JFrame  implements ActionListener{
    GamePanel gamePanel;
    JMenuBar bar;
    JMenu gradeMenu,choiceImage,resultMenu,help;
    JMenuItem oneGrade,twoGrade,threeGrade,leftImage,rightImage,oneGradeResult,twoGradeResult, regular,threeGradeResult;
    Toolkit tool;
    String pic;
    File leftImageFile, rightImageFile, heroFile;
    Animal []  Animal;
    Animal []   AnimalView;
    JTextField text;
    JButton bStart,bStop,bContinue;
    Timer time;
    SimpleDateFormat m;
    File fileOneGrade,fileTwoGrade,gradeFile,fileMidGrade,fileThreeGrade;


    public AppWindow(){

        bar=new JMenuBar();
        setTitle("���ﻻλ��Ϸ");
        gradeMenu=new JMenu("ѡ�񼶱�");
        oneGrade=new JMenuItem("����");
        twoGrade=new JMenuItem("�м�");
        threeGrade=new JMenuItem("�߼�");
        choiceImage=new JMenu("����ͼ��");
        leftImage=new JMenuItem("����������ͼ��");
        rightImage=new JMenuItem("�����Ҷ�����ͼ��");
        resultMenu=new JMenu("�鿴Ӣ�۰�");
        oneGradeResult=new JMenuItem("����Ӣ�۰�");
        twoGradeResult=new JMenuItem("�м�Ӣ�۰�");
        threeGradeResult=new JMenuItem("�߼�Ӣ�۰�");
        help=new JMenu("����");
        regular=new JMenuItem("��Ϸ����");
        gradeMenu.add(oneGrade);
        gradeMenu.add(twoGrade);
        gradeMenu.add(threeGrade);
        choiceImage.add(leftImage);
        choiceImage.add( rightImage);
        resultMenu.add(oneGradeResult);
        resultMenu.add(twoGradeResult);
        resultMenu.add(threeGradeResult);
        help.add(regular);
        bar.add(gradeMenu);
        bar.add(choiceImage);
        bar.add(resultMenu);
        bar.add(help);
        setJMenuBar(bar);
        oneGrade.addActionListener(this);
        twoGrade.addActionListener(this);
        threeGrade.addActionListener(this);
        leftImage.addActionListener(this);
        rightImage.addActionListener(this);
        oneGradeResult.addActionListener(this);
        twoGradeResult.addActionListener(this);
        threeGradeResult.addActionListener(this);
        regular.addActionListener(this);

        gamePanel = new GamePanel();
        gamePanel.setAnimalCount(6);
        gamePanel.setLeftAnimalImage("image/cat.jpg");
        gamePanel.setRightAnimalImage("image/dog.jpg");
        add(gamePanel,BorderLayout.CENTER);
        gamePanel.setBackground(Color.pink);
        JPanel northP = new JPanel();
        northP.add(gamePanel.buttonReStart);
        northP.add(gamePanel.buttonRedo);
        add(northP,BorderLayout.NORTH);
        setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);

        time=new Timer(1000,this);//WindowTime��������ʱ���ļ�����
        m=new SimpleDateFormat("hh:mm:ss");
        text=new JTextField(10);
        bStart=new JButton("��ʼ��ʱ");
        bStop=new JButton("��ͣ��ʱ");
        bContinue=new JButton("������ʱ");
        bStart.addActionListener(this);
        bStop.addActionListener(this);
        bContinue.addActionListener(this);
        northP.add(bStart);
        northP.add(bStop);
        northP.add(bContinue);
        northP.add(text);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Component container = null;
        if(e.getSource()==oneGrade){
            System.out.println("����");
            gamePanel.setAnimalCount(6);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==twoGrade){
            System.out.println("�м�");
            gamePanel.setAnimalCount(8);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==threeGrade){
            System.out.println("�߼�");
            gamePanel.setAnimalCount(10);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==leftImage){
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            JFileChooser chooser=new JFileChooser();//JFileChooser����ļ�����
            chooser.setFileFilter(filter);
            int state=chooser.showOpenDialog(null);
            File file=chooser.getSelectedFile();
            //JFileChooser.APPROVE_OPTION���ѡ�е��ļ�����
            if(file!=null&&state==JFileChooser.APPROVE_OPTION){
                try{
                    pic=file.getCanonicalPath();
                    gamePanel.setLeftAnimalImage(pic);
                }

                catch(Exception exp){}
            }

        }
        else if(e.getSource()== rightImage){
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            JFileChooser chooser=new JFileChooser();
            chooser.setFileFilter(filter);
            int state=chooser.showOpenDialog(null);
            File file=chooser.getSelectedFile();
            if(file!=null&&state==JFileChooser.APPROVE_OPTION){
                try{
                    pic=file.getCanonicalPath();
                    gamePanel.setRightAnimalImage(pic);
                }
                catch(Exception exp){}
            }
        }
        else if(e.getSource()==time) {
            Date date=new Date();
            text.setText("ʱ�䣺"+m.format(date));
        }
        else if(e.getSource()==bStart)
            time.start();
        else if(e.getSource()==bStop)
            time.stop();
        else if(e.getSource()==bContinue)
            time.restart();
        else if(e.getSource()==oneGradeResult){

            String msg = "���ﻻλ��ϷV1.0\n�˹��ܻ���Ŭ�������С���\n���λ������ĵȴ�Ŷ��\n����λ��ɲ��㣬����б�Ǹ";
            String title = "���ﻻλ��Ϸ";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }

        else if(e.getSource()==twoGradeResult){
            String msg = "���ﻻλ��ϷV1.0\n�˹��ܻ���Ŭ�������С���\n���λ������ĵȴ�Ŷ��\n����λ��ɲ��㣬����б�Ǹ";
            String title = "���ﻻλ��Ϸ";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource()==threeGradeResult){
            String msg = "���ﻻλ��ϷV1.0\n�˹��ܻ���Ŭ�������С���\n���λ������ĵȴ�Ŷ��\n����λ��ɲ��㣬����б�Ǹ";
            String title = "���ﻻλ��Ϸ";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);

        }
        else if(e.getSource()==regular){
            String msg = "(1)��Ϸ����"+
                    "\n�����Ϊ��ͬ�ļ������Ҹ��ж���м�û�ж�������Ҷ��ｻ��������굥��һ�����"
                    + "\n����ö���ǰ��û�ж���ö������Ծ���ÿ�λ�ϡ�����ö���ǰ���ж������λ�ϵ�ʯ"
                    + "\nͷû�ж���ö����Խ���Լ�ǰ��Ķ���Ծ����λ�ϣ���������ʱ���ö��ﲻ����Ծ����˫"
                    +"\n������ȫ��������ɣ�����Ϸʤ����"
                    +"\n(2)�ȼ�˵����"
                    +"\n�ȼ���Ϊ�������ֱ��ǳ�����6��������м���8��������߼���10������������ͬ�ĵ�"
                    +"\n����ʾ����ͬ�����Ķ��"
                    +"\n(3)����ͼ��˵����"
                    +"\n���Ը�����߶���ͼ����ұ߶���ͼ�񡣸�������һ�߶������ͼ�񣬻ᵯ��һ���Ի��򣬿�"
                    +"\n�ڶԻ�����ѡ���Լ���Ҫ������ͼƬ��·����������ͼƬ�ĺ�׺��������.JPG����"
                    +"\n(4)��ʱ˵����"
                    +"\n�п�ʼ��ʱ����ͣ��ʱ��������ʱ������ť����ʼ��ʱ���ڷ�������ʾϵͳʱ�䣬��ͣ��ʱ��"
                    +"\nֹͣ����ʱ�䣬������ʱ���ʱ��ԭ���Ļ����ϼ�������ʱ�䡣"
                    +"\n(5)��������˵����"
                    +"\n�ڵ�������ƶ��������̵�������������ϵͳĬ�ϵģ������Զ����ڡ�";
            String title = "���ﻻλ��Ϸ";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }



    public static void main(String args[] ){
        AppWindow win = new AppWindow();
    }
}
