package cn.test.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.test.dao.AbstractDao;
import cn.test.dao.MemberDao;
import cn.test.vo.Member;

public class MemberDaoImpl extends AbstractDao implements MemberDao {
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql = " INSERT INTO member(name,sex,age,phone,salary,note) "
				+ " VALUES(?,?,?,?,?,?) ";
		try {
			this.preparedStatement = this.conn.prepareStatement(sql) ;
			preparedStatement.setString(1, vo.getName());
			preparedStatement.setString(2, vo.getSex());
			preparedStatement.setInt(3, vo.getAge());
			preparedStatement.setString(4, vo.getPhone());
			preparedStatement.setDouble(5, vo.getSalary());
			preparedStatement.setString(6,vo.getNote());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preparedStatement.executeUpdate() == 1;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		String sql = " UPDATE member SET name=?,sex=?,age=?,phone=?,salary=?,note=? "
				+ " WHERE id = ?";
		this.preparedStatement = this.conn.prepareStatement(sql) ;
		preparedStatement.setString(1, vo.getName());
		preparedStatement.setString(2, vo.getSex());
		preparedStatement.setInt(3, vo.getAge());
		preparedStatement.setString(4, vo.getPhone());
		preparedStatement.setDouble(5, vo.getSalary());
		preparedStatement.setString(6,vo.getNote());
		preparedStatement.setLong(7,vo.getId());
		System.out.println("*****分支合并到主干之后测试主干上的变动*******");
		return preparedStatement.executeUpdate() == 1;
	}

	@Override
	public boolean doDeleteByIds(Set<Long> ids) throws SQLException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("DELETE FROM member WHERE id IN ( ");
		Iterator<Long> iter = ids.iterator();
		while(iter.hasNext()){
			buffer.append("'").append(iter.next()).append("'").append(",");
		}
		buffer.delete(buffer.length()-1,buffer.length()).append(")");
		preparedStatement = this.conn.prepareStatement(buffer.toString());
		return preparedStatement.executeUpdate()==ids.size();
	}

	@Override
	public Member findById(Long id) throws SQLException {
		String sql = "SELECT id,name,sex,age,phone,salary,note FROM member WHERE id = ?";
		Member vo = null;
		preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setLong(0,id);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			vo = new Member();
			vo.setId(rs.getLong(0));
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setPhone(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setName(rs.getString(6));
		}
		return vo;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		String sql = "SELECT id,name,sex,age,phone,salary,note FROM member";
		List<Member> all = new ArrayList<Member>();
		preparedStatement = this.conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			Member vo = new Member();
			vo = new Member();
			vo.setId(rs.getLong(0));
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setPhone(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setName(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Member> findBySplit(Integer currentPage, Integer pageSize) throws SQLException {
		String sql = " SELECT id,name,sex,age,phone,salary,note FROM member "
				+ " LIMIT ?,?";
		List<Member> all = new ArrayList<Member>();
		preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setInt(0,(currentPage-1)*pageSize);
		preparedStatement.setInt(1,currentPage*pageSize);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			Member vo = new Member();
			vo = new Member();
			vo.setId(rs.getLong(0));
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setPhone(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setName(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Member> findBySplit(String column, String keyWord, Integer currentPage, Integer pageSize)
			throws SQLException {
		String sql = " SELECT id,name,sex,age,phone,salary,note FROM member "
				+ " WHERE "+ column +" LIKE ? LIMIT ?,?";
		List<Member> all = new ArrayList<Member>();
		preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(0,"%"+keyWord+"%");
		preparedStatement.setInt(1,(currentPage-1)*pageSize);
		preparedStatement.setInt(2,currentPage*pageSize);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			Member vo = new Member();
			vo = new Member();
			vo.setId(rs.getLong(0));
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setPhone(rs.getString(4));
			vo.setSalary(rs.getDouble(5));
			vo.setName(rs.getString(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Long getAllCount() throws SQLException {
		String sql = " SELECT COUNT(*) FROM member ";
		preparedStatement = this.conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			return rs.getLong(0);
		}
		return 0L;
	}

	@Override
	public Long getAllCount(String column, String keyWord) throws SQLException {
		String sql = " SELECT COUNT(*) FROM member "
				+ " WHERE "+ column +" LIKE ?";
		preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(0, "%"+keyWord+"%");
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			return rs.getLong(0);
		}
		return 0L;
	}

	@Override
	public Member findByPhone(String phone) throws SQLException {
		String sql = "SELECT id,name,sex,age,phone,salary,note FROM member WHERE phone = ?";
		Member vo = null;
		preparedStatement = this.conn.prepareStatement(sql);
		preparedStatement.setString(1, phone);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			vo = new Member();
			vo.setId(rs.getLong(1));
			vo.setName(rs.getString(2));
			vo.setSex(rs.getString(3));
			vo.setAge(rs.getInt(4));
			vo.setPhone(rs.getString(5));
			vo.setSalary(rs.getDouble(6));
			vo.setName(rs.getString(7));
		}
		return vo;
	}
	//测试SVN服务器
}
