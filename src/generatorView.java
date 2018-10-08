import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.imageio.*;


import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class generatorView extends JFrame implements ActionListener
{
	
	generatorCntrl gc = new generatorCntrl();
	generatorModel gm = new generatorModel();

// declaration
	private JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
	
	int count = 0; // helps method to distinguish where to add the piece of code
	
	private JTextField txtTitle = new JTextField(15);
	
	private JTextArea txtInput = new JTextArea(7,30);
	public JTextArea generatedText = new JTextArea(38,71);
	
	private JButton cmdText,cmdBold, 
			cmdBackground, cmdImage,
			cmdItalic, cmdAlignLeft,
			cmdAlignRight, cmdAlignCenter,
			cmdLink, cmdVideo,
			cmdSave, cmdClear,
			cmdAdd, cmdDone, 
			cmdNextLine, cmdView,
			cmdBack;
	
	ArrayList<String> fonts = new ArrayList<String>(); // arraylist to store fonts
	
	JLabel lblImageURL = new JLabel("Image URL:");
	JTextField txtImageURL = new JTextField(5);
	
	JLabel lblImageName = new JLabel("Image Name:");
	JTextField txtImageName = new JTextField(5);
	
	JLabel lblImageWidth = new JLabel("Width:");
	JTextField txtWidth = new JTextField(2);
	
	JLabel lblImageHeight = new JLabel("Height:");
	JTextField txtHeight = new JTextField(2);
	
	JLabel lblBackgroundColor = new JLabel("Background Color:");
	JLabel lblBackgroundURL = new JLabel("Background URL:");
	
	JTextField txtBackgroundColor = new JTextField(10);
	JTextField txtBackgroundURL = new JTextField(10);
	
	private JLabel lblPageTitle, lblEnterText,
				   lblCode, lblHeadings,
				   lblFont, lblColor,lblEmpty;
				   
	
	/*********************************************
	 * String Arrays to pass into the JComboBoxes*
	 *********************************************/
	private String[] strHeadings = {"", htmlHeading("1", "h1"), htmlHeading("2", "h2"), // used html language to display represent headings 
			htmlHeading("3", "h3"), htmlHeading("4", "h4"), htmlHeading("5", "h5"),
			htmlHeading("6", "h6")};
	
	private String[] strFontSize = {htmlFontSize("1","1"),htmlFontSize("2","2"), htmlFontSize("3","3"), htmlFontSize("4","4"),		// htmlFontSize to represent the actual size of the font
			htmlFontSize("5","5"), htmlFontSize("6","6"), htmlFontSize("7","7")};
	
	private String[] strFontColor = {htmlColor("red", "red"),htmlColor("green", "green"), // html language to display the actual colors
									 htmlColor("blue", "blue"), htmlColor("yellow", "yellow"),
									 htmlColor("orange", "orange"), htmlColor("white", "white"),
									 htmlColor("black", "black")};
	private String[] strFontType;
	
	
	/*************************
	 * ComboBoxes for options*
	 *************************/
	JComboBox cmbFontType = new JComboBox();
	JComboBox cmbHeadings = new JComboBox(strHeadings);
	JComboBox cmbFontSize = new JComboBox(strFontSize);
	JComboBox cmbColors = new JComboBox(strFontColor);
	
	JScrollPane generatorSlider = new JScrollPane(generatedText);
	JScrollPane textSlider = new JScrollPane(txtInput);
	
	public generatorView() throws FileNotFoundException, IOException
	{
		
		
		this.setLayout(new GridLayout(1,2,5,5));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(270,120);
		this.setSize(1050, 590);
		
		AListener ActionHandler = new AListener();
		
		
		
		gm.fileFonts(fonts);	// fill the ArrayList with fonts from excel sheet
		
		
		for(String str : fonts)			// fill the ComboBox with fonts from ArrayList
			cmbFontType.addItem(str);
	
		/******************************
		 * Listen to JComboBoxes Items*
		 ******************************/
		cmbFontType.addActionListener(ActionHandler);
//		cmbHeadings.addItemListener(handler);
		cmbFontSize.addActionListener(ActionHandler);
		cmbColors.addActionListener(ActionHandler);
		cmbHeadings.addActionListener(ActionHandler);
		
//		cmbFontSize.setEditable(true);
		
		
		p1 = new JPanel(); // for buttons
		p2 = new JPanel(); // text area
		p3 = new JPanel(); // 
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		
		
		/*****************
		 * Declare labels*
		 *****************/
		lblPageTitle = new JLabel("Page Title:");
		lblEnterText = new JLabel("Enter Text:");
		lblCode = new JLabel("HTML Code:");
		lblHeadings = new JLabel("Headings:");
		lblFont = new JLabel("Font:");
		lblColor = new JLabel("Text Color:");
		lblEmpty = new JLabel(" ");
		
		/********************************
		 * Declare Icons for each button*
		 ********************************/
		Icon icText = new ImageIcon("images/text.png");
		Icon icBold = new ImageIcon("images/Bold.png");
		Icon icBackground  = new ImageIcon("images/background.png");
		Icon icImage = new ImageIcon("images/insert-image.png");
		Icon icItalic = new ImageIcon("images/Italics.png");
		Icon icLeft = new ImageIcon("images/align-left.png");
		Icon icRight = new ImageIcon("images/align-right.png");
		Icon icCenter = new ImageIcon("images/align-center.png");
		Icon icLink = new ImageIcon("images/link.png");
		Icon icForm = new ImageIcon("images/Form.png");
		Icon icVideo = new ImageIcon("images/YouTube-icon.png");
		Icon icTable = new ImageIcon("images/insert-table.png");
		Icon icQuote = new ImageIcon("images/quote.png");
	
		
		/*********************************
		 * Link each button with its icon*
		 *********************************/
		this.cmdText = new JButton(icText);
		this.cmdBold = new JButton(icBold);
		this.cmdBackground = new JButton(icBackground);
		this.cmdImage = new JButton(icImage);
		this.cmdItalic = new JButton(icItalic);
		this.cmdAlignLeft = new JButton(icLeft);
		this.cmdAlignRight = new JButton(icRight);
		this.cmdAlignCenter = new JButton(icCenter);
		this.cmdLink = new JButton(icLink);
		this.cmdVideo = new JButton(icVideo);
		this.cmdBack = new JButton("< Back");
		this.cmdSave = new JButton("Save");
		this.cmdClear = new JButton("Clear");
		this.cmdAdd = new JButton("Add >");
		this.cmdDone = new JButton("Done");
		this.cmdNextLine = new JButton("Next Line ->");
		this.cmdView = new JButton("View");
		
		this.cmdNextLine.setPreferredSize(new  Dimension(250,20));
		
		
		/****************************************************
		 * Make the size of buttons depends on the icon size*
		 ****************************************************/
		setButtonSize(cmdText, icText);
		setButtonSize(cmdBold, icBold);
		setButtonSize(cmdItalic, icItalic);
		setButtonSize(cmdBackground, icBackground);
		setButtonSize(cmdImage, icImage);
		setButtonSize(cmdAlignLeft, icLeft);
		setButtonSize(cmdAlignRight, icRight);
		setButtonSize(cmdAlignCenter, icCenter);
		setButtonSize(cmdLink, icLink);
		setButtonSize(cmdVideo, icVideo);
		
		/**********************************************
		 * Create a black border around the text areas*
		 **********************************************/
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.textSlider.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		this.generatedText.setBorder(BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		/***************************************** 
		 * Change the color of the generated code*
		 *****************************************/
		generatedText.setFont(new Font("COURIER", Font.PLAIN, 11));
		generatedText.setText("<!DOCTYPE html>\n\n<html>\n\n<head>\n\n</head>\n\n<body>\n\n</body>\n\n</html>");
		
		/******************************
		 * Add hints about the buttons*
		 ******************************/
		this.cmdText.setToolTipText("Plain text");
		this.cmdBold.setToolTipText("Bold text");
		this.cmdItalic.setToolTipText("Italic text");
		this.cmdImage.setToolTipText("Insert Image");
		this.cmdAlignLeft.setToolTipText("Align to left Text");
		this.cmdAlignRight.setToolTipText("Align to right Text");
		this.cmdAlignCenter.setToolTipText("Align to center Text");
		this.cmdBackground.setToolTipText("Change page's background");
		this.cmdLink.setToolTipText("Insert link, hypertext");
		this.cmdVideo.setToolTipText("Insert Video");
		
		
		p5.add(lblCode); 
	
		p2.add(p5); // panel 2 is the right half of the Code Generator window
	
		p2.add(generatorSlider);
		p2.add(cmdView);
		p2.add(cmdSave);
		
		p7.setBackground(Color.WHITE);
		p7.add(cmdBack);
		p7.add(cmdClear);
		p7.add(cmdAdd);
		
		
		p1.setBackground(Color.white); // panel 1 is the left side of the Code Generator Window
		p1.add(cmdText);
		p1.add(cmdBold);
		p1.add(cmdItalic);
		p1.add(cmdAlignLeft);
		p1.add(cmdAlignCenter);
		p1.add(cmdAlignRight);
		p1.add(cmdLink);
		p1.add(cmdBackground);
		p1.add(cmdImage);
		p1.add(cmdVideo);

		
		p6.setBackground(Color.WHITE);
		p6.add(lblHeadings);
		p6.add(cmbHeadings);
		p6.add(lblFont);
		p6.add(cmbFontType);
		p6.add(cmbFontSize);
		
		p8.setBackground(Color.white);
		p8.add(lblColor);
		p8.add(cmbColors);
		
		
		
		
		p3.setBackground(Color.white);
		p3.add(lblPageTitle);
		p3.add(txtTitle);
		
		p4.setBackground(Color.WHITE);
		p4.add(lblEnterText);
		p4.add(textSlider);
		
		p10.setBackground(Color.WHITE);
		p10.add(cmdNextLine);
		
		p1.add(p6);
		p1.add(p8);
		p1.add(p3);
		
		p1.add(p4);
		p1.add(p10);
		p1.add(p7);
		
		/******************************
		 * Add components to 3rd panel*
		 ******************************/

		add(p1);
		add(p2);
		
		this.cmdBack.addActionListener(this);
		this.cmdBold.addActionListener(this);
		this.cmdItalic.addActionListener(this);
		this.cmdAdd.addActionListener(this);
		this.cmdAlignLeft.addActionListener(this);
		this.cmdAlignCenter.addActionListener(this);
		this.cmdAlignRight.addActionListener(this);
		this.cmdClear.addActionListener(this);
		this.cmdLink.addActionListener(this);
		this.cmdImage.addActionListener(this);
		this.cmdDone.addActionListener(this);
		this.cmdNextLine.addActionListener(this);
		this.cmdSave.addActionListener(this);
		this.cmdView.addActionListener(this);
		this.cmdBackground.addActionListener(this);
		this.cmdVideo.addActionListener(this);
	}
	
	public String htmlColor(String color, String name) // represent the colors with the actual colors on screen
	{
		return "<html><b><font size=\"3\" type=\"Bold\" color=\"" + color + "\">" + name + "</font></b></html>";	
	}
	
	public String htmlHeading(String headingNum, String text)	// represent the heandings with the actual size on screen
	{
		return "<html><h" + headingNum + ">" + text + "</h" + headingNum + "><html>";	
	}
	
	public String htmlFontSize(String Size, String str) 	// represent the font size with the acutal size on screen
	{
		return "<html> <font size=\"" + Size + "\">" + str +  "</font></html>";
	}
	
	public void setButtonSize(JButton a, Icon b)	// controls the buttons size and set it based on the image size
	{
		a.setPreferredSize(new Dimension(b.getIconWidth(), b.getIconHeight()));
	}

	
	
	
	/***************************
	 ** Action Listener Class **
	 ***************************/
	private class AListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == cmbHeadings)
    		{
    			String tempAdd = "";
    		
    			tempAdd = "<" + gc.html2text(cmbHeadings.getSelectedItem().toString()) + ">" + txtInput.getText().toString() + "</" +  
    					gc.html2text(cmbHeadings.getSelectedItem().toString()) + ">";
    			
    			txtInput.setText(tempAdd); // sets the tempAdd string to the text area on the left
    		}
    		
    		else if(e.getSource() == cmbFontType)
    		{
    			try
    			{
    				gc.changeFont(txtInput, cmbFontType.getSelectedItem().toString());	// change the font of the text user type in the text area
    			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		
    		else if(e.getSource() == cmbFontSize)
    		{
    			try
    			{
    				gc.changeSize(txtInput, gc.html2text(cmbFontSize.getSelectedItem().toString())); // change the size of the text user type in the text area
    			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    		
    		else if(e.getSource() == cmbColors)
    		{
    			try
    			{
    				gc.changeColor(txtInput, gc.html2text(cmbColors.getSelectedItem().toString())); // change the color of the text user type in the text area
    			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
		}
		
	}
	
	 
	 
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cmdNextLine)
		{
			String tempStr = "";
			tempStr = txtInput.getText().toString();
			tempStr += "\n<br>";		// jump one line
			txtInput.setText(tempStr);
		}
		if(e.getSource() == cmdBack)
		{
			navigationView n = new navigationView();
			n.setVisible(true);
			this.setVisible(false);
			this.dispose();
		}
		if(e.getSource() == cmdClear)
		{
			txtInput.setText(null);	// set text area on the left to null
		}
		
		
		if(e.getSource() == this.cmdBackground)
		{
			count = 2;	
			
			p9.removeAll();
			p9.add(lblBackgroundColor);
			p9.add(txtBackgroundColor);
			p9.add(lblBackgroundURL);
			p9.add(txtBackgroundURL);
			p1.remove(p7);
			p1.add(p9);
			p7.remove(cmdAdd);
			p7.add(cmdDone);
			p1.add(p7);
			
			add(p1);
			add(p2);
			this.getContentPane().invalidate();
			this.getContentPane().validate();

			this.resize(this.getWidth()-1, this.getHeight()-1);
			this.resize(this.getWidth()+1, this.getHeight()+1);
			
			
			
		}
		
		/*****************************************************
		 * Distinguish between adding code under body or head*
		 *****************************************************/
		if(e.getSource() == cmdAdd)
		{	
				
			
			if(count <= 1)
			{
				
				if(this.txtTitle.getText().toString().length() > 0)
				{
					try {
						gc.insertUnderHead(txtTitle, generatedText, gc.htmlTag(72, txtTitle.getText().toString()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtTitle.enable(false);
				}
				gc.insertUnderBody(txtInput, generatedText, txtInput.getText().toString());
				
				count = 0;
			}
			
			else if(count == 2)
			{
				
				gc.insertUnderStyle(txtInput, generatedText, txtInput.getText().toString());
				
				count = 0;
			}
		}

		
		if(e.getSource() == cmdVideo)
		{
			txtInput.setText("(Paste the Youtube embeded link here! then add it to the code");
		}
		
		if(e.getSource() == cmdDone)
		{
			

		 if(count == 1)
			{
				
				if(this.txtImageURL.getText().equals("") && this.txtImageName.getText().equals("") && this.txtHeight.getText().equals("") && this.txtWidth.getText().equals(""))	
				{
					/**
					 * reset the interface
					 */
				this.p1.remove(p9);
				p1.invalidate();
				p1.validate();
				this.p7.remove(cmdDone);
				this.p7.add(cmdAdd);
				this.getContentPane().invalidate();
				this.getContentPane().validate();
				this.resize(this.getWidth()-1, this.getHeight()-1); // this helps the interface to not break
				this.resize(this.getWidth()+1, this.getHeight()+1); //
				}
				
				else if (count == 1)
				{
					String strImageCode = "";
					
					strImageCode = "<img src=\"" + txtImageURL.getText().toString() + "\" alt=\"" + txtImageName.getText().toString() +
							"\" style=\"width:" + txtWidth.getText().toString() + "px;height:" + txtHeight.getText() +"px;\">";
					
					txtInput.setText(strImageCode);
					
					/**
					 * reset the interface
					 */
					this.p1.remove(p9);
					p1.invalidate();
					p1.validate();
					this.p7.remove(cmdDone);
					this.p7.add(cmdAdd);
					this.getContentPane().invalidate();
					this.getContentPane().validate();
					this.resize(this.getWidth()-1, this.getHeight()-1); // this helps the interface to not break
					this.resize(this.getWidth()+1, this.getHeight()+1); //
					this.txtImageName.setText(null);
					this.txtImageURL.setText(null);
					this.txtHeight.setText(null);
					this.txtWidth.setText(null);
				}
			}
			
			else if(count == 2)
			{
				if((this.txtBackgroundColor.getText().toString().length() == 0) && (this.txtBackgroundURL.getText().toString().length() == 0))
				{
					/**
					 * reset the interface
					 */
					this.p1.remove(p9);
					p1.invalidate();
					p1.validate();
					this.p7.remove(cmdDone);
					this.p7.add(cmdAdd);
					this.getContentPane().invalidate();
					this.getContentPane().validate();
					this.resize(this.getWidth()-1, this.getHeight()-1); // this helps the interface to not break
					this.resize(this.getWidth()+1, this.getHeight()+1); //
					this.txtBackgroundColor.setText(null);
					this.txtBackgroundURL.setText(null);
					
				}
				else
				{
				gc.changeBackground(this.txtBackgroundURL.getText().toString(), this.txtBackgroundColor.getText().toString(), txtInput);
				
				/**
				 * reset the interface
				 */
				this.p1.remove(p9);
				p1.invalidate();
				p1.validate();
				this.p7.remove(cmdDone);
				this.p7.add(cmdAdd);
				this.getContentPane().invalidate();
				this.getContentPane().validate();
				this.resize(this.getWidth()-1, this.getHeight()-1); // this helps the interface to not break
				this.resize(this.getWidth()+1, this.getHeight()+1); //
				this.txtBackgroundColor.setText(null);
				this.txtBackgroundURL.setText(null);
				}
			}
		}
		
		if(e.getSource() == cmdItalic)
		{
			try {
				gc.generateHtml(txtInput, 41);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == cmdBold)
		{
			try {
				gc.generateHtml(txtInput, 13);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if( e.getSource() == this.cmdAlignLeft)
		{
			try {
				gc.alignement(txtInput,"left");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if( e.getSource() == this.cmdAlignRight)
		{
			try {
				gc.alignement(txtInput,"right");
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if( e.getSource() == this.cmdAlignCenter)
		{
			try {
				gc.alignement(txtInput,"center");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == this.cmdLink)
		{
			if(txtInput.getText().equals(""))
			{
				txtInput.setText("<a href=\"Add URL\">Add link text</a>");
			}
			else
			{
				txtInput.setText("<a href=\"Add URL\">" + txtInput.getText().toString() + "</a>");
			}
		}
		if(e.getSource() == this.cmdImage)
		{
			String strImageCode = "";
		
			count = 1;
			
			p9.removeAll();
			p9.add(lblImageURL);
			p9.add(txtImageURL);
			p9.add(lblImageName);
			p9.add(txtImageName);
			p9.add(lblImageWidth);
			p9.add(txtWidth);
			p9.add(lblImageHeight);
			p9.add(txtHeight);
			p1.remove(p7);
			p1.add(p9);
			p7.remove(cmdAdd);
			p7.add(cmdDone);
			p1.add(p7);
			
			this.remove(p1);
			this.remove(p2);
		
			add(p1);
			add(p2);
			
			this.getContentPane().invalidate();	// to update the frame
			this.getContentPane().validate();	//

			this.resize(this.getWidth()-1, this.getHeight()-1);	// this helps the interface to not break
			this.resize(this.getWidth()+1, this.getHeight()+1); //
		}
		

		if(e.getSource() == this.cmdSave)
		{
			fileSaverView sf = new fileSaverView();
			try {
				sf.saveFile(this.generatedText);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == this.cmdView)
		{
			fileSaverView sf = new fileSaverView();
			try
			{
				sf.viewFile(generatedText);	// 
				
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
