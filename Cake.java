// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cake.java

package cake;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.*;
import javax.swing.*;

public class Cake extends JFrame
{

    public Cake()
    {
        title = new JLabel("Get sum cake.");
        setResizable(false);
        setTitle("Cake!");
        setSize(250, 100);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(title);
        cp.add(amount);
        amount.setEditable(false);
        amount.setText((new StringBuilder()).append("Cake collected so far: ").append(count).append("                 ").toString());
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new Cake();
        do
            bakeCake();
        while(true);
    }

    public static void bakeCake()
    {
        count++;
        String cakeText[] = {
            (new StringBuilder()).append("Congratulations! You have collected ").append(count).append(" cake so far!").toString()
        };
        writeFile(cakeText);
        amount.setText((new StringBuilder()).append("Cake collected so far: ").append(count).toString());
    }

    private static void writeFile(String i[])
    {
        File file = new File((new StringBuilder()).append("Cake ").append(count).append(".txt").toString());
        try
        {
            FileWriter filewriter = new FileWriter(file, true);
            BufferedWriter buffwriter = new BufferedWriter(filewriter);
            String arr$[] = i;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                String s = arr$[i$];
                buffwriter.write(s);
                buffwriter.newLine();
            }

            buffwriter.flush();
        }
        catch(IOException e) { }
    }

    private JLabel title;
    private static JTextField amount = new JTextField();
    static int count = 0;

}
