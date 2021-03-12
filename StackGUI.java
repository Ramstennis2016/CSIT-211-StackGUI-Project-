//
//Muhammad Ayaan Shaikh
//
//IDE: Eclipse
//
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StackGUI extends JFrame implements ActionListener {
	
	//declaring Stack 
	
	private JTextField input;
	
	private JButton push, pop, peek;
	
	private JTextArea result;
	
	private Stack <String> stk;
	
	public StackGUI() {
		
		//Initializing the stack 
		
		stk = new Stack<String>();
		
		//grid layout as 1 in the main layout 
		
		setLayout(new GridLayout(0,1));
		
		//Initialization of the GUI 
		
		//Creating a panel for input label 
		
		JPanel inpPanel = new JPanel();
		
		inpPanel.add(new JLabel("Input: "));
		
		input = new JTextField(10);
		
		inpPanel.add(input);
		
		//creating the panels needed for the buttons 
		
		JPanel buttonsPanel = new JPanel();
		
		push = new JButton("PUSH");
		
		pop = new JButton("POP");
		
		peek = new JButton("PEEK");
		
		buttonsPanel.add(push);
		
		buttonsPanel.add(pop);
		
		buttonsPanel.add(peek);
		
		//adding the ActionListener methods to the buttons
		
		push.addActionListener(this);
		
		pop.addActionListener(this);
		
		peek.addActionListener(this);
		
		//Initialization of the text area 
		
		//Stack as a text 
		
		result = new JTextArea();
		
		result.setEditable(false);
		
		result.setText("Stack: " +stk);
		
		//adding to the main frame 
		
		add(inpPanel);
		
		add(buttonsPanel);
		
		add(result);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(400, 200);
		
		setVisible(true);
	
	}
	
	public static void main(String [] args) {
		
		new StackGUI();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//resetting the text area 
		
		result.setText("");
		
		//finding the source of the action 
		
		if (e.getSource().equals(push)) {
			
			//getting text from input and pushing to the stack 
			
			String value = input.getText();
			
			if (value.length() > 0) {
				
				stk.push(value);
				
				result.setText("PushedValue: " + value);
				
				//resetting the input 
				
				input.setText("");
			}
			
		} else if(e.getSource().equals(pop)) {
			
			//popping value from stack and displaying if not empty 
			
			if(stk.isEmpty()) {
				
				result.setText("Stack is Empty! Try Again! ");
				
			}else {
				
				result.setText("Popped value" +stk.pop());
				
			}
			
		}else {
			
			//peeking a value from the stack and shows only if it is not empty 
			
			if (stk.isEmpty()) {
				
				result.setText("Error! Stack is empty");
				
			}else {
				
				result.setText("Value on top: "+stk.peek());
			}
		}
		
		//appending the contents of stack to result text area 
		
		result.append("\nStack: " + stk);
	}
	
}
