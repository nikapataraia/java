package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JLabel labelOther,labelOur;
    JButton button;
    JTextField textField;
    JPanel panel, textPanel;

    private boolean readyToGetText;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(600,600));
        panel = new JPanel();
        panel.setBackground(Color.lightGray);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.setPreferredSize(new Dimension(270,50));

        button = new JButton("Send");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));

        panel.add(textField);
        panel.add(button);

        textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        textPanel.setPreferredSize(new Dimension(600,300));
        textPanel.setBackground(Color.darkGray);

        labelOther = new JLabel();
        labelOther.setBackground(Color.lightGray);
        labelOther.setText("Other");
        labelOther.setHorizontalAlignment(JLabel.CENTER);
        labelOther.setVerticalAlignment(JLabel.CENTER);
        labelOther.setPreferredSize(new Dimension(250,250));
        labelOther.setOpaque(true);

        labelOur = new JLabel();
        labelOur.setBackground(Color.lightGray);
        labelOur.setText("Our");
        labelOur.setHorizontalAlignment(JLabel.CENTER);
        labelOur.setVerticalAlignment(JLabel.CENTER);

        labelOur.setPreferredSize(new Dimension(250,250));
        labelOur.setOpaque(true);


        textPanel.add(labelOther);
        textPanel.add(labelOur);



        this.add(textPanel,BorderLayout.NORTH);
        this.add(panel,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            readyToGetText = true;
            System.out.println("Pressed");
            System.out.println(readyToGetText);
        }
    }

    public synchronized boolean isReadyToGetText(){
        return readyToGetText;
    }

    public synchronized String getText(){
        readyToGetText = false;
        String ret = textField.getText();
        textField.setText("");
        return ret;
    }



    public void setLabelOther(String inp){
        labelOther.setText(inp);
    }
    public void setLabelOur(String inp){
        labelOur.setText(inp);
    }
}
