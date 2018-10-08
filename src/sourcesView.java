import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class sourcesView extends JFrame implements ActionListener
{

	
	private JButton cmdFirstLink,	// declaration of buttons
			cmdSecondLink,
			cmdThirdLink,
			cmdFourthLink,
			cmdFifthLink,
			cmdSixthLink,
			cmdBack;
	
	private JLabel lblFirstLink,	// declaration of labels
		   lblSecondLink,
		   lblThirdLink,
		   lblFourthLink,
		   lblFifthLink,
		   lblSixthLink;
	
	private JPanel p1, p2, p3;
	
	public sourcesView() 
	{
		
		this.setTitle("HTML Sources:");
		

		// settings
		this.setLayout(new GridLayout(5,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(470,120);
		this.setSize(205,400);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		
		/************************************************
		 * Declare the icons to assign them with buttons*
		 ************************************************/
		Icon icFirstLink = new ImageIcon("images/codepen.png");
		Icon icSecondLink = new ImageIcon("images/w3schools.png");
		Icon icThirdLink = new ImageIcon("images/HTML-bestcode.png");
		Icon icFourthLink = new ImageIcon("images/htmlgoodies.png");
		
		/**********************************************************
		 * Define the buttons and assign each button with its icon*
		 **********************************************************/
		this.cmdFirstLink = new JButton(icFirstLink);
		this.cmdSecondLink = new JButton(icSecondLink);
		this.cmdThirdLink = new JButton(icThirdLink);
		this.cmdFourthLink = new JButton(icFourthLink);
		this.cmdBack = new JButton("< Back");
		
		/***********************************
		 * Add tooltip text for description*
		 ***********************************/
		cmdFirstLink.setToolTipText("CodePen is a playground for the front end web.");
		cmdSecondLink.setToolTipText("W3schools, the world largest web developer site, Useful information about HTML");
		cmdThirdLink.setToolTipText("HTMLbestcode: This website provide useful HTML codes and effects for free!");
		cmdFourthLink.setToolTipText("<HTML Goodies/> provides useful information and tutorials about HTML language!");
		
		/*********************************************
		 * Match the button's size with the icon size*
		 *********************************************/
		cmdFirstLink.setPreferredSize(new Dimension(icFirstLink.getIconWidth(), icFirstLink.getIconHeight()));
		cmdSecondLink.setPreferredSize(new Dimension(icSecondLink.getIconWidth(), icSecondLink.getIconHeight()));
		cmdThirdLink.setPreferredSize(new Dimension(icThirdLink.getIconWidth(), icThirdLink.getIconHeight()));
		cmdFourthLink.setPreferredSize(new Dimension(icFourthLink.getIconWidth(), icFourthLink.getIconHeight()));
		
		add(cmdFirstLink);
		add(cmdSecondLink);
		add(cmdThirdLink);
		add(cmdFourthLink);
		add(cmdBack);
	
		this.cmdBack.addActionListener(this);
		this.cmdFirstLink.addActionListener(this);
		this.cmdSecondLink.addActionListener(this);
		this.cmdThirdLink.addActionListener(this);
		this.cmdFourthLink.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		sourcesCntrl sc = new sourcesCntrl(); 
		
		
		if(e.getSource() == cmdBack)
		{
			navigationView n = new navigationView();
			n.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
		
		if(e.getSource() == cmdFirstLink)
		{
			try {
				sc.openLink("http://codepen.io/"); // use the sourcesCntrl to open link
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == cmdSecondLink)
		{	
			try {
				sc.openLink("https://www.w3schools.com/html/");
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == cmdThirdLink)
		{	
			try {
				sc.openLink("http://www.htmlbestcodes.com/");
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == cmdFourthLink)
		{
			
			try {
				sc.openLink("http://www.htmlgoodies.com/");
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
	}
} // end class


