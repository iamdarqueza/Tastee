package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;

import control.DocumentSizeFilter;
//TANG INAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA HIKING PAAAAAAAAAAAAAAAAAAAAa
public class MainUI extends JFrame
{
	private JPanel frameP, headerP, mainP, addRecipeP, addFormP;
	private JLabel headerBg, mainBg, searchTFL, searchB, exitB, addRecipeB, appetizerB, mainCourseB, dessertB, soupB, drinksB,
			addAppetizerB, addMainCourseB, addDessertB, addSoupB, addDrinksB, addFormBg, addFormBackB, addFormResetB,
			addFormSaveB;
	private JTextField searchTF, recipeNameTF;
	private JTextArea recipeDescTA, ingredientsTA, proceduresTA;
	private JScrollPane recipeDescSP, ingredientsSP, proceduresSP;
	private DefaultStyledDocument recipeDescDF, ingredientsDF, proceduresDF;
	private Font searchFont, formFont;

	private MainHandler mHandler;

	public MainUI()
	{
		setUndecorated(true);
		setSize(1000, 700);
		setPanel();
		setComponents();
		setComponentsBounds();
		addComponents();

		frameP.add(headerP);
		frameP.add(mainP);
		add(frameP);
		
		mHandler = new MainHandler();
		searchB.addMouseListener(mHandler);
		exitB.addMouseListener(mHandler);
		mainCourseB.addMouseListener(mHandler);
		appetizerB.addMouseListener(mHandler);
		dessertB.addMouseListener(mHandler);
		soupB.addMouseListener(mHandler);
		drinksB.addMouseListener(mHandler);
		mainBg.addMouseListener(mHandler);
		addRecipeB.addMouseListener(mHandler);
		addAppetizerB.addMouseListener(mHandler);
		addMainCourseB.addMouseListener(mHandler);
		addDessertB.addMouseListener(mHandler);
		addSoupB.addMouseListener(mHandler);
		addDrinksB.addMouseListener(mHandler);
		addFormBackB.addMouseListener(mHandler);
		addFormResetB.addMouseListener(mHandler);
		addFormSaveB.addMouseListener(mHandler);
		
		recipeNameTF.addKeyListener(mHandler);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);	
		repaint();
	}
	
	private class MainHandler implements MouseListener, KeyListener
	{
		public void mouseClicked(MouseEvent e) 
		{
		}
		public void mouseEntered(MouseEvent e) 
		{
			if(searchB==e.getSource())
				searchB.setIcon(new ImageIcon(getClass().getResource("SearchIcon2.png")));
			else if(exitB==e.getSource())
				exitB.setIcon(new ImageIcon(getClass().getResource("ExitButton2.png")));
			else if(mainCourseB==e.getSource())
				mainCourseB.setIcon(new ImageIcon(getClass().getResource("MainCourseButton2.png")));
			else if(appetizerB==e.getSource())
				appetizerB.setIcon(new ImageIcon(getClass().getResource("AppetizerButton2.png")));
			else if(dessertB==e.getSource())
				dessertB.setIcon(new ImageIcon(getClass().getResource("DessertButton2.png")));
			else if(soupB==e.getSource())
				soupB.setIcon(new ImageIcon(getClass().getResource("SoupButton2.png")));
			else if(drinksB==e.getSource())
				drinksB.setIcon(new ImageIcon(getClass().getResource("DrinksButton2.png")));
			else if(addAppetizerB==e.getSource())
				addAppetizerB.setIcon(new ImageIcon(getClass().getResource("AddAppetizer2.png")));
			else if(addMainCourseB==e.getSource())
				addMainCourseB.setIcon(new ImageIcon(getClass().getResource("AddMainCourse2.png")));
			else if(addDessertB==e.getSource())
				addDessertB.setIcon(new ImageIcon(getClass().getResource("AddDessert2.png")));
			else if(addSoupB==e.getSource())
				addSoupB.setIcon(new ImageIcon(getClass().getResource("AddSoup2.png")));
			else if(addDrinksB==e.getSource())
				addDrinksB.setIcon(new ImageIcon(getClass().getResource("AddDrinks2.png")));
			else if(addFormBackB==e.getSource())
				addFormBackB.setIcon(new ImageIcon(getClass().getResource("BackButton2.png")));
			else if(addFormResetB==e.getSource())
				addFormResetB.setIcon(new ImageIcon(getClass().getResource("ResetButton2.png")));
			else if(addFormSaveB==e.getSource())
				addFormSaveB.setIcon(new ImageIcon(getClass().getResource("SaveRecipeButton2.png")));
		}
		public void mouseExited(MouseEvent e) 
		{
			if(searchB==e.getSource())
				searchB.setIcon(new ImageIcon(getClass().getResource("SearchIcon.png")));
			else if(exitB==e.getSource())
				exitB.setIcon(new ImageIcon(getClass().getResource("ExitButton.png")));
			else if(mainCourseB==e.getSource())
				mainCourseB.setIcon(new ImageIcon(getClass().getResource("MainCourseButton.png")));
			else if(appetizerB==e.getSource())
				appetizerB.setIcon(new ImageIcon(getClass().getResource("AppetizerButton.png")));
			else if(dessertB==e.getSource())
				dessertB.setIcon(new ImageIcon(getClass().getResource("DessertButton.png")));
			else if(soupB==e.getSource())
				soupB.setIcon(new ImageIcon(getClass().getResource("SoupButton.png")));
			else if(drinksB==e.getSource())
				drinksB.setIcon(new ImageIcon(getClass().getResource("DrinksButton.png")));
			else if(addAppetizerB==e.getSource())
				addAppetizerB.setIcon(new ImageIcon(getClass().getResource("AddAppetizer.png")));
			else if(addMainCourseB==e.getSource())
				addMainCourseB.setIcon(new ImageIcon(getClass().getResource("AddMainCourse.png")));
			else if(addDessertB==e.getSource())
				addDessertB.setIcon(new ImageIcon(getClass().getResource("AddDessert.png")));
			else if(addSoupB==e.getSource())
				addSoupB.setIcon(new ImageIcon(getClass().getResource("AddSoup.png")));
			else if(addDrinksB==e.getSource())
				addDrinksB.setIcon(new ImageIcon(getClass().getResource("AddDrinks.png")));
			else if(addFormBackB==e.getSource())
				addFormBackB.setIcon(new ImageIcon(getClass().getResource("BackButton.png")));
			else if(addFormResetB==e.getSource())
				addFormResetB.setIcon(new ImageIcon(getClass().getResource("ResetButton.png")));
			else if(addFormSaveB==e.getSource())
				addFormSaveB.setIcon(new ImageIcon(getClass().getResource("SaveRecipeButton.png")));
		}
		public void mousePressed(MouseEvent e) 
		{
			if(exitB==e.getSource())
			{
				dispose();
			}
			else if(addRecipeB==e.getSource())
			{
				addRecipeP.remove(addRecipeB);
				addRecipeP.add(addAppetizerB);
				addRecipeP.add(addMainCourseB);
				addRecipeP.add(addDessertB);
				addRecipeP.add(addSoupB);
				addRecipeP.add(addDrinksB);
				addRecipeB.setIcon(new ImageIcon(getClass().getResource("AddButton2.png")));
				addRecipeP.add(addRecipeB);
				addRecipeB.setBounds(0, 0, 122, 227);
			}
			else if(mainBg==e.getSource())
			{
				addRecipeB.setIcon(new ImageIcon(getClass().getResource("AddButton.png")));
				addRecipeB.setBounds(3, 180, 114, 44);
				addRecipeP.remove(addAppetizerB);
				addRecipeP.remove(addMainCourseB);
				addRecipeP.remove(addDessertB);
				addRecipeP.remove(addSoupB);
				addRecipeP.remove(addDrinksB);
			}
			else if(addAppetizerB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
			else if(addMainCourseB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
			else if(addDessertB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
			else if(addSoupB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
			else if(addDrinksB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
			else if(addFormSaveB==e.getSource())
			{
				
				System.out.println(ingredientsTA.getText());
			}
			else if(addFormBackB==e.getSource())
			{
				addAppetizerB.setIcon(new ImageIcon(getClass().getResource("AddAppetizer.png")));
				addMainCourseB.setIcon(new ImageIcon(getClass().getResource("AddMainCourse.png")));
				addDessertB.setIcon(new ImageIcon(getClass().getResource("AddDessert.png")));
				addSoupB.setIcon(new ImageIcon(getClass().getResource("AddSoup.png")));
				addDrinksB.setIcon(new ImageIcon(getClass().getResource("AddDrinks.png")));
				addFormBackB.setIcon(new ImageIcon(getClass().getResource("BackButton.png")));
				addRecipeB.setIcon(new ImageIcon(getClass().getResource("AddButton.png")));
				addRecipeB.setBounds(3, 180, 114, 44);
				addRecipeP.remove(addAppetizerB);
				addRecipeP.remove(addMainCourseB);
				addRecipeP.remove(addDessertB);
				addRecipeP.remove(addSoupB);
				addRecipeP.remove(addDrinksB);
				frameP.remove(addFormP);
				frameP.add(mainP);
				repaint();
			}
			else if(addFormResetB==e.getSource())
			{
				recipeNameTF.setText("(Enter Recipe Name)");
				recipeDescTA.setText("(Enter Recipe Description)");
				ingredientsTA.setText("(Enter Ingredients)");
				proceduresTA.setText("(Enter Procedures)");
				repaint();
			}
		}
		public void mouseReleased(MouseEvent arg0) {
			
		}
		public void keyPressed(KeyEvent arg0) {
		}
		public void keyReleased(KeyEvent arg0) {
		}
		public void keyTyped(KeyEvent e)
		{	
			if(recipeNameTF.getText().length()>=50)
				e.consume();
		}
	}
	
	public void setPanel()
	{
		frameP = new JPanel();
		frameP.setLayout(null);
		frameP.setOpaque(false);
		frameP.setBounds(0, 0, 1000, 700);

		headerP = new JPanel();
		headerP.setLayout(null);
		headerP.setOpaque(false);
		headerP.setBounds(0, 0, 1000, 221);
		
		mainP = new JPanel();
		mainP.setLayout(null);
		mainP.setOpaque(false);
		mainP.setBounds(0, 221, 1000, 479);
		
		addRecipeP = new JPanel();
		addRecipeP.setLayout(null);
		addRecipeP.setOpaque(false);
		addRecipeP.setBounds(860, 240, 150, 250);
		
		addFormP = new JPanel();
		addFormP.setLayout(null);
		addFormP.setOpaque(false);
		addFormP.setBounds(0, 221, 1000, 479);
	}
	
	public void setComponents()
	{	
		//header components
		headerBg = new JLabel(new ImageIcon(getClass().getResource("HeaderBackground.png")));
		searchTFL = new JLabel(new ImageIcon(getClass().getResource("SearchRectangle.png")));
		searchB = new JLabel(new ImageIcon(getClass().getResource("SearchIcon.png")));
		searchFont = new Font("Century Gothic", Font.PLAIN, 30);
		searchTF = new JTextField(100);
		searchTF.setOpaque(false);
		searchTF.setBorder(null);
		searchTF.setFont(searchFont);
		searchTF.setForeground(Color.WHITE);
		exitB = new JLabel(new ImageIcon(getClass().getResource("ExitButton.png")));
		
		//main components
		mainBg = new JLabel(new ImageIcon(getClass().getResource("MainBg.png")));
		appetizerB = new JLabel(new ImageIcon(getClass().getResource("AppetizerButton.png")));
		mainCourseB = new JLabel(new ImageIcon(getClass().getResource("MainCourseButton.png")));
		dessertB = new JLabel(new ImageIcon(getClass().getResource("DessertButton.png")));
		soupB = new JLabel(new ImageIcon(getClass().getResource("SoupButton.png")));
		drinksB = new JLabel(new ImageIcon(getClass().getResource("DrinksButton.png")));
		addRecipeB = new JLabel(new ImageIcon(getClass().getResource("AddButton.png")));
		addAppetizerB = new JLabel(new ImageIcon(getClass().getResource("AddAppetizer.png")));
		addMainCourseB = new JLabel(new ImageIcon(getClass().getResource("AddMainCourse.png")));
		addDessertB = new JLabel(new ImageIcon(getClass().getResource("AddDessert.png")));
		addSoupB = new JLabel(new ImageIcon(getClass().getResource("AddSoup.png")));
		addDrinksB = new JLabel(new ImageIcon(getClass().getResource("AddDrinks.png")));
		
		//add recipe form components
		addFormBg = new JLabel(new ImageIcon(getClass().getResource("AddRecipeBg.png")));
		addFormBackB = new JLabel(new ImageIcon(getClass().getResource("BackButton.png")));
		addFormResetB = new JLabel(new ImageIcon(getClass().getResource("ResetButton.png")));
		addFormSaveB = new JLabel(new ImageIcon(getClass().getResource("SaveRecipeButton.png")));
		formFont = new Font("Century Gothic", Font.PLAIN, 15);
		//recipe text field
		recipeNameTF = new JTextField(50);
		recipeNameTF.setOpaque(false);
		recipeNameTF.setBorder(null);
		recipeNameTF.setFont(formFont);
		//recipe description text area
		recipeDescTA = new JTextArea();
		recipeDescTA.setOpaque(false);
		recipeDescTA.setFont(formFont);
		recipeDescTA.setLineWrap(true);
		recipeDescTA.setWrapStyleWord(true);
		recipeDescDF = new DefaultStyledDocument();
		recipeDescDF.setDocumentFilter(new DocumentSizeFilter(1000));
		recipeDescTA.setDocument(recipeDescDF);
		recipeDescSP = new JScrollPane(recipeDescTA);
		recipeDescSP.setOpaque(false);
		recipeDescSP.getViewport().setOpaque(false);
		recipeDescSP.setBorder(null);
		//ingredients text area
		ingredientsTA = new JTextArea();
		ingredientsTA.setOpaque(false);
		ingredientsTA.setFont(formFont);
		ingredientsTA.setLineWrap(true);
		ingredientsTA.setWrapStyleWord(true);
		ingredientsDF = new DefaultStyledDocument();
		ingredientsDF.setDocumentFilter(new DocumentSizeFilter(1000));
		ingredientsTA.setDocument(ingredientsDF);
		ingredientsSP = new JScrollPane(ingredientsTA);
		ingredientsSP.setOpaque(false);
		ingredientsSP.getViewport().setOpaque(false);
		ingredientsSP.setBorder(null);
		//procedures text area
		proceduresTA = new JTextArea();
		proceduresTA.setOpaque(false);
		proceduresTA.setFont(formFont);
		proceduresTA.setLineWrap(true);
		proceduresTA.setWrapStyleWord(true);
		proceduresDF = new DefaultStyledDocument();
		proceduresDF.setDocumentFilter(new DocumentSizeFilter(1000));
		proceduresTA.setDocument(proceduresDF);
		proceduresSP = new JScrollPane(proceduresTA);
		proceduresSP.setOpaque(false);
		proceduresSP.getViewport().setOpaque(false);
		proceduresSP.setBorder(null);
	}
	
	public void setComponentsBounds()
	{
		//header components bounds
		headerBg.setBounds(0, 0, 1000, 221);
		searchTFL.setBounds(327, 130, 393, 52);
		searchB.setBounds(680, 143, 20, 20);
		searchTF.setBounds(350, 135, 310, 38);
		exitB.setBounds(910, 18, 60, 60);
		
		//main components bounds
		mainBg.setBounds(0, 0, 1000, 479);
		appetizerB.setBounds(50, 40, 279, 184);
		mainCourseB.setBounds(360, 40, 279, 184);
		dessertB.setBounds(670, 40, 279, 184);
		soupB.setBounds(200, 254, 279, 184);
		drinksB.setBounds(510, 254, 279, 184);
		addRecipeB.setBounds(3, 180, 114, 44);
		addAppetizerB.setBounds(8, 10, 106, 32);
		addMainCourseB.setBounds(8, 42, 106, 32);
		addDessertB.setBounds(8, 74, 106, 32);
		addSoupB.setBounds(8, 106, 106, 32);
		addDrinksB.setBounds(8, 138, 106, 32);
		
		//add recipe form components bounds
		addFormBg.setBounds(0, 0, 1000, 479);
		addFormBackB.setBounds(620, 7, 111, 37);
		addFormResetB.setBounds(740, 7, 111, 37);
		addFormSaveB.setBounds(860, 7, 111, 37);
		recipeNameTF.setBounds(43, 272, 255, 38);
		recipeDescSP.setBounds(43, 340, 255, 120);
		ingredientsSP.setBounds(335, 80, 260, 380);
		proceduresSP.setBounds(630, 80, 335, 380);
	}

	public void addComponents()
	{
		//add header components
		headerP.add(searchTF);
		headerP.add(searchB);
		headerP.add(searchTFL);
		headerP.add(exitB);
		headerP.add(headerBg);
		
		//add main components
		mainP.add(appetizerB);
		mainP.add(mainCourseB);
		mainP.add(dessertB);
		mainP.add(soupB);
		mainP.add(drinksB);
		mainP.add(addRecipeP);
		addRecipeP.add(addRecipeB);
		mainP.add(mainBg);
		
		//add recipe form components bounds
		addFormP.add(addFormBackB);
		addFormP.add(addFormResetB);
		addFormP.add(addFormSaveB);
		addFormP.add(recipeNameTF);
		addFormP.add(recipeDescSP);
		addFormP.add(ingredientsSP);
		addFormP.add(proceduresSP);
		addFormP.add(addFormBg);
	}
	
	public static void main(String[] args) 
	{
		new MainUI();
	}

}
