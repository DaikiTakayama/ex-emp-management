package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * ログイン時に使用するフォームクラス
 * @author daiki.takayama
 *
 */
public class LoginForm {
	@NotBlank
	private String mailAddress;
	@NotBlank
	private String password;
	
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	
	
}
