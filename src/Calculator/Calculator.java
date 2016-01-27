/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Create windows xp calculator GUI
 * @author Hung
 */
public class Calculator extends JFrame {
    //create 6 jpanel for 6 rows, one for each row
    JPanel[] rows = new JPanel[6];
    //create 23 buttons
    JButton[] buttons = new JButton[24];
    //create buttons' name
    String[] buttonName = {"MC","M+","M-","+",  "7","8","9","-",    
        "4","5","6","*", "1","2","3","/", ".","^",
        "C","√","±","1/x","=","0"};
    //set width and height dimension for buttons
    int[] width = {350,55,100,110};
    int[] height = {35,40};
    //set dimension
    Dimension displayDimension = new Dimension(width[0], height[0]);
    Dimension regularDimension = new Dimension(width[1], height[1]);
    Dimension rColumnDimension = new Dimension(width[2], height[1]);
    Dimension btnZeroDimension = new Dimension(width[3], height[1]);
    //display field
    JTextArea display = new JTextArea(1,20);
    //change font for bold effect
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    //constructor

    public Calculator() {
        super("Hung's Calculator"); //title
        setDesign();
        //set size of frame
        setSize(400, 300);
        //cant resize the frame because the layout will mess up
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //use grid layout to create 6 rows 5 components
        GridLayout grid = new GridLayout(6, 5);
        setLayout(grid);
        //initialize row
        for (int i = 0; i < 6; i++) {//6 rows
            rows[i] = new JPanel();
        }
        //set UI for buttons
        for (int i = 0; i < 24; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonName[i]);
            buttons[i].setFont(font);
        }
        //set display UI
        display.setFont(font); display.setText("0");
        display.setEditable(false);
        display.setPreferredSize(displayDimension);
        //set buttons UI
        for(int i = 0; i < 18; i++)
            buttons[i].setPreferredSize(regularDimension);
        for(int i = 18; i < 23; i++)
            buttons[i].setPreferredSize(rColumnDimension);
        buttons[23].setPreferredSize(btnZeroDimension);
        //set rows UI
        //row[0] : display
        rows[0].add(display);
        //add panel
        add(rows[0]);
        //row[1]
        for (int i = 0; i < 4; i++) {
            rows[1].add(buttons[i]);
        }
        rows[1].add(buttons[18]);
        add(rows[1]);
        //row[2]
        for (int i = 4; i < 8; i++) {
            rows[2].add(buttons[i]);
        }
        rows[2].add(buttons[19]);
        add(rows[2]);
        //row[3]
        for (int i = 8; i < 12; i++) {
            rows[3].add(buttons[i]);
        }
        rows[3].add(buttons[20]);
        add(rows[3]);
        //row[4]
        for (int i = 12; i < 16; i++) {
            rows[4].add(buttons[i]);
        }
        rows[4].add(buttons[21]);
        add(rows[4]);
        //row[5]
        rows[5].add(buttons[23]);
        for (int i = 16; i < 18; i++) {
            rows[5].add(buttons[i]);
        }
        rows[5].add(buttons[22]);
        add(rows[5]);
        //run program   
        setVisible(true);

    }
    
    public final void setDesign()
    {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
    }
    public static void main(String[] args)
    {
        
        Calculator c = new Calculator();
    }
   
}
