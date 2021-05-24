package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@ModelAttribute
	private UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}
	
	/**
	 * 従業員の一覧を出力するクラス.
	 * 
	 * @param model request スコープの準備
	 * @return 従業員一覧画面へフォワード
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList =  empService.showList();
		model.addAttribute("employeeList",employeeList);
		return "employee/list";
	}
	
	
	/**
	 * リクエストパラメータから従業員情報を取得し、出力する.
	 * 
	 * @param id リクエストパラメータから送られた従業員ID
	 * @param model requestスコープを準備
	 * @return 従業員情報詳細画面を表示
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		int empId = Integer.parseInt(id);
		Employee employee = empService.showDetail(empId);
		
		model.addAttribute("employee",employee);
		return "employee/detail";
	}
	
	/**
	 * 従業員詳細を更新.
	 * 
	 * @param updateEmployeeForm リクエストパラメータの情報を格納するオブジェクト
	 * @return showList メソッドへリダイレクト 
	 * 
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm updateEmployeeForm) {
		Employee employee =empService.showDetail(updateEmployeeForm.getId());
		employee.setDependentsCount(Integer.parseInt(updateEmployeeForm.getDependentsCount()));
		empService.update(employee);
		return "redirect:/employee/showList";
	}
	
	
}
