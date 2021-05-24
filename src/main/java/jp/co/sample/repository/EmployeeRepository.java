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
 * employees テーブルを操作するリポジトリ.
 * @author daiki.takayama
 *
 */
@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER=new BeanPropertyRowMapper<>(Employee.class);
	
	/**
	 * 従業員一覧情報を入社日順(降順)で取得する.
	 * 
	 * @return empList 取得した従業員リスト
	 */
	public List<Employee> findAll(){
		String sql="select * from employees order by hire_date DESC";
		
		List<Employee> empList =template.query(sql, EMPLOYEE_ROW_MAPPER);
		return empList;
	}
	
	/**
	 * 主キーから従業員情報を取得する.
	 * 
	 * @param id　取得したい従業員の主キー
	 * @return employee 取得した従業員情報
	 */
	public Employee load(Integer id) {
		Employee employee=new Employee();
		String sql="select * from employees where id=:id";
		SqlParameterSource parameterSource=new MapSqlParameterSource().addValue("id", id);
		employee= template.queryForObject(sql, parameterSource, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	
	/**
	 * 従業員情報を更新.
	 * 
	 * @param employee 更新する従業員の参照オブジェクト
	 * 
	 */
	public void update(Employee employee) {
		SqlParameterSource parameterSource =new BeanPropertySqlParameterSource(employee);
		
		String sql="Update employees set name=:name,image=:image,gender=:gender,hire_date=:hireDate,mail_address=:mailAddress,"
				+"zip_code=:zipCode,address=:address,telephone=:telephone,salary=:salary,characteristics=:characteristics,"
				+"dependents_count=:dependentsCount where id=:id";
		
		template.update(sql, parameterSource);
	}
}
