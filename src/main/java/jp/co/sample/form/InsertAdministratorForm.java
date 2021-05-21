package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

/**
 * 管理者情報を登録時に使用するフォームクラス
 * @author daiki.takayama
 *
 */
public class InsertAdministratorForm {
	@NotBlank()
	private String name;
	@NotBlank()
	private String mailAddress;
	@NotBlank
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
}
