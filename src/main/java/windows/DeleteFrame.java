package windows;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import database.DatabaseManager;
import main.BookMain;
import models.Book;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JPanel panel_1;
	private JButton btnPreview;
	private JLabel lblVisualize;
	private JButton btnDelete;
	private JMenuBar menuBar;
	private JMenu mnManage;
	private JMenuItem mnBack;
	private JMenuItem mnDelete;
	private Component horizontalStrut;
	private Component verticalStrut_1;
	private JLabel lblData;
	private JLabel lblNewLabel_6;
	private Component horizontalStrut_1;
	private JLabel lblConfirmation;
	private JLabel lblPageWarning;
	private Component horizontalStrut_2;
	private JLabel lblEmptyWarning;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public DeleteFrame () throws IOException 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/MainIcon.png"));
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
		DescriptionPanel.setLayout(new BorderLayout(0, 0));
		
		final JButton btnDeleteBook = new JButton("BORRAR LIBRO");		
		btnDeleteBook.setForeground(new Color(255, 255, 255));
		btnDeleteBook.setBackground(new Color(178, 34, 34));
		DescriptionPanel.add(btnDeleteBook, BorderLayout.NORTH);
		
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
		
		JMenuItem mnDelete = new JMenuItem("VOLVER A LA ESTANTERIA");
		mnDelete.addActionListener(new java.awt.event.ActionListener()
		{
		    public void actionPerformed(java.awt.event.ActionEvent evt)
		    {
		       try {
				BookMain.openMain();
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
	           		DescriptionPanel.add(btnDeleteBook, BorderLayout.NORTH);
					DescriptionPanel.add(Description, BorderLayout.CENTER);
					
					btnDeleteBook.addActionListener(new ActionListener() {
	        			public void actionPerformed(ActionEvent e) {
	        				DatabaseManager.deleteBook(book.getBookName(), book.getAuthorName());
	        			}
	        		});
					DescriptionPanel.setVisible(true);
  
	           		DescriptionPanel.revalidate();
	           		DescriptionPanel.repaint();
				   
                }
            });
			
		}
	}
	
	public static void openDelete() throws IOException 
	{
		DeleteFrame deleteFrame = new DeleteFrame();
		deleteFrame.setSize(860, 520);
		deleteFrame.setLocationRelativeTo(null);
		deleteFrame.setVisible(true);
	}

}
