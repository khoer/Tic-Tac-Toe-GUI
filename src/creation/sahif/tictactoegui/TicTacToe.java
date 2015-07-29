package creation.sahif.tictactoegui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 *This program create tic-tac-toe
 *tic-tac-toe can be played with 2 player
 *Create unbeatable AI for tic-tac-toe
 *AI playing second turn
 *@author Khoerudin
 */

public class TicTacToe extends JFrame{
    private int countMove = 0;
    private JRadioButton choice1, choice2;
    private ButtonGroup choiceGroup;
    private int theChoice = 1;
    private ResetButton resetButton = new ResetButton();
    private String button1Desc, button2Desc,
        button3Desc, button4Desc, button5Desc, button6Desc,
        button7Desc, button8Desc, button9Desc;
    private MainButton button1 = new MainButton();
    private MainButton button2 = new MainButton();
    private MainButton button3 = new MainButton();
    private MainButton button4 = new MainButton();
    private MainButton button5 = new MainButton();
    private MainButton button6 = new MainButton();
    private MainButton button7 = new MainButton();
    private MainButton button8 = new MainButton();
    private MainButton button9 = new MainButton();
    private ImageIcon markIcon;
    private String mark;
    private JLabel navigateText;
    private Font fontPlay, fontDone;
    
    //constructor
    public TicTacToe(){
        super("tic-tac-toe");
        JPanel all = new JPanel(new BorderLayout());
        JPanel main = new JPanel(new GridLayout(3,3));
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        
        //make choice 1 player as default
        choice1 = new JRadioButton("1P", true);
        top.add(choice1);
        choice2 = new JRadioButton("2P", false);
        top.add(choice2);
        
        //grouping radio button
        choiceGroup = new ButtonGroup();
        choiceGroup.add(choice1);
        choiceGroup.add(choice2);
        
        //create handler for choice radio button
        ChoiceRBHandler choiceHandler = new ChoiceRBHandler();
        choice1.addItemListener(choiceHandler);
        choice2.addItemListener(choiceHandler);
        
        //reset handler for reset button
        ResetButtonHandler resetHandler = new ResetButtonHandler();
        resetButton.addActionListener(resetHandler);
        top.add(resetButton);
        
        //create handler for main button
        MainButtonHandler mainHandler = new MainButtonHandler();
       
        button1.addActionListener(mainHandler); main.add(button1);
        button2.addActionListener(mainHandler); main.add(button2);
        button3.addActionListener(mainHandler); main.add(button3);
        button4.addActionListener(mainHandler); main.add(button4);
        button5.addActionListener(mainHandler); main.add(button5);
        button6.addActionListener(mainHandler); main.add(button6);
        button7.addActionListener(mainHandler); main.add(button7);
        button8.addActionListener(mainHandler); main.add(button8);
        button9.addActionListener(mainHandler); main.add(button9);
        
        //create initial and add navigate text
        fontPlay = new Font("Serif", Font.PLAIN, 20);
        fontDone = new Font("Serif", Font.BOLD, 20);
        navigateText = new JLabel("   YOU VS AI   ");
        navigateText.setFont(fontPlay);
        bottom.add(navigateText);
        
        all.add(top, BorderLayout.NORTH);
        all.add(main, BorderLayout.CENTER);
        all.add(bottom, BorderLayout.SOUTH);
        getContentPane().add(all);
        pack();
    }
    
    private void reset(){
        button1Desc = null; button2Desc = null; button3Desc = null;
        button4Desc = null; button5Desc = null; button6Desc = null;
        button7Desc = null; button8Desc = null; button9Desc = null;
        button1.setIcon(null); button2.setIcon(null);
        button3.setIcon(null); button4.setIcon(null);
        button5.setIcon(null); button6.setIcon(null);
        button7.setIcon(null); button8.setIcon(null);
        button9.setIcon(null); countMove = 0;
    }
    
    private class ResetButtonHandler extends JButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			reset();
            navigateText.setFont(fontPlay);
            if(theChoice == 1){
                navigateText.setText("   YOU VS AI   ");
            }else{
                navigateText.setText("   X Turn   ");
            }
		}    	
    }
    
    private class ChoiceRBHandler extends JButton implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            reset();
            navigateText.setFont(fontPlay);
            if(e.getSource() == choice1){
                theChoice = 1;
                navigateText.setText("   YOU VS AI   ");
            }else{
                theChoice = 2;
                navigateText.setText("   X Turn   ");
            }
        }
    }
    
    //class for handle clicked main button
    private class MainButtonHandler extends JButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //initial for icon and mark
            if(countMove%2 == 0){
                mark = "X";
                markIcon = new ImageIcon(this.getClass().getResource("x.png"));
            }else{
                mark = "O";
                markIcon = new ImageIcon(this.getClass().getResource("o.png"));
            }
            //handle for move(set mark and icon for player's move)
            if(isLastMove()){//check if ai already win
            //check if button already fill
            }else if(((e.getSource() == button1) && (button1Desc != null)) ||
                ((e.getSource() == button2) && (button2Desc != null)) ||
                ((e.getSource() == button3) && (button3Desc != null)) ||
                ((e.getSource() == button4) && (button4Desc != null)) ||
                ((e.getSource() == button5) && (button5Desc != null)) ||
                ((e.getSource() == button6) && (button6Desc != null)) ||
                ((e.getSource() == button7) && (button7Desc != null)) ||
                ((e.getSource() == button8) && (button8Desc != null)) ||
                ((e.getSource() == button9) && (button9Desc != null))){
                
            }else{//make move
                if(e.getSource() == button1){
                    button1Desc = mark; button1.setIcon(markIcon);             
                }else if(e.getSource() == button2){
                    button2Desc = mark; button2.setIcon(markIcon);
                }else if(e.getSource() == button3){
                    button3Desc = mark; button3.setIcon(markIcon);
                }else if(e.getSource() == button4){
                    button4Desc = mark; button4.setIcon(markIcon);
                }else if(e.getSource() == button5){
                    button5Desc = mark; button5.setIcon(markIcon);
                }else if(e.getSource() == button6){
                    button6Desc = mark; button6.setIcon(markIcon);
                }else if(e.getSource() == button7){
                    button7Desc = mark; button7.setIcon(markIcon);
                }else if(e.getSource() == button8){
                    button8Desc = mark; button8.setIcon(markIcon);
                }else if(e.getSource() == button9){
                    button9Desc = mark; button9.setIcon(markIcon);
                }
                countMove += 1;
                //set navigate text
                if(theChoice == 1){
                    if(isLastMove()){//check if player already win
                        navigateText.setText("   You Win!!!   ");
                        navigateText.setFont(fontDone);
                    }else if(countMove == 9){
                        navigateText.setText("   Draw!!!   ");
                        navigateText.setFont(fontDone);
                    }else{
                        //make ai move
                        AI aiMove = new AI();
                        aiMove.move();
                        if(isLastMove()){//check ai win
                            navigateText.setText("   You Lose!!!   ");
                            navigateText.setFont(fontDone);
                        }
                    }
                }else{
                    if(countMove%2 == 0){
                        if(isLastMove()){
                            navigateText.setText("   O Win!!!   ");
                            navigateText.setFont(fontDone);
                        }else{
                            navigateText.setText("   X Turn   ");
                        }
                    }else{
                        if(isLastMove()){
                            navigateText.setText("   X Win!!!   ");
                            navigateText.setFont(fontDone);
                        }else if(countMove == 9){
                            navigateText.setText("   Draw!!!   ");
                            navigateText.setFont(fontDone);
                        }else{
                            navigateText.setText("   O Turn   ");
                        }
                    }
                }
            }
        }
    }
    
    //check if already have a winner
    private boolean isLastMove(){
        if(button1Desc == button2Desc &&
            button1Desc == button3Desc && button1Desc != null){
            return true;    
        }else if(button4Desc == button5Desc &&
            button4Desc == button6Desc && button4Desc != null){
            return true;    
        }else if(button7Desc == button8Desc &&
            button7Desc == button9Desc && button7Desc != null){
            return true;    
        }else if(button1Desc == button4Desc &&
            button1Desc == button7Desc && button1Desc != null){
            return true;    
        }else if(button2Desc == button5Desc &&
            button2Desc == button8Desc && button2Desc != null){
            return true;    
        }else if(button3Desc == button6Desc &&
            button3Desc == button9Desc && button3Desc != null){
            return true;    
        }else if(button1Desc == button5Desc &&
            button1Desc == button9Desc && button1Desc != null){
            return true;    
        }else if(button3Desc == button5Desc &&
            button3Desc == button7Desc && button3Desc != null){
            return true;  
        }        
        return false;
    }
    
    //class for AI move
    private class AI extends JButton{
        public AI(){
            mark = "O";
            markIcon = new ImageIcon(this.getClass().getResource("o.png"));
        }
        
        public void move(){
            //for first move try get middle or corner
            if((button5Desc != "O") && (button1Desc != "O")){
                if(button5Desc == null){
                    button5Desc = mark; button5.setIcon(markIcon);
                }else{
                    button1Desc = mark; button1.setIcon(markIcon);
                }        
            //search move to get win
            //(player got middle, ai got corner top-left)
            }else if((button1Desc == "O") && (button2Desc == "O") &&
                (button3Desc == null)){
                button3Desc = mark; button3.setIcon(markIcon);
            }else if((button1Desc == "O") && (button3Desc == "O") &&
                (button2Desc == null)){
                button2Desc = mark; button2.setIcon(markIcon);
            }else if((button1Desc == "O") && (button4Desc == "O") &&
                (button7Desc == null)){
                button7Desc = mark; button7.setIcon(markIcon);
            }else if((button1Desc == "O") && (button7Desc == "O") &&
                (button4Desc == null)){
                button4Desc = mark; button4.setIcon(markIcon);
            }else if((button3Desc == "O") && (button6Desc == "O") &&
                (button9Desc == null)){
                button9Desc = mark; button9.setIcon(markIcon);
            }else if((button7Desc == "O") && (button8Desc == "O") &&
                (button9Desc == null)){
                button9Desc = mark; button9.setIcon(markIcon);
            }else if((button3Desc == "O") && (button9Desc == "O") &&
                (button6Desc == null)){
                button6Desc = mark; button6.setIcon(markIcon);
            //handle if player dominate middle
            }else if(button5Desc == "X"){
                //block player to win(player got middle)
                if((button2Desc == "X") && (button8Desc == null)){
                    button8Desc = mark; button8.setIcon(markIcon);
                }else if((button3Desc == "X") && (button7Desc == null)){
                    button7Desc = mark; button7.setIcon(markIcon);
                }else if((button4Desc == "X") && (button6Desc == null)){
                    button6Desc = mark; button6.setIcon(markIcon);
                }else if((button6Desc == "X") && (button4Desc == null)){
                    button4Desc = mark; button4.setIcon(markIcon);
                }else if((button7Desc == "X") && (button3Desc == null)){
                    button3Desc = mark; button3.setIcon(markIcon);
                }else if((button8Desc == "X") && (button2Desc == null)){
                    button2Desc = mark; button2.setIcon(markIcon);
                //find chance to get win
                }else if((button1Desc == "O") && (button4Desc == null) &&
                    button7Desc == null){
                    button7Desc = mark; button7.setIcon(markIcon);
                //rest move handle, try to get corner first
                }else if(button3Desc == null){
                    button3Desc = mark; button3.setIcon(markIcon);
                }else if(button2Desc == null){//try close to corner top-left
                    button2Desc = mark; button2.setIcon(markIcon);
                }else if(button4Desc == null){//try close to corner top-left
                    button4Desc = mark; button4.setIcon(markIcon);
                }
            //search move to get win(ai got middle)
            }else if((button5Desc == "O") && (button2Desc == "O") &&
                (button8Desc == null)){
                button8Desc = mark; button8.setIcon(markIcon);
            }else if((button5Desc == "O") && (button3Desc == "O") &&
                (button7Desc == null)){
                button7Desc = mark; button7.setIcon(markIcon);
            }else if((button5Desc == "O") && (button4Desc == "O") &&
                (button6Desc == null)){
                button6Desc = mark; button6.setIcon(markIcon);
            }else if((button5Desc == "O") && (button6Desc == "O") &&
                (button4Desc == null)){
                button4Desc = mark; button4.setIcon(markIcon);
            }else if((button5Desc == "O") && (button7Desc == "O") &&
                (button3Desc == null)){
                button3Desc = mark; button3.setIcon(markIcon);
            }else if((button5Desc == "O") && (button8Desc == "O") &&
                (button2Desc == null)){
                button2Desc = mark; button2.setIcon(markIcon);
            }else if((button5Desc == "O") && (button1Desc == "O") &&
                (button9Desc == null)){
                button9Desc = mark; button9.setIcon(markIcon);
            }else if((button5Desc == "O") && (button9Desc == "O") &&
                (button1Desc == null)){
                button1Desc = mark; button1.setIcon(markIcon);
            //block player to win(ai got middle)
            }else if((button2Desc == "X") && (button3Desc == "X") &&
                (button1Desc == null)){
                button1Desc = mark; button1.setIcon(markIcon);
            }else if((button1Desc == "X") && (button3Desc == "X") &&
                (button2Desc == null)){
                button2Desc = mark; button2.setIcon(markIcon);
            }else if((button1Desc == "X") && (button2Desc == "X") &&
                (button3Desc == null)){
                button3Desc = mark; button3.setIcon(markIcon);
            }else if((button4Desc == "X") && (button7Desc == "X") &&
                (button1Desc == null)){
                button1Desc = mark; button1.setIcon(markIcon);
            }else if((button1Desc == "X") && (button7Desc == "X") &&
                (button4Desc == null)){
                button4Desc = mark; button4.setIcon(markIcon);
            }else if((button1Desc == "X") && (button4Desc == "X") &&
                (button7Desc == null)){
                button7Desc = mark; button7.setIcon(markIcon);
            }else if((button6Desc == "X") && (button9Desc == "X") &&
                (button3Desc == null)){
                button3Desc = mark; button3.setIcon(markIcon);
            }else if((button3Desc == "X") && (button9Desc == "X") &&
                (button6Desc == null)){
                button6Desc = mark; button6.setIcon(markIcon);
            }else if((button3Desc == "X") && (button6Desc == "X") &&
                (button9Desc == null)){
                button9Desc = mark; button9.setIcon(markIcon);
            }else if((button8Desc == "X") && (button9Desc == "X") &&
                (button7Desc == null)){
                button7Desc = mark; button7.setIcon(markIcon);
            }else if((button7Desc == "X") && (button9Desc == "X") &&
                (button8Desc == null)){
                button8Desc = mark; button8.setIcon(markIcon);
            }else if((button7Desc == "X") && (button8Desc == "X") &&
                (button9Desc == null)){
                button9Desc = mark; button9.setIcon(markIcon);
            //other handle if ai dominate middle
            }else if((button5Desc == "O")){
                //find chance to win and try get corner
                if((button7Desc == null) && (button3Desc == null)){
                    //eliminate double chance player win
                    if(button2Desc == "X" || button6Desc == "X"){
                        button3Desc = mark; button3.setIcon(markIcon);
                    }else if(button4Desc == "X" || button8Desc == "X"){
                        button7Desc = mark; button7.setIcon(markIcon);
                    }else{
                        button2Desc = mark; button2.setIcon(markIcon);
                    }
                }else if((button1Desc == null) && (button9Desc == null)){
                    //eliminate double chance player win
                    if(button8Desc == "X" || button6Desc == "X"){
                        button9Desc = mark; button9.setIcon(markIcon);
                    }else if(button2Desc == "X" || button4Desc == "X"){
                        button1Desc = mark; button1.setIcon(markIcon);
                    }else{
                        button2Desc = mark; button2.setIcon(markIcon);
                    }
                }else if((button2Desc == null) && (button8Desc == null)){
                    button2Desc = mark;//close to corner top-left
                    button2.setIcon(markIcon);
                }else if((button4Desc == null) && (button6Desc == null)){
                    button4Desc = mark;//close to corner top-left
                    button4.setIcon(markIcon);
                //rest move handle, try close to corner top-left
                }else if(button2Desc == null){
                    button2Desc = mark; button2.setIcon(markIcon);
                }else if(button4Desc == null){
                    button4Desc = mark; button4.setIcon(markIcon);
                }else if(button7Desc == null){
                    button7Desc = mark; button7.setIcon(markIcon);
                }else if(button8Desc == null){
                    button8Desc = mark; button8.setIcon(markIcon);
                }else if(button6Desc == null){
                    button6Desc = mark; button6.setIcon(markIcon);
                }
            }
            countMove += 1;
        }
    }
}
