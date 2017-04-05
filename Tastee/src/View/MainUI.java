package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultStyledDocument;

import control.DocumentSizeFilter;
import control.RecipeDA;
import model.Recipe;

public class MainUI extends JFrame
{
	private JPanel frameP, headerP, mainP, addRecipeP, addFormP, viewRecipeP;
	private JLabel headerBg, mainBg, searchTFL, searchB, exitB, addRecipeB, appetizerB, mainCourseB, dessertB, soupB, drinksB,
			addAppetizerB, addMainCourseB, addDessertB, addSoupB, addDrinksB, addFormBg, addFormBackB, addFormResetB,
			addFormSaveB, addRecipeTypeL, viewRecipeBg, viewRecipeTypeL, viewRecipeBackB, viewRecipeNextB, viewRecipePrevB,
			viewRecipeDeleteB, viewRecipeEditB, viewRecipeSaveB;
	private JTextField searchTF, addRecipeNameTF;
	private JTextArea addRecipeDescTA, addIngredientsTA, addProceduresTA, viewRecipeNameTA, viewRecipeDescTA, viewIngredientsTA, 
			viewProceduresTA;
	private JScrollPane addRecipeDescSP, addIngredientsSP, addProceduresSP, viewRecipeNameSP, viewRecipeDescSP, viewIngredientsSP,
			viewProceduresSP;
	private DefaultStyledDocument addRecipeDescDF, addIngredientsDF, addProceduresDF, viewRecipeNameDF, viewRecipeDescDF,
			viewIngredientsDF, viewProceduresDF;
	private Font searchFont, formFont, recipeTypeFont, viewRecipeNameFont, viewRecipeFont;

	private Recipe nextRecipe, previousRecipe, currentRecipe;
	private RecipeDA recipeDA;
	private Connection connection;
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
		addRecipeNameTF.addMouseListener(mHandler);
		addRecipeDescTA.addMouseListener(mHandler);
		addIngredientsTA.addMouseListener(mHandler);
		addProceduresTA.addMouseListener(mHandler);
		viewRecipeBackB.addMouseListener(mHandler);
		viewRecipeDeleteB.addMouseListener(mHandler);
		viewRecipeEditB.addMouseListener(mHandler);
		viewRecipeNextB.addMouseListener(mHandler);
		viewRecipePrevB.addMouseListener(mHandler);
		
		addRecipeNameTF.addKeyListener(mHandler);

		setLocationRelativeTo(null);
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
			else if(viewRecipeBackB==e.getSource())
				viewRecipeBackB.setIcon(new ImageIcon(getClass().getResource("BackButton2.png")));
			else if(viewRecipeDeleteB==e.getSource())
				viewRecipeDeleteB.setIcon(new ImageIcon(getClass().getResource("DeleteButton2.png")));
			else if(viewRecipeEditB==e.getSource())
				viewRecipeEditB.setIcon(new ImageIcon(getClass().getResource("EditButton2.png")));
			else if(viewRecipeNextB==e.getSource())
				viewRecipeNextB.setIcon(new ImageIcon(getClass().getResource("NextButton2.png")));
			else if(viewRecipePrevB==e.getSource())
				viewRecipePrevB.setIcon(new ImageIcon(getClass().getResource("PreviousButton2.png")));
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
			else if(viewRecipeBackB==e.getSource())
				viewRecipeBackB.setIcon(new ImageIcon(getClass().getResource("BackButton.png")));
			else if(viewRecipeDeleteB==e.getSource())
				viewRecipeDeleteB.setIcon(new ImageIcon(getClass().getResource("DeleteButton.png")));
			else if(viewRecipeEditB==e.getSource())
				viewRecipeEditB.setIcon(new ImageIcon(getClass().getResource("EditButton.png")));
			else if(viewRecipeNextB==e.getSource())
				viewRecipeNextB.setIcon(new ImageIcon(getClass().getResource("NextButton.png")));
			else if(viewRecipePrevB==e.getSource())
				viewRecipePrevB.setIcon(new ImageIcon(getClass().getResource("PreviousButton.png")));
		}
		public void mousePressed(MouseEvent e) 
		{
			Recipe recipe = new Recipe();
			
			if(exitB==e.getSource())
			{
				dispose();
			}
			else if(appetizerB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(viewRecipeP);
				viewRecipeTypeL.setText("APPETIZER");
				viewRecipeTypeL.setBounds(440, 3, 300, 50);
				getRecipe("1");
				repaint();
			}
			else if(mainCourseB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(viewRecipeP);
				viewRecipeTypeL.setText("MAIN COURSE");
				viewRecipeTypeL.setBounds(420, 3, 300, 50);
				getRecipe("2");
				repaint();
			}
			else if(dessertB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(viewRecipeP);
				viewRecipeTypeL.setText("DESSERT");
				viewRecipeTypeL.setBounds(460, 3, 300, 50);
				getRecipe("3");
				repaint();
			}
			else if(soupB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(viewRecipeP);
				viewRecipeTypeL.setText("SOUP");
				viewRecipeTypeL.setBounds(470, 3, 300, 50);
				getRecipe("4");
				repaint();
			}
			else if(drinksB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(viewRecipeP);
				viewRecipeTypeL.setText("DRINKS");
				viewRecipeTypeL.setBounds(465, 3, 300, 50);
				getRecipe("5");
				repaint();
			}
			else if(viewRecipeNextB==e.getSource())
			{
				if(viewRecipeTypeL.getText().equals("APPETIZER"))
					recipe.setRecipeType("1");
				else if(viewRecipeTypeL.getText().equals("MAIN COURSE"))
					recipe.setRecipeType("2");
				else if(viewRecipeTypeL.getText().equals("DESSERT"))
					recipe.setRecipeType("3");
				else if(viewRecipeTypeL.getText().equals("SOUP"))
					recipe.setRecipeType("4");
				else if(viewRecipeTypeL.getText().equals("DRINKS"))
					recipe.setRecipeType("5");
				
				getNextRecipe(recipe.getRecipeType());
			}
			else if(viewRecipePrevB==e.getSource())
			{
				if(viewRecipeTypeL.getText().equals("APPETIZER"))
					recipe.setRecipeType("1");
				else if(viewRecipeTypeL.getText().equals("MAIN COURSE"))
					recipe.setRecipeType("2");
				else if(viewRecipeTypeL.getText().equals("DESSERT"))
					recipe.setRecipeType("3");
				else if(viewRecipeTypeL.getText().equals("SOUP"))
					recipe.setRecipeType("4");
				else if(viewRecipeTypeL.getText().equals("DRINKS"))
					recipe.setRecipeType("5");
				
				getPreviousRecipe(recipe.getRecipeType());
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
				repaint();
			}
			else if(addAppetizerB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				addRecipeTypeL.setText("APPETIZER");
				addRecipeTypeL.setBounds(440, 3, 300, 50);
				addRecipeNameTF.setText("(Enter Recipe Name)");
				initializeTextArea();
				repaint();
			}
			else if(addMainCourseB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				addRecipeTypeL.setText("MAIN COURSE");
				addRecipeTypeL.setBounds(420, 3, 300, 50);
				initializeTextArea();
				repaint();
			}
			else if(addDessertB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				addRecipeTypeL.setText("DESSERT");
				addRecipeTypeL.setBounds(460, 3, 300, 50);
				initializeTextArea();
				repaint();
			}
			else if(addSoupB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				addRecipeTypeL.setText("SOUP");
				addRecipeTypeL.setBounds(470, 3, 300, 50);
				initializeTextArea();
				repaint();
			}
			else if(addDrinksB==e.getSource())
			{
				frameP.remove(mainP);
				frameP.add(addFormP);
				addRecipeTypeL.setText("DRINKS");
				addRecipeTypeL.setBounds(465, 3, 300, 50);
				initializeTextArea();
				repaint();
			}
			else if(addFormSaveB==e.getSource())
			{
				if(addRecipeTypeL.getText().equals("APPETIZER"))
					recipe.setRecipeType("1");
				else if(addRecipeTypeL.getText().equals("MAIN COURSE"))
					recipe.setRecipeType("2");
				else if(addRecipeTypeL.getText().equals("DESSERT"))
					recipe.setRecipeType("3");
				else if(addRecipeTypeL.getText().equals("SOUP"))
					recipe.setRecipeType("4");
				else if(addRecipeTypeL.getText().equals("DRINKS"))
					recipe.setRecipeType("5");
				
				if(validateRecipe(recipe.getRecipeType())==true)
				{
					addFormSaveB.setIcon(new ImageIcon(getClass().getResource("SaveRecipeButton.png")));
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
					
					JOptionPane.showMessageDialog(null, "Recipe is added.", 
							"SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if(viewRecipeBackB==e.getSource())
			{
				viewRecipeNameTA.setText("");
				viewRecipeDescTA.setText("");
				viewIngredientsTA.setText("");
				viewProceduresTA.setText("");
				appetizerB.setIcon(new ImageIcon(getClass().getResource("AppetizerButton.png")));
				mainCourseB.setIcon(new ImageIcon(getClass().getResource("MainCourseButton.png")));
				dessertB.setIcon(new ImageIcon(getClass().getResource("DessertButton.png")));
				soupB.setIcon(new ImageIcon(getClass().getResource("SoupButton.png")));
				drinksB.setIcon(new ImageIcon(getClass().getResource("DrinksButton.png")));
				addAppetizerB.setIcon(new ImageIcon(getClass().getResource("AddAppetizer.png")));
				addMainCourseB.setIcon(new ImageIcon(getClass().getResource("AddMainCourse.png")));
				addDessertB.setIcon(new ImageIcon(getClass().getResource("AddDessert.png")));
				addSoupB.setIcon(new ImageIcon(getClass().getResource("AddSoup.png")));
				addDrinksB.setIcon(new ImageIcon(getClass().getResource("AddDrinks.png")));
				viewRecipeBackB.setIcon(new ImageIcon(getClass().getResource("BackButton.png")));
				addRecipeB.setIcon(new ImageIcon(getClass().getResource("AddButton.png")));
				addRecipeB.setBounds(3, 180, 114, 44);
				addRecipeP.remove(addAppetizerB);
				addRecipeP.remove(addMainCourseB);
				addRecipeP.remove(addDessertB);
				addRecipeP.remove(addSoupB);
				addRecipeP.remove(addDrinksB);
				frameP.remove(viewRecipeP);
				frameP.add(mainP);
				repaint();
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
				initializeTextArea();
				repaint();
			}
			else if(addRecipeNameTF==e.getSource())
			{
				if(addRecipeNameTF.getText().equals("(Enter Recipe Name)"))
					addRecipeNameTF.setText("");
			}
			else if(addRecipeDescTA==e.getSource())
			{
				if(addRecipeDescTA.getText().equals("(Enter Recipe Description)"))
					addRecipeDescTA.setText("");
			}
			else if(addIngredientsTA==e.getSource())
			{
				if(addIngredientsTA.getText().equals("(Enter Ingredients)"))
					addIngredientsTA.setText("");
			}
			else if(addProceduresTA==e.getSource())
			{
				if(addProceduresTA.getText().equals("(Enter Procedures)"))
					addProceduresTA.setText("");
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
			if(addRecipeNameTF.getText().length()>=50)
				e.consume();
		}
	}
	
	private void getRecipe(String recType)
	{
		currentRecipe = new Recipe();
		recipeDA = new RecipeDA(getConnection());
		List<Recipe> recipeList = recipeDA.getList();
		for(Recipe r : recipeList)
		{
			if(r.getRecipeType().equals(recType))
			{
				currentRecipe.setRecipeNo(r.getRecipeNo());
				viewRecipeNameTA.setText(r.getRecipeName());
				viewRecipeDescTA.setText(r.getRecipeDesc());
				viewIngredientsTA.setText(r.getIngredients());
				viewProceduresTA.setText(r.getProcedures());
				break;
			}
		}
	}
	
	private void getNextRecipe(String recType)
	{
		int a = Integer.parseInt(currentRecipe.getRecipeNo());
		nextRecipe = new Recipe();
		recipeDA = new RecipeDA(getConnection());
		List<Recipe> recipeList = recipeDA.getList();
		for(Recipe r : recipeList)
		{
			nextRecipe.setRecipeNo(r.getRecipeNo());
			if(r.getRecipeType().equals(recType))
			{
				int b = Integer.parseInt(nextRecipe.getRecipeNo());
				if(b>a)
				{
					currentRecipe.setRecipeNo(r.getRecipeNo());
					viewRecipeNameTA.setText(r.getRecipeName());
					viewRecipeDescTA.setText(r.getRecipeDesc());
					viewIngredientsTA.setText(r.getIngredients());
					viewProceduresTA.setText(r.getProcedures());
					break;
				}
			}
		}
	}
	
	private void getPreviousRecipe(String recType)
	{
		int a = Integer.parseInt(currentRecipe.getRecipeNo());
		previousRecipe = new Recipe();
		recipeDA = new RecipeDA(getConnection());
		List<Recipe> recipeList = recipeDA.getList();	
		for(Recipe r : recipeList)
		{
			previousRecipe.setRecipeNo(String.valueOf(recipeList.size()));
			int b = Integer.parseInt(previousRecipe.getRecipeNo());
			b--;
			if(r.getRecipeType().equals(recType))
			{
				{
					currentRecipe.setRecipeNo(r.getRecipeNo());
					viewRecipeNameTA.setText(r.getRecipeName());
					viewRecipeDescTA.setText(r.getRecipeDesc());
					viewIngredientsTA.setText(r.getIngredients());
					viewProceduresTA.setText(r.getProcedures());
					break;
				}
			}
		}
	}
	
	private boolean validateRecipe(String recType)
	{
		boolean result = false;
		Recipe recipe = new Recipe();
		recipe.setRecipeType(recType);
		recipe.setRecipeName(addRecipeNameTF.getText());
		
		recipeDA = new RecipeDA(getConnection());
		
		
		if((addRecipeNameTF.getText().equals("")) || (addRecipeNameTF.getText().contains("Enter Reci")))
			JOptionPane.showMessageDialog(null, "Recipe name can't be empty.\nPlease enter a new Recipe Name.", 
					"RECIPE NAME ERROR", JOptionPane.INFORMATION_MESSAGE);

		else if(addRecipeNameTF.getText().equals(recipeDA.validateRecipeName(recipe).getRecipeName()))
			JOptionPane.showMessageDialog(null, "Recipe name can't be duplicated.\nPlease enter a new Recipe Name.", 
					"RECIPE NAME ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			recipe.setRecipeName(addRecipeNameTF.getText());
		
		if((addRecipeDescTA.getText().equals("")) || (addRecipeDescTA.getText().contains("Enter Reci")))
		{
			JOptionPane.showMessageDialog(null, "Recipe description can't be empty.\nPlease enter a Recipe Description.", 
					"RECIPE DESCRIPTION ERROR", JOptionPane.INFORMATION_MESSAGE);
			result = false;
		}
		else
			recipe.setRecipeDesc(addRecipeDescTA.getText());
		
		if((addIngredientsTA.getText().equals("")) || (addIngredientsTA.getText().contains("Enter Ingr")))
			JOptionPane.showMessageDialog(null, "Ingredients can't be empty.\nPlease enter Ingredients.", 
					"INGREDIENTS ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			recipe.setIngredients(addIngredientsTA.getText());
		
		if((addProceduresTA.getText().equals("")) || (addProceduresTA.getText().contains("Enter Proc")))
			JOptionPane.showMessageDialog(null, "Procedures can't be empty.\nPlease enter Procedures.", 
					"PROCEDURES ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			recipe.setProcedures(addProceduresTA.getText());
		
		try
		{
			if(!(recipe.getRecipeName().isEmpty()) && !(recipe.getRecipeDesc().isEmpty()))
			{
				if(!(recipe.getIngredients().isEmpty()) && !(recipe.getProcedures().isEmpty()))
				{
					recipeDA.addRecipe(recipe);
					result = true;
				}
			}
		}
		catch(NullPointerException e){
		}
		
		return result;
	}
	
	
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection = DriverManager.getConnection("jdbc:db2://localhost:50000/tastee","Jax Garcia", "Jacks9069083");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	
	private void initializeTextArea()
	{
		addRecipeNameTF.setText("(Enter Recipe Name)");
		addRecipeDescTA.setText("(Enter Recipe Description)");
		addIngredientsTA.setText("(Enter Ingredients)");
		addProceduresTA.setText("(Enter Procedures)");
	}
	
	private void setPanel()
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
		
		viewRecipeP = new JPanel();
		viewRecipeP.setLayout(null);
		viewRecipeP.setOpaque(false);
		viewRecipeP.setBounds(0, 221, 1000, 479);
	}
	
	private void setComponents()
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
		addRecipeTypeL = new JLabel("");
		recipeTypeFont = new Font("CF Second Son PERSONAL", Font.PLAIN, 30);
		addRecipeTypeL.setFont(recipeTypeFont);
		//add recipe name text field
		addRecipeNameTF = new JTextField(50);
		addRecipeNameTF.setOpaque(false);
		addRecipeNameTF.setBorder(null);
		addRecipeNameTF.setFont(formFont);
		//add recipe description text area
		addRecipeDescTA = new JTextArea("");
		addRecipeDescTA.setOpaque(false);
		addRecipeDescTA.setFont(formFont);
		addRecipeDescTA.setLineWrap(true);
		addRecipeDescTA.setWrapStyleWord(true);
		addRecipeDescDF = new DefaultStyledDocument();
		addRecipeDescDF.setDocumentFilter(new DocumentSizeFilter(500));
		addRecipeDescTA.setDocument(addRecipeDescDF);
		addRecipeDescSP = new JScrollPane(addRecipeDescTA);
		addRecipeDescSP.setOpaque(false);
		addRecipeDescSP.getViewport().setOpaque(false);
		addRecipeDescSP.setBorder(null);
		//add ingredients text area
		addIngredientsTA = new JTextArea("");
		addIngredientsTA.setOpaque(false);
		addIngredientsTA.setFont(formFont);
		addIngredientsTA.setLineWrap(true);
		addIngredientsTA.setWrapStyleWord(true);
		addIngredientsDF = new DefaultStyledDocument();
		addIngredientsDF.setDocumentFilter(new DocumentSizeFilter(1000));
		addIngredientsTA.setDocument(addIngredientsDF);
		addIngredientsSP = new JScrollPane(addIngredientsTA);
		addIngredientsSP.setOpaque(false);
		addIngredientsSP.getViewport().setOpaque(false);
		addIngredientsSP.setBorder(null);
		//add procedures text area
		addProceduresTA = new JTextArea("");
		addProceduresTA.setOpaque(false);
		addProceduresTA.setFont(formFont);
		addProceduresTA.setLineWrap(true);
		addProceduresTA.setWrapStyleWord(true);
		addProceduresDF = new DefaultStyledDocument();
		addProceduresDF.setDocumentFilter(new DocumentSizeFilter(2000));
		addProceduresTA.setDocument(addProceduresDF);
		addProceduresSP = new JScrollPane(addProceduresTA);
		addProceduresSP.setOpaque(false);
		addProceduresSP.getViewport().setOpaque(false);
		addProceduresSP.setBorder(null);
		
		//view recipe components
		viewRecipeBg = new JLabel(new ImageIcon(getClass().getResource("ViewRecipeBg.png")));
		viewRecipeBackB = new JLabel(new ImageIcon(getClass().getResource("BackButton.png")));
		viewRecipeEditB = new JLabel(new ImageIcon(getClass().getResource("EditButton.png")));
		viewRecipeDeleteB  = new JLabel(new ImageIcon(getClass().getResource("DeleteButton.png")));
		viewRecipeNextB = new JLabel(new ImageIcon(getClass().getResource("NextButton.png")));
		viewRecipePrevB = new JLabel(new ImageIcon(getClass().getResource("PreviousButton.png")));
		viewRecipeDeleteB = new JLabel(new ImageIcon(getClass().getResource("DeleteButton.png")));
		viewRecipeNameFont = new Font("CF Second Son PERSONAL", Font.PLAIN, 30);
		viewRecipeFont = new Font("CF Second Son PERSONAL", Font.PLAIN, 15);
		viewRecipeTypeL = new JLabel("");
		recipeTypeFont = new Font("CF Second Son PERSONAL", Font.PLAIN, 30);
		viewRecipeTypeL.setFont(recipeTypeFont);
		//view recipe name text area
		viewRecipeNameTA = new JTextArea("");
		viewRecipeNameTA.setOpaque(false);
		viewRecipeNameTA.setFont(viewRecipeNameFont);
		viewRecipeNameTA.setLineWrap(true);
		viewRecipeNameTA.setWrapStyleWord(true);
		viewRecipeNameTA.setEditable(false);
		viewRecipeNameDF = new DefaultStyledDocument();
		viewRecipeNameDF.setDocumentFilter(new DocumentSizeFilter(50));
		viewRecipeNameSP = new JScrollPane(viewRecipeNameTA);
		viewRecipeNameSP.setOpaque(false);
		viewRecipeNameSP.getViewport().setOpaque(false);
		viewRecipeNameSP.setBorder(null);
		//view recipe description text area
		viewRecipeDescTA = new JTextArea("");
		viewRecipeDescTA.setOpaque(false);
		viewRecipeDescTA.setFont(viewRecipeFont);
		viewRecipeDescTA.setLineWrap(true);
		viewRecipeDescTA.setWrapStyleWord(true);
		viewRecipeDescTA.setEditable(false);
		viewRecipeDescDF = new DefaultStyledDocument();
		viewRecipeDescDF.setDocumentFilter(new DocumentSizeFilter(500));
		viewRecipeDescSP = new JScrollPane(viewRecipeDescTA);
		viewRecipeDescSP.setOpaque(false);
		viewRecipeDescSP.getViewport().setOpaque(false);
		viewRecipeDescSP.setBorder(null);
		//view recipe ingredients text area
		viewIngredientsTA = new JTextArea("");
		viewIngredientsTA.setOpaque(false);
		viewIngredientsTA.setFont(viewRecipeFont);
		viewIngredientsTA.setLineWrap(true);
		viewIngredientsTA.setWrapStyleWord(true);
		viewIngredientsTA.setEditable(false);
		viewIngredientsDF = new DefaultStyledDocument();
		viewIngredientsDF.setDocumentFilter(new DocumentSizeFilter(1000));
		viewIngredientsSP = new JScrollPane(viewIngredientsTA);
		viewIngredientsSP.setOpaque(false);
		viewIngredientsSP.getViewport().setOpaque(false);
		viewIngredientsSP.setBorder(null);
		//view recipe procedures text area
		viewProceduresTA = new JTextArea("");
		viewProceduresTA.setOpaque(false);
		viewProceduresTA.setFont(viewRecipeFont);
		viewProceduresTA.setLineWrap(true);
		viewProceduresTA.setWrapStyleWord(true);
		viewProceduresTA.setEditable(false);
		viewProceduresDF = new DefaultStyledDocument();
		viewProceduresDF.setDocumentFilter(new DocumentSizeFilter(2000));
		viewProceduresSP = new JScrollPane(viewProceduresTA);
		viewProceduresSP.setOpaque(false);
		viewProceduresSP.getViewport().setOpaque(false);
		viewProceduresSP.setBorder(null);
	}
	
	private void setComponentsBounds()
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
		addFormBackB.setBounds(27, 7, 88, 35);
		addFormResetB.setBounds(805, 7, 88, 35);
		addFormSaveB.setBounds(890, 7, 88, 35);
		addRecipeNameTF.setBounds(43, 272, 255, 38);
		addRecipeDescSP.setBounds(43, 340, 255, 120);
		addIngredientsSP.setBounds(335, 80, 260, 380);
		addProceduresSP.setBounds(630, 80, 335, 380);
		
		//view recipe components bounds
		viewRecipeBg.setBounds(0, 0, 1000, 479);
		viewRecipeBackB.setBounds(27, 7, 88, 35);
		viewRecipePrevB.setBounds(112, 7, 88, 35);
		viewRecipeNextB.setBounds(197, 7, 88, 35);
		viewRecipeDeleteB.setBounds(805, 7, 88, 35);
		viewRecipeEditB.setBounds(890, 7, 88, 35);
		viewRecipeNameSP.setBounds(40, 253, 210, 72);
		viewRecipeDescSP.setBounds(40, 333, 210, 135);
		viewIngredientsSP.setBounds(270, 80, 246, 387);
		viewProceduresSP.setBounds(570, 80, 403, 387);
	}

	private void addComponents()
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
		
		//add recipe form components
		addFormP.add(addRecipeTypeL);
		addFormP.add(addFormBackB);
		addFormP.add(addFormResetB);
		addFormP.add(addFormSaveB);
		addFormP.add(addRecipeNameTF);
		addFormP.add(addRecipeDescSP);
		addFormP.add(addIngredientsSP);
		addFormP.add(addProceduresSP);
		addFormP.add(addFormBg);
		
		//add view recipe components
		viewRecipeP.add(viewRecipeTypeL);
		viewRecipeP.add(viewRecipeBackB);
		viewRecipeP.add(viewRecipeDeleteB);
		viewRecipeP.add(viewRecipeEditB);
		viewRecipeP.add(viewRecipeNextB);
		viewRecipeP.add(viewRecipePrevB);
		viewRecipeP.add(viewRecipeNameSP);
		viewRecipeP.add(viewRecipeDescSP);
		viewRecipeP.add(viewIngredientsSP);
		viewRecipeP.add(viewProceduresSP);
		viewRecipeP.add(viewRecipeBg);
	}
	
	public static void main(String[] args) 
	{
		new MainUI();
	}
}
