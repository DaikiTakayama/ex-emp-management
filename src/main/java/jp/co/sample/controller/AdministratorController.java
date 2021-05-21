package jp.co.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;


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
	 * @return
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * 「administrotor/insert.html」を表示
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		
		return "administrator/insert";
	}
}
