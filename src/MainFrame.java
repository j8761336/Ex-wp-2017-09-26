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
    private Button btn =new Button("Add Title!");
    private Button btn2=new Button("Start Right!");
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
        btn.setBounds(150,150,150,80);
        this.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                MainFrame.this.setTitle(Integer.toString(count++));
            }
        });

        btn2.setBounds(150,300,150,80);
        this.add(btn2);

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
