/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Harsh
 */
public class QuizTest extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1,now  = 0;
    int m[] = new int[10];
    
    
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        
        
    }
    
    void setData(){
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Q1 Which planet is known as the \"Red Planet\"?");
            radioButtons[0].setText("Mars"); 
            radioButtons[1].setText("Venus"); 
            radioButtons[2].setText("Jupiter"); 
            radioButtons[3].setText("Saturn"); 
        }
        if(current==1){
            label.setText("Q2 Who painted the Mona Lisa?");
            radioButtons[0].setText("Pablo Picasso"); 
            radioButtons[1].setText("Leonardo da Vinci"); 
            radioButtons[2].setText("Vincent van Gogh"); 
            radioButtons[3].setText("Michelangelo"); 
        }
        if(current==2){
            label.setText("Q3 What is the chemical symbol for gold?");
            radioButtons[0].setText("Au"); 
            radioButtons[1].setText("Ag"); 
            radioButtons[2].setText("Fe"); 
            radioButtons[3].setText("Hg"); 
        }
        if(current==3){
            label.setText("Q4 Which of the following is a renewable source of energy?");
            radioButtons[0].setText("Coal"); 
            radioButtons[1].setText("Natural Gas"); 
            radioButtons[2].setText("Solar Power"); 
            radioButtons[3].setText("Petroleum"); 
        }
        if(current==4){
            label.setText("Q5 Which continent is home to the largest rainforest in the world?");
            radioButtons[0].setText("North America"); 
            radioButtons[1].setText("Europe"); 
            radioButtons[2].setText("Africa"); 
            radioButtons[3].setText("South America"); 
        }
        if(current==5){
            label.setText("Q6 What is the largest organ in the human body?");
            radioButtons[0].setText("Liver"); 
            radioButtons[1].setText("Heart"); 
            radioButtons[2].setText("Brain"); 
            radioButtons[3].setText("Skin"); 
        }
        if(current==6){
            label.setText("Q7 Which country is famous for the Taj Mahal?");
            radioButtons[0].setText("India"); 
            radioButtons[1].setText("China"); 
            radioButtons[2].setText("Egypt"); 
            radioButtons[3].setText("Italy"); 
        }
        if(current==7){
            label.setText("Q8 Which scientist developed the theory of relativity?");
            radioButtons[0].setText("Isaac Newton"); 
            radioButtons[1].setText("Albert Einstein"); 
            radioButtons[2].setText("Marie Curie"); 
            radioButtons[3].setText("Charles Darwin"); 
        }
        if(current==8){
            label.setText("Q9 What is the unit of measurement for electric current?");
            radioButtons[0].setText("Volts"); 
            radioButtons[1].setText("Watts"); 
            radioButtons[2].setText("Amperes"); 
            radioButtons[3].setText("Ohms"); 
        }
        if(current==9){
            label.setText("Q10 Which gas is most abundant in Earth's atmosphere?");
            radioButtons[0].setText("Nitrogen"); 
            radioButtons[1].setText("Oxygen"); 
            radioButtons[2].setText("Carbon Dioxide"); 
            radioButtons[3].setText("Hydrogen"); 
        }
        
        label.setBounds(30,40,450,20);
        for(int i=0,j=0; i<90; i+=30,j++){
         radioButtons[j].setBounds(50,80+i, 200,20);
        }
    }
    
    boolean checkAns(){
            if(current==0){
            return (radioButtons[0].isSelected());
            }
            if(current==1){
            return (radioButtons[1].isSelected());
            }
            if(current==2){
            return (radioButtons[0].isSelected());
            }
            if(current==3){
            return (radioButtons[2].isSelected());
            }
            if(current==4){
            return (radioButtons[3].isSelected());
            }
            if(current==5){
            return (radioButtons[3].isSelected());
            }
            if(current==6){
            return (radioButtons[0].isSelected());
            }
            if(current==7){
            return (radioButtons[1].isSelected());
            }
            if(current==8){
            return (radioButtons[2].isSelected());
            }
            if(current==9){
            return (radioButtons[0].isSelected());
            }
            return false;
    }
    
    
    
    
    public static void main(String[] args){
        
        new QuizTest("Simple Quiz App");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnNext){
         if(checkAns())
             count = count +1;
         current++;
         
         setData();
         if(current==9){
             btnNext.setEnabled(false);
             btnResult.setVisible(true);
             btnResult.setText("Result");
         }
        }
        
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count = count +1;
            current++;
            JOptionPane.showMessageDialog(this,"Correct Answer are "+count);
            System.exit(0);
        }
        
    }
}
