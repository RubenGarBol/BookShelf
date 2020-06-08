package windows;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import database.DatabaseManager;
import main.BookMain;
import models.Book;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JPanel pnlRight;
	private JButton btnPreview;
	private JLabel lblVisualize;
	private JButton btnAdd;
	private JMenuBar menuBar;
	private JMenu mnManage;
	private JMenuItem mnBack;
	private JMenuItem mnDelete;
	private Component horizontalStrut;
	private Component verticalStrut_1;
	private JTextArea textSynopsis;
	private JTextField textPages;
	private JLabel lblPages;
	private JLabel lblCover;
	private JTextField textCover;
	private JLabel lblData;
	private JLabel lblNewLabel_6;
	private JLabel lblPageWarning;
	private Component horizontalStrut_2;
	private JLabel lblEmptyWarning;
	private JScrollPane scrollPane;
	private JLabel lblInfo;
	private JLabel lblAddConfirmation;

	/**
	 * Create the frame.
	 */
	public AddFrame() 
	{
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("./images/MainIcon.png"));
		setTitle("AÑADIR LIBRO");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 520);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("SplitPane.background"));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.WHITE);
		pnlLeft.setLayout(new MigLayout("", "[][200px][][86px][]", "[25px][25px][25px][50px,grow][][][][][]"));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		lblData = new JLabel("DATOS");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblData, "cell 1 0");
		
		textTitle = new JTextField();
		pnlLeft.add(textTitle, "cell 1 1,alignx center,aligny center,grow");
		textTitle.setColumns(10);
		
		textAuthor = new JTextField();
		pnlLeft.add(textAuthor, "cell 1 2,alignx center,aligny center,grow");
		textAuthor.setColumns(10);
		
		JLabel lblTitle = new JLabel("TITULO");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblTitle, "cell 3 1,alignx center,aligny center");
		
		JLabel lblAuthor = new JLabel("AUTOR");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblAuthor, "cell 3 2,alignx center,aligny center");
		
		scrollPane = new JScrollPane();
		pnlLeft.add(scrollPane, "cell 1 3,grow");
		
		textSynopsis = new JTextArea();
		scrollPane.setViewportView(textSynopsis);
		textSynopsis.setLineWrap(true);
		textSynopsis.setBorder(BorderFactory.createCompoundBorder(border,
	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		JLabel lblSinopsis = new JLabel("SINOPSIS");
		lblSinopsis.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblSinopsis, "cell 3 3,alignx center,aligny center");
		
		horizontalStrut = Box.createHorizontalStrut(10);
		pnlLeft.add(horizontalStrut, "cell 0 4");
		
		textPages = new JTextField();
		textPages.addKeyListener(new KeyAdapter() {
	          public void keyPressed(KeyEvent ke) {    
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	 textPages.setEditable(true);
	            	 lblPageWarning.setText("");
	             } else {
	            	 textPages.setEditable(false);
	            	 lblPageWarning.setText("DEBE SER UN NUMERO");
	             }
	          }
	       });
		pnlLeft.add(textPages, "cell 1 4,growx");
		textPages.setColumns(10);
		
		lblPages = new JLabel("PAGINAS");
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblPages, "cell 3 4,alignx center,aligny center");
		
		lblPageWarning = new JLabel("");
		lblPageWarning.setForeground(new Color(255, 0, 0));
		pnlLeft.add(lblPageWarning, "cell 5 4");
		
		textCover = new JTextField();
		pnlLeft.add(textCover, "cell 1 5,growx");
		textCover.setColumns(10);
		
		lblInfo = new JLabel("");
		lblInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Buscar imagen deseada en google > Click Derecho >\n"
						+ "Copiar direccion de imagen > Pegar en el recuadro de la izquierda", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblInfo.setIcon(new ImageIcon(AddFrame.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-confirm.png")));
		pnlLeft.add(lblInfo, "cell 2 5");
		
		lblCover = new JLabel("LINK PORTADA");
		lblCover.setToolTipText("<html> Buscar imagen deseada en google > Click Derecho <br> "
				+ "Copiar direccion de imagen > Pegar en el recuadro de la izquierda</html> >");
		lblCover.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblCover, "cell 3 5,alignx center,aligny center");
		
		verticalStrut_1 = Box.createVerticalStrut(60);
		pnlLeft.add(verticalStrut_1, "cell 1 6");
		
		lblEmptyWarning = new JLabel("");
		lblEmptyWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmptyWarning.setForeground(Color.RED);
		pnlLeft.add(lblEmptyWarning, "cell 3 6,alignx center,aligny center");
		
		lblVisualize = new JLabel("VISUALIZAR LIBRO");
		lblVisualize.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlLeft.add(lblVisualize, "cell 1 7");
		

		pnlRight = new JPanel();
		pnlRight.setBackground(Color.WHITE);
		pnlRight.setLayout(new BorderLayout(0, 0));
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		pnlLeft.add(horizontalStrut_2, "cell 4 7");

		lblAddConfirmation = new JLabel("");
		lblAddConfirmation.setForeground(new Color(50, 205, 50));
		pnlLeft.add(lblAddConfirmation, "cell 5 8");
		
		DatabaseManager.initBD();
		btnAdd = new JButton("ANADIR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	if(textTitle.getText().equals("") || textAuthor.getText().equals("") || textSynopsis.getText().equals("") 
		    			|| textPages.getText().equals("") || textCover.getText().equals("")) 
		    	{
		    		lblEmptyWarning.setText("<html> No puede haber campos vacios </html> ");
		    		
		    		
		    	} else {
			    lblEmptyWarning.setText("");
				Book libro = new Book( textTitle.getText(), textAuthor.getText(), textSynopsis.getText(), Integer.parseInt(textPages.getText()), textCover.getText());
				DatabaseManager.addNewBook(libro);
				lblAddConfirmation.setText("LIBRO AÑADIDO");
		    	}
				
			}
		});
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(60, 179, 113));
		pnlLeft.add(btnAdd, "cell 3 8,grow");

		
		lblNewLabel_6 = new JLabel("PREVIEW");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		pnlRight.add(lblNewLabel_6, BorderLayout.NORTH);
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnManage = new JMenu("GESTIONAR LIBROS");
		menuBar.add(mnManage);
		
		mnBack = new JMenuItem("VOLVER A LA ESTANTERIA");
		mnBack.addActionListener(new java.awt.event.ActionListener() 
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
		mnManage.add(mnBack);
		
		mnDelete = new JMenuItem("BORRAR UN LIBRO");
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
		
		JScrollPane scrLeft = new JScrollPane(pnlLeft);
		contentPane.add(scrLeft, BorderLayout.CENTER);
		
		final JScrollPane scrRight = new JScrollPane(pnlRight);
		contentPane.add(scrRight, BorderLayout.EAST);
		
		pnlRight.setVisible(false);
    	scrRight.setVisible(false);
		
		btnPreview = new JButton("PREVIEW");
		btnPreview.addActionListener(new java.awt.event.ActionListener() 
		{
		    public void actionPerformed(java.awt.event.ActionEvent evt) 
		    {
		    	if(textTitle.getText().equals("") || textAuthor.getText().equals("") || textSynopsis.getText().equals("") 
		    			|| textPages.getText().equals("") || textCover.getText().equals("")) 
		    	{
		    		lblEmptyWarning.setText("<html> No puede haber campos vacios </html> ");
		    		
		    		
		    	} else {
			    	lblEmptyWarning.setText("");
			    	Book prueba = new Book( textTitle.getText(), textAuthor.getText(), textSynopsis.getText(), Integer.parseInt(textPages.getText()), textCover.getText());
	
			    	DescriptionPanel Description;
					Description = new DescriptionPanel(prueba);
					pnlRight.add(Description);
			    	
			    	pnlRight.setVisible(true);
			    	scrRight.setVisible(true);
			    	
			    	pnlRight.revalidate();
			    	pnlRight.repaint();
			    	
			    	contentPane.revalidate();
			    	contentPane.repaint();
		    	}
		    }
		});
		pnlLeft.add(btnPreview, "cell 3 7,grow");
		
	}
	
	public static void openAdd() 
	{
		AddFrame addFrame = new AddFrame();
		addFrame.setSize(860, 520);
		addFrame.setLocationRelativeTo(null);
		addFrame.setVisible(true);
	}

}
