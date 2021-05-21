package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 * employees テーブルを操作するリポジトリ
 * @author daiki.takayama
 *
 */
@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER=new BeanPropertyRowMapper<>(Employee.class);
	
	/**
	 * 従業員一覧情報を入社日順(降順)で取得する
	 * @return empList
	 */
	public List<Employee> findAll(){
		String sql="select * from employees order by hire_date DESC";
		
		List<Employee> empList =template.query(sql, EMPLOYEE_ROW_MAPPER);
		return empList;
	}
	
	/**
	 * 主キーから従業員情報を取得する
	 * @param id 取得したい従業員のid
	 * @return employee
	 */
	public Employee load(Integer id) {
		Employee employee=new Employee();
		String sql="select * from employees where id=:id";
		SqlParameterSource parameterSource=new MapSqlParameterSource().addValue("id", id);
		employee= template.queryForObject(sql, parameterSource, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	
	/**
	 * 従業員情報を更新
	 * @param employee
	 */
	public void update(Employee employee) {
		SqlParameterSource parameterSource =new BeanPropertySqlParameterSource(employee);
		
		String sql="Update employees set name=:name,image=:image,gender=:gender,hire_date=:hire_date,mail_address=:mail_address,"
				+"zip_code=:zip_code,address=:address,telephone=:telephone,salary=:salary,characteristics=:characteristics,"
				+"dependents_count=:dependents_count where id=:id";
		
		template.update(sql, parameterSource);
	}
}
