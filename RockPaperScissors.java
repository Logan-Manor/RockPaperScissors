package Bonus;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class RockPaperScissors {

	// Global Variables
	private JFrame frame;
	private int humanWon;
	private int win=0;
	private int total=0;
	private int tie=0;


	// Launches the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RockPaperScissors window = new RockPaperScissors();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// Creates the application
	public RockPaperScissors() {
		initialize();
	}

	
	// Initialize the contents of the frame.
	private void initialize() {
		
		// Sets up main frame
		frame = new JFrame("Rock, Paper, Scissors");
		frame.setSize(400, 215);
		frame.getContentPane().setLayout(null);
		
		
		// Sets the menu panel
		JPanel Menu = new JPanel();
		Menu.setBounds(0, 0, 384, 20);
		frame.getContentPane().add(Menu);
		Menu.setLayout(new BorderLayout(0, 0));
		
		
		// Sets the results for the game and displays them on the menu panel
		JLabel ResultLB = new JLabel("Result: Win = "+win+", Loss = "+(total-win-tie)+",Tie = "+tie, SwingConstants.LEFT);
		Menu.add(ResultLB);
		
		
		// Rock panel
		JPanel Rock = new JPanel();
		Rock.setBounds(0, 20, 128, 125);
		frame.getContentPane().add(Rock);
		Rock.setLayout(new BorderLayout(0, 0));
		
		
		// places the rock button on the rock panel and displays the rock image
		JButton Rockbtn = new JButton("");
		Rockbtn.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/rock.png")));
		Rock.add(Rockbtn, BorderLayout.CENTER);
		
		
		// Paper panel
		JPanel Paper = new JPanel();
		Paper.setBounds(128, 20, 128, 125);
		frame.getContentPane().add(Paper);
		Paper.setLayout(new BorderLayout(0, 0));
		
		
		// places the paper button on the paper panel and displays the paper image
		JButton Paperbtn = new JButton("");
		Paperbtn.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/paper.png")));
		Paper.add(Paperbtn, BorderLayout.CENTER);
		
		
		// Scissors panel
		JPanel Scissors = new JPanel();
		Scissors.setBounds(256, 20, 128, 125);
		frame.getContentPane().add(Scissors);
		Scissors.setLayout(new BorderLayout(0, 0));
		
		
		// places the scissor button on the scissor panel and displays the scissors image
		JButton Scissorbtn = new JButton("");
		Scissorbtn.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/scissors.png")));
		Scissors.add(Scissorbtn, BorderLayout.CENTER);
		
		
		// Quit panel
		JPanel Quit = new JPanel();
		Quit.setBounds(0, 145, 384, 31);
		frame.getContentPane().add(Quit);
		Quit.setLayout(new BorderLayout(0, 0));
		
		
		// Displays the quit button and exits the application
		JButton Quitbtn = new JButton("Quit");
		Quit.add(Quitbtn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Adds all the action listeners to each button and displays the winner on a new window
		// Action listener for Rock
		Rockbtn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                computeWinner(1);
                ResultLB.setText("Result: Win = "+win+", Loss = "+(total-win-tie)+",Tie = "+tie);
            }
        });
		
		// Action listener for paper
		Paperbtn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                computeWinner(2);
                ResultLB.setText("Result: Win = "+win+", Loss = "+(total-win-tie)+",Tie = "+tie);
            }
        });
		
		// Action listener for scissors
		Scissorbtn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                computeWinner(3);
                ResultLB.setText("Result: Win = "+win+", Loss = "+(total-win-tie)+",Tie = "+tie);
            }
        });
		
		
		// Quits out of the application
		Quitbtn.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                System.exit(0);
            }
        });
	}
	
	// Figured out the winner
	 public void computeWinner(int x){
	       int computerChoice=computerRandomChoice();
	       int humanChoice=x;
	       String itemWin,winner="";
	       
	       // Finds out the users and computers choice and then places them into an array
	       String winningCombination= ""+Math.min(computerChoice, humanChoice)+Math.max(computerChoice, humanChoice);

	       
	       // Takes the array and then figures out who won and what to add a point to
	       switch(Integer.parseInt(winningCombination)){
	       
	       
	       // checks to see what item won and sets it to itemWin
	       case 12:
	           itemWin = "Paper wins!";
	           if(humanChoice==2) humanWon=1;
	           break;
	       case 13:
	           itemWin = "Rock wins!";
	           if(humanChoice==1) humanWon=1;
	           break;
	       case 23:
	           itemWin = "Scissors wins!";
	           if(humanChoice==3) humanWon=1;
	           break;
	       default: itemWin="It is a tie!";
	       total=total+1;
	       humanWon=2;
	       tie=tie+1;
	       }
	       
	       
	       // checks to see who won and sets it to winner
	       if(humanWon==1){
	           winner="Human wins! ";
	           humanWon=0;
	           win=win+1;
	           total=total+1;
	       }else if(humanWon==2){
	           winner="It is a tie! ";
	           humanWon=0;      
	       }else{
	           winner="Computer wins! ";
	           total=total+1;
	       }
	       
	       
	       // Sets the new frame that would display the winner
	       JFrame frame1 = new JFrame("Computer");
	       Container panel = frame1.getContentPane();
	       panel.setLayout(null);

	       
	       // displays the winner of the round and the winning item
	       JLabel gameResult = new JLabel(winner+ "  " + itemWin);
	       gameResult.setBounds(100, 10, 300, 35);
	       panel.add(gameResult);
	      
	       
	       // Label for the human choice
	       JLabel hChoice = new JLabel("Human's Choice");
	       hChoice.setBounds(40, 35, 150, 35);
	       panel.add(hChoice);
	       
	       
	       // Label for the computers choice
	       JLabel cChoice = new JLabel("Computer's Choice");
	       cChoice.setBounds(215, 35, 150, 35);
	       panel.add(cChoice);
	       
	       
	       // Sets up the image for the human choice
	       JLabel humanICN = new JLabel("");
	       
	       if (humanChoice == 1) {
	    	   humanICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/rock.png")));
	       }
	       else if (humanChoice == 2){
	    	   humanICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/paper.png")));
	       }
	       else if (humanChoice == 3) {
	    	   humanICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/scissors.png")));
	       }
	      
	       humanICN.setBounds(55, 100, 170, 60);
	       panel.add(humanICN);
	       
	       
	       
	       // Displays the image for the computer choice
	       JLabel computerICN = new JLabel("");
	       
	       if (computerChoice == 1) {
	    	   computerICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/rock.png")));
	       }
	       else if (computerChoice == 2){
	    	   computerICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/paper.png")));
	       }
	       else if (computerChoice == 3) {
	    	   computerICN.setIcon(new ImageIcon(RockPaperScissors.class.getResource("/Bonus/scissors.png")));
	       }
	       
	       computerICN.setBounds(250, 100, 170, 60);
	       panel.add(computerICN);

	       
	       // Displays the new window
	       frame1.setSize(400, 225);
	       frame1.setVisible(true);
	   }

	   // Random generator for the computer
	   public int computerRandomChoice(){
	       int result=(int)(Math.random()*3)+1;      
	       return result;
	   }

}
