package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Recette;

import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JList;

public class Frame extends JFrame {

	private JPanel contentPane;
	JPanel panel_aff;
	private JPanel panel_aff_1;
	JPanel panel_option, panel_option_affichage, panel_option_insertion;
	
	protected Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	protected int height = (int)dimension.getHeight();
	protected int width  = (int)dimension.getWidth();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frame() 
	{
		panel_aff = new JPanel();
		panel_option = new JPanel();
		contentPane = new JPanel();

		System.out.println(height);
		System.out.println(width);

		setTitle("Livre de cuisine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_option.setBounds(12, 13, 352, 1007);
		contentPane.add(panel_option);
		
		panel_aff_1 = new JPanel();
		panel_aff_1.setBounds(376, 13, 1514, 1007);
		contentPane.add(panel_aff_1);
		
		JList list = new JList();
		panel_aff_1.add(list);
		
		afficherOption();
	}
	
/*private void afficherRecettes() 
	{
		panel_aff_1.removeAll();

		
		
		/*
		ArrayList<Recette> recettes = selectRecettes();
		for (Recette recette : recettes ) {
			JPanel ligne = new JPanel();
			ligne.setLayout(new FlowLayout());
			JLabel nom = new JLabel(recette.getName());
			JLabel resume = new JLabel(recette.getResume());
			ligne.add(nom);
			ligne.add(resume);
			panel_aff.add(ligne);
			JButton delete = new JButton("Supprimer");
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
	}*/
	
	private void afficherOption()
	{
		panel_option.removeAll();

		panel_option_affichage = new JPanel();
		panel_option_affichage.setBounds(panel_option.getBounds());
		panel_option.add(panel_option_affichage);
		
		panel_option_affichage.setLayout(new MigLayout("", "[335.00px]", "[200px][200px][200px][200px][200px]"));
		
		JCheckBox rdbtnEntre = new JCheckBox("Entré");
		panel_option_affichage.add(rdbtnEntre, "cell 0 0,alignx center,aligny center");
		rdbtnEntre.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				
				
			}
		});
		
		JCheckBox rdbtnPlat = new JCheckBox("plat");
		panel_option_affichage.add(rdbtnPlat, "cell 0 1,alignx center,aligny center");
		rdbtnPlat.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				//System.out.println("ici");
				
			}
		});
		
		JCheckBox rdbtnDessert = new JCheckBox("Dessert");
		panel_option_affichage.add(rdbtnDessert, "cell 0 2,alignx center,aligny center");
		rdbtnDessert.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				//System.out.println("la");
				
			}
		});
		
		JCheckBox rdbtnBoison = new JCheckBox("Boison");
		panel_option_affichage.add(rdbtnBoison, "cell 0 3,alignx center,aligny center");
		rdbtnBoison.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				//System.out.println("la");
				
			}
		});
		
		JButton insertion = new JButton("insertion");
		insertion.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel_option_affichage.setVisible(false);
				afficherOptionsInsertion();
			}
		});
		panel_option_affichage.add(insertion, "cell 0 4,alignx center,aligny center");
		
		
		
	}
	
	private void afficherInsertion() 
	{
		panel_aff_1.removeAll();
	
	}
	
	private void afficherOptionsInsertion() 
	{
		panel_option.removeAll();
		
		panel_option_insertion = new JPanel();
		panel_option_insertion.setBounds(panel_option.getBounds());
		panel_option.add(panel_option_insertion);
		panel_option_insertion.setLayout(new MigLayout("", "[335.00px]", "[250px][250px][250px][250px]"));
	
		JCheckBox rdbtnInsertionRecette = new JCheckBox("Insertion recettes");
		panel_option_insertion.add(rdbtnInsertionRecette, "cell 0 0,alignx center,aligny center");
		rdbtnInsertionRecette.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				//System.out.println("la");
			}
		});
		
		JCheckBox rdbtnInsertionEtape = new JCheckBox("Insertion étape");
		panel_option_insertion.add(rdbtnInsertionEtape, "cell 0 1,alignx center,aligny center");
		rdbtnInsertionEtape.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				//System.out.println("la");
			}
		});
		
		JCheckBox rdbtnInsertionIngredient = new JCheckBox("Insertion ingrédient");
		panel_option_insertion.add(rdbtnInsertionIngredient, "cell 0 2,alignx center,aligny center");
		rdbtnInsertionIngredient.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				//System.out.println("la");
			}
		});
		
		JButton precedent = new JButton("Précedent");
		panel_option_insertion.add(precedent, "cell 0 3,alignx center,aligny center");
		precedent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel_option_insertion.setVisible(false);
				afficherOption();
				//for (int i = 0; i < panel_option.getComponentCount(); i++) {
				// panel_option.remove(i);
				//}
				//TODO amélioration vidage mémoire 
				//dispose();
				//Frame frame = new Frame();
				//frame.setVisible(true);
			}
		});
	}

}
