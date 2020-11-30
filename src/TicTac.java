import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTac implements ActionListener {
   Random random = new Random();
   JFrame frame = new JFrame();
   Panel title_panel = new Panel();
   JPanel button_panel = new JPanel();
   JLabel textfield = new JLabel();
   JButton button_again = new JButton();
   JButton[] buttons = new JButton[9];
   
   boolean player1_turn;
    TicTac(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500,500);
    frame.getContentPane().setBackground(new Color (45,155,101));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);

    button_again.setText("Play again!");
    button_again.setVisible(true);
    
    textfield.setBackground(new Color(8,103,213));
    textfield.setForeground(new Color(1,5,0));
    textfield.setFont(new Font("Ubuntu", Font.BOLD,15));
    textfield.setHorizontalAlignment(JLabel.CENTER);
    textfield.setText("Tic Tac Toe!");
    textfield.setOpaque(true);
    textfield.add(button_again);

    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0,0,500,20);

    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color (45,155,101));
    
    for(int i = 0; i < 9; i++ ) {
    	buttons [i] = new JButton();
    	button_panel.add(buttons[i]);
    	buttons[i].setFont(new Font ("Ubuntu",Font.BOLD, 120));
    	buttons [i].setFocusable(false);
    	buttons [i].addActionListener(this);
    }
    
    title_panel.add(textfield);
    frame.add(title_panel);
    frame.add(button_panel);
    
    firstTurn();

    }
    @Override
    public void actionPerformed (ActionEvent e) {
    	for (int i=0;i<9;i++) {
			if (e.getSource()==buttons[i]) {
    			if(player1_turn) {
    				if (buttons[i].getText() == "") {
    					buttons[i].setForeground(new Color (255, 0, 0));
    					buttons[i].setText("X");
    					player1_turn = false;
    					textfield.setText("It's O's turn!");
    					check();
    				}
    			}
    			else {
    				if (buttons[i].getText() == "") {
    					buttons[i].setForeground(new Color (0, 0, 0));
    					buttons[i].setText("O");
    					player1_turn = true;
    					textfield.setText("It's X's turn!");
    					check();
    				}
    				
    			}
    		}
    	}
    }

    public void firstTurn() {
    	try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}

    	
    	if (random.nextInt(2) == 0) {
    		player1_turn = true;
    		textfield.setText("It's X's turn!");
    	} else {
    		player1_turn = true;
    		textfield.setText("It's O's turn!");
    	}
    }

    public void check() {
    	if (
    		(buttons[0].getText() == "X") &&
    		(buttons[1].getText() == "X") &&
    		(buttons[2].getText() == "X")
    		) {
    		xWins(0,1,2);
    	}
    	if (
        		(buttons[3].getText() == "X") &&
        		(buttons[4].getText() == "X") &&
        		(buttons[5].getText() == "X")
        		) {
        		xWins(3,4,5);
        	}
    	if (
        		(buttons[6].getText() == "X") &&
        		(buttons[7].getText() == "X") &&
        		(buttons[8].getText() == "X")
        		) {
        		xWins(6,7,8);
        	}
    	if (
        		(buttons[0].getText() == "X") &&
        		(buttons[3].getText() == "X") &&
        		(buttons[6].getText() == "X")
        		) {
        		xWins(0,3,6);
        	}
    	if (
        		(buttons[1].getText() == "X") &&
        		(buttons[4].getText() == "X") &&
        		(buttons[7].getText() == "X")
        		) {
        		xWins(1,4,7);
        	}
    	if (
        		(buttons[2].getText() == "X") &&
        		(buttons[5].getText() == "X") &&
        		(buttons[8].getText() == "X")
        		) {
        		xWins(2,5,8);
        	}
    	if (
        		(buttons[0].getText() == "X") &&
        		(buttons[4].getText() == "X") &&
        		(buttons[8].getText() == "X")
        		) {
        		xWins(0,4,8);
        	}
    	if (
        		(buttons[2].getText() == "X") &&
        		(buttons[4].getText() == "X") &&
        		(buttons[6].getText() == "X")
        		) {
        		xWins(2,4,6);
        	}
    	
    	/////////////////////////////////////////////////////////
    	
    	if (
        		(buttons[0].getText() == "O") &&
        		(buttons[1].getText() == "O") &&
        		(buttons[2].getText() == "O")
        		) {
        		oWins(0,1,2);
        	}
        	if (
            		(buttons[3].getText() == "O") &&
            		(buttons[4].getText() == "O") &&
            		(buttons[5].getText() == "O")
            		) {
            		oWins(3,4,5);
            	}
        	if (
            		(buttons[6].getText() == "O") &&
            		(buttons[7].getText() == "O") &&
            		(buttons[8].getText() == "O")
            		) {
            		oWins(6,7,8);
            	}
        	if (
            		(buttons[0].getText() == "O") &&
            		(buttons[3].getText() == "O") &&
            		(buttons[6].getText() == "O")
            		) {
            		oWins(0,3,6);
            	}
        	if (
            		(buttons[1].getText() == "O") &&
            		(buttons[4].getText() == "O") &&
            		(buttons[7].getText() == "O")
            		) {
            		oWins(1,4,7);
            	}
        	if (
            		(buttons[2].getText() == "O") &&
            		(buttons[5].getText() == "O") &&
            		(buttons[8].getText() == "O")
            		) {
            		oWins(2,5,8);
            	}
        	if (
            		(buttons[0].getText() == "O") &&
            		(buttons[4].getText() == "O") &&
            		(buttons[8].getText() == "O")
            		) {
            		oWins(0,4,8);
            	}
        	if (
            		(buttons[2].getText() == "O") &&
            		(buttons[4].getText() == "O") &&
            		(buttons[6].getText() == "O")
            		) {
            		oWins(2,4,6);
            	}
    }

    public void xWins (int a, int b, int c) {
    	buttons[a].setBackground(Color.green);
    	buttons[b].setBackground(Color.green);
    	buttons[c].setBackground(Color.green);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	textfield.setText("X WINS!");
    	
    }
    public void oWins (int a, int b, int c) {
    	buttons[a].setBackground(Color.green);
    	buttons[b].setBackground(Color.green);
    	buttons[c].setBackground(Color.green);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	textfield.setText("O WINS!");
    }
    

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


