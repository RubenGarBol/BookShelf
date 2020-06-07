package windows;

import javax.swing.JPanel;

import models.Book;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;

public class DescriptionPanel extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public DescriptionPanel(Book book) {
		setBackground(Color.WHITE);
	
		URL url = null;
		try {
			url = new URL(book.getCover());
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(this,
				    "La URL no es correcta.",
				    "URL Warning",
				    JOptionPane.ERROR_MESSAGE);
		}
		BufferedImage Cover = null;
		try {
			Cover = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		setLayout(new MigLayout("", "[75px][][][150px]", "[25px][25px][][75px][25px]"));
		
		JLabel lblLibro = new JLabel("LIBRO: ");
		lblLibro.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblLibro, "cell 0 0,alignx center,growy");
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		add(horizontalStrut, "cell 2 0");
		
		JLabel lblNewLabel_1 = new JLabel("<html>" + book.getBookName() +"</html>");
		add(lblNewLabel_1, "cell 3 0,alignx left,growy");
		
		JLabel lblNewLabel = new JLabel("AUTOR: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel, "cell 0 1,alignx center,growy");
		
		JLabel lblNewLabel_2 = new JLabel("<html>" + book.getAuthorName() +"</html>");
		add(lblNewLabel_2, "cell 3 1,alignx left,growy");
		
		Component verticalStrut = Box.createVerticalStrut(10);
		add(verticalStrut, "cell 1 2");
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getScaledImage(Cover, 120, 180)));		
		add(lblNewLabel_3, "cell 0 3,alignx center,aligny top");
		
		JLabel lblNewLabel_4 = new JLabel("<html>" + book.getSynopsis() +"</html>");
		add(lblNewLabel_4, "cell 3 3,alignx left,aligny top");
		
		JLabel lblNewLabel_6 = new JLabel("PAGINAS:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblNewLabel_6, "cell 0 4,alignx center,aligny center");
		
		//JLabel lblNewLabel_4 = new JLabel( book.getSynopsis() );
		//lblNewLabel_4.setMaximumSize(new Dimension(50, 50));
		//add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(book.getPages()));
		add(lblNewLabel_5, "cell 1 4,alignx center,aligny center");

	}
	
	public static Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}


}
