/**
 * 
 */
package com.luopc.security.validate.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.luopc.security.validate.ValidateCode;

/**
 * @author zhailiang
 *
 */
public class ImageCode extends ValidateCode {

	private BufferedImage image;

	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code, expireIn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code, expireTime);
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
