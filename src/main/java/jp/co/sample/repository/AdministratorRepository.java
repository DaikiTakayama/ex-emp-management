package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * administrators テーブル を操作するリポジトリクラス
 * @author daiki.takayama
 *
 */
@Repository
public class AdministratorRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPAER= (rs,i)->{
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	/**
	 * 管理者情報を挿入する
	 * @param administrator：administrator クラスを参照する引数
	 */
	public void insert(Administrator administrator) {
		System.out.println(" --- insert処理 ---");
		
		SqlParameterSource parameter = new BeanPropertySqlParameterSource(administrator);
		
		String sql="insert into administrators(name,mail_address,password)"
				+" values(:name,:mailAddress,:password)";
		template.update(sql, parameter);
		
	}
	
	
	/**
	 * メールアドレスとパスワードから管理者情報を取得する
	 * 
	 * @param 
	 * @return 取得した管理者の情報を渡す
	 */
	public Administrator findByMailAndPassword(String mailAddress,String password) {
		System.out.println("--- findByMailAndPassword処理 ---");
				
		String sql="select * from administrators where mail_address=:mailAddress and password=:password";
		
		SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
		try {
			Administrator administrator=template.queryForObject(sql,parameterSource,ADMINISTRATOR_ROW_MAPPAER);
			return administrator;
		}catch (IncorrectResultSizeDataAccessException e) {
			System.out.println("実行結果は0行でした");
			return null;
		}


	}
	
}
