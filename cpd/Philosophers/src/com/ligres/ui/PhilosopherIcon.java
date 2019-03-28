package com.ligres.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PhilosopherIcon extends JPanel {

	private static final long serialVersionUID = 855098475387050721L;
	private BufferedImage image;
	private BufferedImage baseImage;
	private int x;
	private int y;
	private int width;
	private int height;

	public PhilosopherIcon(int x, int y, int width, int height) {
		try {
			baseImage = image = ImageIO.read(new File("res/philosopher.png"));
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	@Override
	protected void paintComponent(Graphics g) {
		baseImage = image = PhilosopherIcon.resize(image, width, height);
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}

	public void changeColor(Color color) {
		image = PhilosopherIcon.tint(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha(), baseImage);
		getGraphics().drawImage(image, x, y, this);
	}

	public static BufferedImage tint(float r, float g, float b, float a, BufferedImage sprite) {
		BufferedImage tintedSprite = new BufferedImage(sprite.getWidth(), sprite.getHeight(), BufferedImage.TRANSLUCENT);
		Graphics2D graphics = tintedSprite.createGraphics();
		graphics.drawImage(sprite, 0, 0, null);
		graphics.dispose();

		for (int i = 0; i < tintedSprite.getWidth(); i++) {
			for (int j = 0; j < tintedSprite.getHeight(); j++) {
				int ax = tintedSprite.getColorModel().getAlpha(tintedSprite.getRaster().getDataElements(i, j, null));
				int rx = tintedSprite.getColorModel().getRed(tintedSprite.getRaster().getDataElements(i, j, null));
				int gx = tintedSprite.getColorModel().getGreen(tintedSprite.getRaster().getDataElements(i, j, null));
				int bx = tintedSprite.getColorModel().getBlue(tintedSprite.getRaster().getDataElements(i, j, null));
				rx *= r;
				gx *= g;
				bx *= b;
				ax *= a;
				tintedSprite.setRGB(i, j, (ax << 24) | (rx << 16) | (gx << 8) | (bx));
			}
		}
		return tintedSprite;
	}

}