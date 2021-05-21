package jp.co.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;


/**
 * 管理者登録画面を表示する処理を行うクラス
 * @author daiki.takayama
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	/**
	 * InsetAdministratorForm クラスをインスタンス化
	 * @return InsertAdministratorForm を新規にインスタンス化
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * LoginForm クラスをインスタンス化
	 * @return LoginForm クラスを新規にインスタンス化
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	@Autowired
	private AdministratorService adminService;
	
	
	
	/**
	 * 「administrotor/insert.html」を表示
	 * @return administrator/insert.html へフォワード
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		
		return "administrator/insert";
	}
	
	
	/**
	 * 管理者情報を登録する。
	 * @param insertAdministratorForm
	 * @return　"/"(ログイン画面)へredirect
	 */
	
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm insertAdministratorForm) {
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(insertAdministratorForm, administrator);
		adminService.insert(administrator);
		
		return "redirect:/";

	}
	
	/**
	 * 「administrator/login.html」 を表示
	 * @return administrator/login.html へフォワード
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}
}
