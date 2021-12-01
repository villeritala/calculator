
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] fuctionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, eqButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("SansSerif", Font.BOLD, 20);
	
	double  num1=0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		
		//frame settings 
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		//text field settings
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50); // x, y, width, height
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(Color.WHITE);
		
		//buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		//functions for buttons
		fuctionButtons[0] = addButton;
		fuctionButtons[1] = subButton;
		fuctionButtons[2] = mulButton;
		fuctionButtons[3] = divButton;
		fuctionButtons[4] = decButton;
		fuctionButtons[5] = eqButton;
		fuctionButtons[6] = delButton;
		fuctionButtons[7] = clrButton;
		fuctionButtons[8] = negButton;
		
		//actions for function buttons
		for(int i = 0; i < 9; i++) {
			fuctionButtons[i].addActionListener(this);
			fuctionButtons[i].setFont(myFont);
			fuctionButtons[i].setFocusable(false);
		}
		
		//actions for number buttons
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		
		negButton.setBounds(50, 430, 100, 50);;
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 1, 1));
		
		//all buttons on panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqButton);
		panel.add(divButton);
		
		//frame 
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	//main 
	public static void main(String[] args) {
		
		//creating calculator object
		Calculator calculator = new Calculator();
	}
	
	//all functionalities
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == eqButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			textfield.setText(textfield.getText().concat("-"));
		}
	}

}
