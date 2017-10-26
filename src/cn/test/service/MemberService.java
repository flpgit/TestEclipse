package cn.test.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import cn.test.vo.Member;

public interface MemberService {
	public boolean add(Member vo) throws Exception;
	public boolean update(Member vo) throws Exception;
	public boolean delete(Set<Long> ids) throws Exception;
	public List<Member> findAll() throws Exception;
	public Map<String, Object> findAllSplit(Integer currentPage,Integer pageSize) throws Exception;
	public Map<String, Object> findAllSplit(String column,String keyWord,Integer currentPage,Integer pageSize) throws Exception;

}
