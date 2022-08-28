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
        setTitle("动物换位游戏");
        gradeMenu=new JMenu("选择级别");
        oneGrade=new JMenuItem("初级");
        twoGrade=new JMenuItem("中级");
        threeGrade=new JMenuItem("高级");
        choiceImage=new JMenu("更改图像");
        leftImage=new JMenuItem("更改左动物新图像");
        rightImage=new JMenuItem("更改右动物新图像");
        resultMenu=new JMenu("查看英雄榜");
        oneGradeResult=new JMenuItem("初级英雄榜");
        twoGradeResult=new JMenuItem("中级英雄榜");
        threeGradeResult=new JMenuItem("高级英雄榜");
        help=new JMenu("帮助");
        regular=new JMenuItem("游戏规则");
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

        time=new Timer(1000,this);//WindowTime对象做计时器的监视器
        m=new SimpleDateFormat("hh:mm:ss");
        text=new JTextField(10);
        bStart=new JButton("开始计时");
        bStop=new JButton("暂停计时");
        bContinue=new JButton("继续计时");
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
            System.out.println("初级");
            gamePanel.setAnimalCount(6);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==twoGrade){
            System.out.println("中级");
            gamePanel.setAnimalCount(8);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==threeGrade){
            System.out.println("高级");
            gamePanel.setAnimalCount(10);
            gamePanel.setLeftAnimalImage("image/cat.jpg");
            gamePanel.setRightAnimalImage("image/dog.jpg");
            setBounds(60,60,9*gamePanel.width+9*gamePanel.gap,300);
            setLocationRelativeTo(null);
        }
        else if(e.getSource()==leftImage){
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", "jpg", "gif");
            JFileChooser chooser=new JFileChooser();//JFileChooser添加文件过滤
            chooser.setFileFilter(filter);
            int state=chooser.showOpenDialog(null);
            File file=chooser.getSelectedFile();
            //JFileChooser.APPROVE_OPTION获得选中的文件对象
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
            text.setText("时间："+m.format(date));
        }
        else if(e.getSource()==bStart)
            time.start();
        else if(e.getSource()==bStop)
            time.stop();
        else if(e.getSource()==bContinue)
            time.restart();
        else if(e.getSource()==oneGradeResult){

            String msg = "动物换位游戏V1.0\n此功能还在努力开发中……\n请各位玩家耐心等待哦！\n给各位造成不便，我深感抱歉";
            String title = "动物换位游戏";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }

        else if(e.getSource()==twoGradeResult){
            String msg = "动物换位游戏V1.0\n此功能还在努力开发中……\n请各位玩家耐心等待哦！\n给各位造成不便，我深感抱歉";
            String title = "动物换位游戏";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource()==threeGradeResult){
            String msg = "动物换位游戏V1.0\n此功能还在努力开发中……\n请各位玩家耐心等待哦！\n给各位造成不便，我深感抱歉";
            String title = "动物换位游戏";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);

        }
        else if(e.getSource()==regular){
            String msg = "(1)游戏规则："+
                    "\n程序分为不同的级别，左右各有动物，中间没有动物，将左右动物交换。用鼠标单击一个动物，"
                    + "\n如果该动物前方没有动物，该动物就跳跃到该空位上。如果该动物前方有动物，但隔位上的石"
                    + "\n头没有动物，该动物就越过自己前面的动物跃到空位上，其他情形时，该动物不能跳跃。若双"
                    +"\n方动物全部交换完成，则游戏胜利。"
                    +"\n(2)等级说明："
                    +"\n等级分为三级，分别是初级（6个动物）、中级（8个动物）、高级（10个动物）。点击不同的等"
                    +"\n级显示出不同数量的动物。"
                    +"\n(3)更换图像说明："
                    +"\n可以更换左边动物图像和右边动物图像。更换任意一边动物更换图像，会弹出一个对话框，可"
                    +"\n在对话框内选择自己想要更换的图片的路径（所更换图片的后缀名必须是.JPG）。"
                    +"\n(4)计时说明："
                    +"\n有开始计时、暂停计时、继续计时三个按钮。开始计时则在方框内显示系统时间，暂停计时则"
                    +"\n停止计算时间，继续计时则计时在原来的基础上继续增加时间。"
                    +"\n(5)其他功能说明："
                    +"\n在点击动物移动会产生简短的声音，声音是系统默认的，不可自动调节。";
            String title = "动物换位游戏";
            JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }



    public static void main(String args[] ){
        AppWindow win = new AppWindow();
    }
}
