import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class imageEncryption {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\ELCOT\\Desktop\\nature.jpg");
			BufferedImage img = ImageIO.read(file);
			int width = img.getWidth();
			int height = img.getHeight();

			BufferedImage eimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					int pixel = img.getRGB(x, y);
					int red = (pixel >> 16) & 0xff;
					int green = (pixel >> 8) & 0xff;
					int blue = pixel & 0xff;

					red = (red + 342) % 256;
					green = (green * 35) % 256;
					blue = (blue - 320) % 256;

					int encryppixel = (red << 16) | (green << 8) | blue;
					eimg.setRGB(x, y, encryppixel);

				}
			}

			ImageIO.write(eimg, "jpg", new File("encrpt_img.jpg"));

			JLabel label = new JLabel(new ImageIcon(eimg));
			JFrame frame = new JFrame();
			frame.getContentPane().add(label);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
