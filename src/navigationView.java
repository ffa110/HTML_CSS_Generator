import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;


class navigationView extends JFrame implements ActionListener
{

//declaration
	private JPanel p1, p2;
	
	private JButton cmdCodeGenerator,
			cmdSources,
			cmdOpenFile;
	
	private JLabel lblLogo;
	
	public navigationView()
	{
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Welcome to HTML Code Generator!");
		this.setLayout(new FlowLayout());
		this.setSize(400,370);
		this.setLocation(385,150);
	
		p1 = new JPanel(); // add Generator and Sources
		p2 = new JPanel(); // add open file
		
		
		Icon icLogo = new ImageIcon("images/HTML code generator.png"); //logo icon and its label
		this.lblLogo = new JLabel(icLogo); // assign label with the logo (icon)
	
		Icon icGenerator = new ImageIcon("images/Code-Generator.png"); 
		this.cmdCodeGenerator = new JButton(icGenerator); // assign button with its icon
		
		Icon icSources = new ImageIcon("images/HTML-Sources.png");
		this.cmdSources = new JButton(icSources);
		
		Icon icOpenFile = new ImageIcon("images/open-file.png");
		this.cmdOpenFile = new JButton(icOpenFile);
		
		this.getContentPane().setBackground(Color.white);
		
		add(lblLogo);
		
		p1.setBackground(Color.white);
		p1.add(cmdCodeGenerator);
		p1.add(cmdSources);
		add(p1);
		
		p2.setBackground(Color.white);
		p2.add(cmdOpenFile);
		add(p2);

		cmdCodeGenerator.addActionListener(this);
		cmdSources.addActionListener(this);
		cmdOpenFile.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource() == cmdCodeGenerator)
		{
			generatorView gv;
			try {
				gv = new generatorView();
				gv.setVisible(true);
				this.setVisible(false);
				this.dispose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(ae.getSource() == cmdSources)
		{
			sourcesView	sv = new sourcesView();
				sv.setVisible(true);
				this.setVisible(false);
				this.dispose();
			
		}
		if(ae.getSource() == cmdOpenFile)
		{
			FileOpenerView fp;
			try {
				fp = new FileOpenerView();
				fp.chooser.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
