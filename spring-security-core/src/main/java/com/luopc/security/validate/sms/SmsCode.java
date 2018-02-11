/**
 * 
 */
package com.luopc.security.validate.sms;

import com.luopc.security.validate.ValidateCode;

/**
 * @author zhailiang
 *
 */
public class SmsCode extends ValidateCode {

	public SmsCode(String code, int expireIn) {
		super(code, expireIn);
	}
}
