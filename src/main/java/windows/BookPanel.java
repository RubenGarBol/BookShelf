package windows;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.Book;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;

public class BookPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public BookPanel(Book book) throws IOException {
		setLayout(new BorderLayout(0, 0));
		
		URL url = new URL(book.getCover());
		BufferedImage Cover = ImageIO.read(url);
		JLabel coverImage = new JLabel(new ImageIcon(DescriptionPanel.getScaledImage(Cover, 80, 120)));
		coverImage.setHorizontalAlignment(SwingConstants.CENTER);
		add(coverImage, BorderLayout.CENTER);
		
		JLabel bookTitle = new JLabel("  " + book.getBookName() +  "  ");
		bookTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(bookTitle, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, BorderLayout.NORTH);
		

	}

}
