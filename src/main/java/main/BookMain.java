package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.DatabaseManager;
import models.Book;
import windows.AddFrame;
import windows.BookPanel;
import windows.DeleteFrame;
import windows.DescriptionPanel;

import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import net.miginfocom.swing.MigLayout;



/**
 * @author Rubén García
 * 
 * Clase que contiene la ventana encargada de mostrar los libros existentes.
 *
 */

public class BookMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMain frame = new BookMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Constructor de la clase BookMain, se encarga de gestionar la ubicacion de los objetos en pantalla.
	 * 
	 * @throws IOException 
	 */
	public BookMain() throws IOException {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("./images/MainIcon.png"));

		setIconImage(Toolkit.getDefaultToolkit().getImage("./src/main/resources/MainIcon.png"));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 520);
		setTitle("BookShelf");		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBorder(null);
		
		DatabaseManager.initBD();
		
		ArrayList<Book> ArrayBook = new ArrayList<Book>();
		ArrayBook = DatabaseManager.getBooks();
			
		
		JScrollPane scrollPane = new JScrollPane(LeftPanel);
		LeftPanel.setLayout(new MigLayout("wrap 4", "", "[]"));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		final JPanel DescriptionPanel = new JPanel();
		DescriptionPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		DescriptionPanel.setBackground(Color.WHITE);
		DescriptionPanel.setMaximumSize(new Dimension(25,1000));
		contentPane.add(DescriptionPanel, BorderLayout.EAST);
		
		//JLabel lblNewLabel_1 = new JLabel("New label");
		//DescriptionPanel.add(lblNewLabel_1);
		
		//DescriptionPanel Description = new DescriptionPanel(Libro1);
		//DescriptionPanel.add(Description);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnManage = new JMenu("GESTIONAR LIBROS");
		menuBar.add(mnManage);
		
		JMenuItem mnAdd = new JMenuItem("AÑADIR UN LIBRO");
		mnAdd.addActionListener(new java.awt.event.ActionListener() 
		{
		    public void actionPerformed(java.awt.event.ActionEvent evt) 
		    {
		       AddFrame.openAdd();
		       dispose();
		    }
		});
		mnManage.add(mnAdd);
		
		JMenuItem mnDelete = new JMenuItem("BORRAR UN LIBRO");
		mnDelete.addActionListener(new java.awt.event.ActionListener()
		{
		    public void actionPerformed(java.awt.event.ActionEvent evt)
		    {
		       try {
				DeleteFrame.openDelete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       dispose();
		    }
		});
		mnManage.add(mnDelete);
		
		DescriptionPanel.setVisible(false);

		for (final Book book : ArrayBook) 
		{
			BookPanel books = new BookPanel(book);
			LeftPanel.add(books);
			
			books.addMouseListener(new MouseAdapter() 
			{
                @Override
                public void mouseClicked(MouseEvent e) 
                {
	                System.out.println(book.getCover());
	           		DescriptionPanel Description = new DescriptionPanel(book);
	           		
	           		DescriptionPanel.removeAll();
					DescriptionPanel.add(Description);
				
					DescriptionPanel.setVisible(true);
  
	           		DescriptionPanel.revalidate();
	           		DescriptionPanel.repaint();
				   
                }
            });
			
		}
	}
	
	/**
	 * Metodo para lanzar el constructor de la pantalla principal y hacerla visible
	 *
	 * @throws IOException 
	 * 
	 */
	public static void openMain() throws IOException {
		BookMain bookMain = new BookMain();
		bookMain.setSize(860, 520);
		bookMain.setLocationRelativeTo(null);
		bookMain.setVisible(true);
	
	}
	
}
