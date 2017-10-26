package cn.test.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface Dao<K, V> {
	public boolean doCreate(V vo) throws SQLException;

	public boolean doUpdate(V vo) throws SQLException;

	public boolean doDeleteByIds(Set<Long> ids) throws SQLException;

	public V findById(K id) throws SQLException;

	public List<V> findAll() throws SQLException;

	public List<V> findBySplit(Integer currentPage, Integer pageSize) throws SQLException;

	public List<V> findBySplit(String column, String keyWord, Integer currentPage, Integer pageSize)
			throws SQLException;

	public Long getAllCount() throws SQLException;

	public Long getAllCount(String column, String keyWord) throws SQLException;

}
