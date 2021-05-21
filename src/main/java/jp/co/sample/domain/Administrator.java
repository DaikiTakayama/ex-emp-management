package jp.co.sample.domain;


/**
 * 管理者情報を表すドメインクラス
 * @author daiki.takayama
 *
 */
public class Administrator {
	private Integer id;
	private String name;
	private String mailAddress;
	private String password;
	
	public Administrator() {
		
	}
	
	public Administrator(Integer id, String name, String mail_address, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = mail_address;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail_address() {
		return mailAddress;
	}
	public void setMail_address(String mail_address) {
		this.mailAddress = mail_address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mail_address=" + mailAddress + ", password="
				+ password + "]";
	}
	
	
}
