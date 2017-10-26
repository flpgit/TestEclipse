package cn.test.dao;

import java.sql.SQLException;

import cn.test.vo.Member;

public interface MemberDao extends Dao<Long,Member> {
	public Member findByPhone(String phone) throws SQLException;

}
