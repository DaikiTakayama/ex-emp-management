package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者登録画面を表示する処理を行うクラス
 * 
 * @author daiki.takayama
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	/**
	 * InsetAdministratorForm クラスをインスタンス化
	 * 
	 * @return InsertAdministratorForm を新規にインスタンス化
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * LoginForm クラスをインスタンス化
	 * 
	 * @return LoginForm クラスを新規にインスタンス化
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	@Autowired
	private AdministratorService adminService;

	@Autowired
	private HttpSession session;

	/**
	 * 「administrotor/insert.html」を表示
	 * 
	 * @return administrator/insert.html へフォワード
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {

		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する。
	 * 
	 * @param insertAdministratorForm
	 * @return "/"(ログイン画面)へredirect
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
	 * 
	 * @return administrator/login.html へフォワード
	 */
	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login";
	}

	/**
	 * ログインボタンを押した時のログイン処理を実行するメソッド
	 * 
	 * @param loginForm
	 * @param result
	 * @param model
	 * @return ログイン成功時：従業員一覧画面へ、ログイン失敗時：ログイン画面へ遷移
	 * 
	 */
	@RequestMapping("/login")
	public String login(@Validated LoginForm loginForm, BindingResult result, Model model) {

		Administrator administrator = new Administrator();
		administrator.setMailAddress(loginForm.getMailAddress());
		administrator.setPassword(loginForm.getPassword());
		administrator = adminService.login(administrator.getMailAddress(), administrator.getPassword());

		if (administrator != null) {
			model.addAttribute("loginResult", true);
			session.setAttribute("administratorName", administrator.getName());
			return "forward:/employee/showList";
		} else {
			model.addAttribute("loginResult", false);
			return "administrator/login";
		}
	}
}
