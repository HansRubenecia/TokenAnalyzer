package com.TokenAnalyzer.Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import com.TokenAnalyzer.domain.*;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Gui {
	
	private File file;
	private String fileContent;
	private String outputLex;
	private String outputSyn;
	private String outputSem;
	private JFrame frame;
	private LexicalAnalysis lex;
	private SyntaxAnalysis syn;
	private SemanticAnalysis sem;
	public Gui() {
		
		initialize();
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1009, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1010,605);
		frame.getContentPane().setBackground(new Color(54,57,63,255));
		frame.setLocationRelativeTo(null);
		ImageIcon imgExit = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/exit.png")).getImage().getScaledInstance(33, 33, Image.SCALE_DEFAULT));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47,49,54,255));
		panel.setBounds(0, 0, 341, 605);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(54,57,63,255));
		panel2.setBounds(339, 0, 671, 605);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		ImageIcon imgIcon = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/tokenLogo.png")).getImage().getScaledInstance(49, 45, Image.SCALE_DEFAULT));
		lblLogo.setIcon(imgIcon);
		frame.setIconImage(imgIcon.getImage());
		frame.setBackground(new Color(255, 250, 250));
		
		
		lblLogo.setBounds(22, 25, 49, 45);
		panel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("Token Analyzer");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblNewLabel.setBounds(81, 25, 226, 45);
		panel.add(lblNewLabel);
		
		JScrollPane pathPane = new JScrollPane();
		pathPane.setViewportBorder(null);
		pathPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		pathPane.setBounds(22, 81, 285, 45);
		panel.add(pathPane);
		
		JTextPane pathField = new JTextPane();
		pathField.setText("No file selected");
		pathField.setEditable(false);
		pathField.setBackground(new Color(255, 250, 250));
		pathPane.setViewportView(pathField);
		
		JLabel btFile = new JLabel("");
		
		btFile.setBounds(105, 137, 125, 54);
		
		frame.setTitle("Token Analyzer");
		ImageIcon imgFile = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/chooseFile.png")).getImage().getScaledInstance(118,38, Image.SCALE_DEFAULT));
		btFile.setIcon(imgFile);
		
		lblLogo.setBounds(22, 25, 49, 45);
		panel.add(btFile);
		
		JLabel btFileSelected = new JLabel("");

		btFileSelected.setBounds(105, 137, 125, 54);
		ImageIcon imgFileSelected = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/chooseFileSelected.png")).getImage().getScaledInstance(118,38, Image.SCALE_DEFAULT));
		btFileSelected.setIcon(imgFileSelected);
		btFileSelected.setVisible(false);
		panel.add(btFileSelected);
		
		JLabel btLexU = new JLabel("");
		btLexU.setBounds(71, 202, 198, 42);
		ImageIcon imgLexU = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/LexicalU.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btLexU.setIcon(imgLexU);
		btLexU.setVisible(false);
		panel.add(btLexU);
		
		JLabel btLexS = new JLabel("");
		btLexS.setBounds(71, 202, 198, 42);
		ImageIcon imgLexS = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/LexicalS.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btLexS.setIcon(imgLexS);
		btLexS.setVisible(false);
		panel.add(btLexS);
		
		JLabel btSynU = new JLabel("");
		btSynU.setBounds(71, 267, 198, 42);
		ImageIcon imgSynU = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/SyntaxU.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSynU.setIcon(imgSynU);
		btSynU.setVisible(false);
		panel.add(btSynU);
		
		JLabel btSynS = new JLabel("");
		btSynS.setBounds(71, 267, 198, 42);
		ImageIcon imgSynS = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/SyntaxS.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSynS.setIcon(imgSynS);
		btSynS.setVisible(false);
		panel.add(btSynS);
		
		JLabel btSemU = new JLabel("");
		btSemU.setBounds(71, 333, 198, 42);
		ImageIcon imgSemU = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/SemanticU.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSemU.setIcon(imgSemU);
		btSemU.setVisible(false);
		panel.add(btSemU);
		
		JLabel btSemS = new JLabel("");
		btSemS.setBounds(71, 333, 198, 42);
		ImageIcon imgSemS = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/SemanticS.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSemS.setIcon(imgSemS);
		btSemS.setVisible(false);
		panel.add(btSemS);
		
		JLabel btLex = new JLabel("");
		btLex.setBounds(71, 202, 198, 42);
		ImageIcon imgLex = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/Lexical.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btLex.setIcon(imgLex);
		btLex.setVisible(true);
		panel.add(btLex);
		
		JLabel btSyn = new JLabel("");
		btSyn.setBounds(71, 267, 198, 42);
		ImageIcon imgSyn = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/Syntax.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSyn.setIcon(imgSyn);
		btSyn.setVisible(true);
		panel.add(btSyn);
		
		JLabel btSem = new JLabel("");
		btSem.setBounds(71, 333, 198, 42);
		ImageIcon imgSem = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/Semantic.png")).getImage().getScaledInstance(198,42, Image.SCALE_DEFAULT));
		btSem.setIcon(imgSem);
		btSem.setVisible(true);
		panel.add(btSem);
		
		JLabel check = new JLabel("");
		check.setBounds(17, 202, 44, 44);
		ImageIcon imgCheck = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/check.png")).getImage().getScaledInstance(44,44, Image.SCALE_DEFAULT));
		check.setIcon(imgCheck);
		check.setVisible(false);
		panel.add(check);
		
		JLabel check2 = new JLabel("");
		check2.setBounds(17, 267, 44, 44);
		ImageIcon imgCheck2 = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/check.png")).getImage().getScaledInstance(44,44, Image.SCALE_DEFAULT));
		check2.setIcon(imgCheck2);
		check2.setVisible(false);
		panel.add(check2);
		
		JLabel check3 = new JLabel("");
		check3.setBounds(17, 333, 44, 44);
		ImageIcon imgCheck3 = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/check.png")).getImage().getScaledInstance(44,44, Image.SCALE_DEFAULT));
		check3.setIcon(imgCheck3);
		check3.setVisible(false);
		panel.add(check3);

		JLabel error = new JLabel("");
		error.setBounds(17, 267, 44, 44);
		ImageIcon imgError = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/error.png")).getImage().getScaledInstance(44,44, Image.SCALE_DEFAULT));
		error.setIcon(imgError);
		error.setVisible(false);
		panel.add(error);
		
		JLabel error2 = new JLabel("");
		error2.setBounds(17, 333, 44, 44);
		ImageIcon imgError2 = new ImageIcon(new ImageIcon(Gui.class.getResource("/com/TokenAnalyzer/Resource/error.png")).getImage().getScaledInstance(44,44, Image.SCALE_DEFAULT));
		error2.setIcon(imgError2);
		error2.setVisible(false);
		panel.add(error2);
		
		
		JScrollPane inputPane = new JScrollPane();
		inputPane.setBounds(20, 70, 630, 87);
		panel2.add(inputPane);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setForeground(new Color(240, 255, 255));
		lblInput.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblInput.setBounds(10, 11, 75, 45);
		panel2.add(lblInput);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setForeground(new Color(240, 255, 255));
		lblResult.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblResult.setBounds(10, 168, 75, 45);
		panel2.add(lblResult);
		
		JTextPane inputField = new JTextPane();
		inputField.setBounds(0, 59, 671, 85);
		inputPane.setViewportView(inputField);
		inputField.setForeground(new Color(0, 0, 0));
		inputField.setFont(new Font("Montserrat", Font.PLAIN, 15));
		inputField.setBackground(new Color(255, 250, 250));
		inputField.setEditable(false);
		
		JScrollPane resultPane = new JScrollPane();
		resultPane.setBounds(20, 226, 630, 118);
		panel2.add(resultPane);
		
		JTextPane resultField = new JTextPane();
		resultPane.setViewportView(resultField);
		resultField.setFont(new Font("Montserrat", Font.PLAIN, 15));
		resultField.setForeground(new Color(0, 0, 0));
		resultField.setBackground(new Color(255, 250, 250));
		resultField.setEditable(false);
		
		
		
		

		btFileSelected.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();
        		int response = fileChooser.showOpenDialog(null);
        		if (response == JFileChooser.APPROVE_OPTION)
        		{
        		file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        		pathField.setText(file.toString());
        		ReadFile rf = new ReadFile();
        		fileContent = rf.ReadInput(fileChooser.getSelectedFile().getAbsolutePath());
        		btLexU.setVisible(true);
				btLexS.setVisible(false);
        		btLex.setVisible(false);
				btSemS.setVisible(false);
        		btSemU.setVisible(false);
				btSem.setVisible(true);
        		btSynU.setVisible(false);
				btSynU.setVisible(false);
				btSyn.setVisible(true);
				check.setVisible(false);
				check2.setVisible(false);
				check3.setVisible(false);
				error.setVisible(false);
				error2.setVisible(false);
				
				
				resultField.setText("");
				inputField.setText(fileContent);
        		
        		}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btFileSelected.setVisible(false);
				btFile.setVisible(true);
			}
		});
		btFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btFileSelected.setVisible(true);
				btFile.setVisible(false);
			}
		});
		btLexU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btLexS.setVisible(true);
				btLexU.setVisible(false);
			}
		});
		btLexS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) 
			{
				if(check.isVisible())
				{
					btLexU.setVisible(false);
					btLexS.setVisible(false);
				}
				else
				{
					btLexU.setVisible(true);
					btLexS.setVisible(false);
				}

			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				btLexU.setVisible(false);
				btLexS.setVisible(false);
				btLex.setVisible(true);
				check.setVisible(true);
            	lex = new LexicalAnalysis();
            	outputLex = lex.Analysis(fileContent);
            	resultField.setText(outputLex);
            	btSyn.setVisible(false);
            	btSynU.setVisible(true);
				
				
			}
		});
		btSynU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btSynS.setVisible(true);
				btSynU.setVisible(false);
			}
		});
		btSynS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) 
			{
				if(check2.isVisible())
				{
					btSynU.setVisible(false);
					btSynS.setVisible(false);
				}
				else if(error.isVisible());
				else
				{
					btSynU.setVisible(true);
					btSynS.setVisible(false);
				}
			}
			public void mouseClicked(MouseEvent e) 
			{
				
				btSynU.setVisible(false);
				btSynS.setVisible(false);
				btSyn.setVisible(true);
				syn = new SyntaxAnalysis();
            	resultField.setText(syn.Analysis(outputLex));
            	if(resultField.getText().equals("Syntax is Correct!"))
            	{
            		check2.setVisible(true);
            		btSem.setVisible(false);
                	btSemU.setVisible(true);
            	}
            	else
            	{
            		error.setVisible(true);
            	}
            	
		
				
			}
		});
		btSemU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btSemS.setVisible(true);
				btSemU.setVisible(false);
			}
		});
		btSemS.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) 
			{
				if(check3.isVisible())
				{
					btSemU.setVisible(false);
					btSemS.setVisible(false);
				}
				else if(error2.isVisible());
				else
				{
					btSemU.setVisible(true);
					btSemS.setVisible(false);
				}
			}
			public void mouseClicked(MouseEvent e) 
			{
				
				btSemU.setVisible(false);
				btSemS.setVisible(false);
				btSem.setVisible(true);
				
				lex.getDataType();
				lex.getValue();
				sem = new SemanticAnalysis();
				resultField.setText(sem.Analysis(lex.getDataType(),lex.getValue()));
				if(resultField.getText().equals("Semantically Correct!"))
            	{
					check3.setVisible(true);
            	}
				else
            	{
            		error2.setVisible(true);
	
            	}
            	
			}
		});

		frame.setVisible(true);
	}
}
