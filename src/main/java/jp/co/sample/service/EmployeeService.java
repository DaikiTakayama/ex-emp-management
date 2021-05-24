package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報を検索する処理を記述するサービスクラス.
 * 
 * @author daiki.takayama
 *
 */

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	/**
	 * 従業員情報を全件取得する.
	 * 
	 * @return empList 取得できた会員情報
	 */
	public List<Employee> showList(){
		List<Employee> empList = repository.findAll();
		return empList;
	}
	
	/**
	 * 従業員情報を取得する.
	 * 
	 * @param id 従業員のID
	 * @return 取得した従業員情報
	 */
	public Employee showDetail(Integer id) {
		Employee employee = repository.load(id);
		return employee;
		
	}
}
