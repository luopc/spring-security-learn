package com.luopc.security.validate.image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 图形验证码生成工具类
 * @author cheng
 *
 */
public class ImageCodeGeneratorTool {

	private int w = 67;
	private int h = 23;
	private int l = 4;
	private Random r = new Random();
	// 定义有那些字体
	private String[] fontNames = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312" };
	// 定义有那些验证码的随机字符
//	private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
	private String codes = "1234567890";
	// 生成背景色
	private Color bgColor = new Color(112,128,144);
	// 用于gettext 方法 获得生成的验证码文本
	private String text;
	

	public ImageCodeGeneratorTool() {
		super();
	}

	public ImageCodeGeneratorTool(int w, int h,int l) {
		super();
		this.w = w;
		this.h = h;
		this.l = l;
	}
	
	// 生成随机颜色
	private Color randomColor() {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}

	// 生成随机字体
	private Font randomFont() {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 24;

		return new Font(fontName, style, size);
	}

	// 画干扰线
	private void drawLine(BufferedImage image) {
		int num = 4;
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));// 不知道
			g2.setColor(Color.blue);
			g2.drawLine(x1, y1, x2, y2);
		}
	}

	// 得到codes的长度内的随机数 并使用charAt 取得随机数位置上的codes中的字符
	private char randomChar() {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}

	// 创建一张验证码的图片
	public BufferedImage createImage() {
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(bgColor);
		g2.fillRect(0,0,w, h);//填充整个屏幕
		StringBuilder sb = new StringBuilder();
		// 向图中画四个字符
		for (int i = 0; i < l; i++) {
			String s = randomChar() + "";
			sb.append(s);
			float x = i * 1.0F * w / l;
			g2.setFont(randomFont());
			g2.setColor(randomColor());
			g2.drawString(s, x, h - 5);

		}
		this.text = sb.toString();
		drawLine(image);
		
		// 返回图片
		return image;

	}

	// 得到验证码的文本 后面是用来和用户输入的验证码 检测用
	public String getText() {
		return text;
	}

	// 定义输出的对象和输出的方向
	public static void output(BufferedImage bi, OutputStream fos) throws FileNotFoundException, IOException {
		ImageIO.write(bi, "JPEG", fos);
	}

	
}