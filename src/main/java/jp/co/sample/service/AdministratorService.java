package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * AdministratorRipository クラスを操作するクラス
 * @author daiki.takayama
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository administratorRepository;
	
	/**
	 * AdministratorRepository クラスのinsertメソッドを呼び出すクラス
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	
	
	/**
	 * ログイン処理をする。
	 * administratorRepository の findByMailAddressAndPassword() メソッドを呼ぶ。
	 * @param mailAddress
	 * @param password
	 * @return fidByMailAndPassword 処理で取得した管理者情報を返す
	 */
	public Administrator login(String mailAddress,String password) {
		return administratorRepository.findByMailAndPassword(mailAddress, password);
	}
	
}
