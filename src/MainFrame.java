import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{
    private Timer T1;
    private Timer T2;
    public MainFrame(){
        initComp();
    }
    private Button btn =new Button("Add !");
    private Button btn2=new Button("Start Moving!");
    private Button btn3=new Button("Sub!");
    private Button btn4=new Button("Exit!");

    private Label lab =new Label("Look me YOOOO!!");
    private int count = 0;
    private int count2 = 50;
    public void initComp() {
        this.setBounds(250, 100, 500, 500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(null);
        lab.setBounds(50,50,120,30);
        this.add(lab);
        btn.setBounds(50,150,80,30);
        this.add(btn);

        btn2.setBounds(50,300,80,30);
        this.add(btn2);

        btn3.setBounds(300,150,80,30);
        this.add(btn3);

        btn4.setBounds(300,300,80,30);
        this.add(btn4);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                count++;
                count2++;
                MainFrame.this.setTitle(Integer.toString(count++));
                lab.setBounds(count2,50,120,30);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                count--;
                count2--;
                MainFrame.this.setTitle(Integer.toString(count--));
                lab.setBounds(count2,50,120,30);
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count2++;
                lab.setBounds(count2,50,120,30);
                T1.start();
            }
        });

        T1=new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                count2++;
                lab.setBounds(count2,50,120,30);
                if(count2>400){
                    count2=400;
                    T1.stop();
                    T2.start();
                }
            }
        });

        T2=new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                count2--;
                lab.setBounds(count2,50,120,30);
                if(count2==0){
                    T2.stop();
                    T1.restart();
                }
            }
        });
    }


}
