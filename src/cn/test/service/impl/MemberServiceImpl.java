package cn.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.test.dao.MemberDao;
import cn.test.dao.impl.MemberDaoImpl;
import cn.test.factory.DaoFactory;
import cn.test.service.MemberService;
import cn.test.vo.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public boolean add(Member vo) throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		Member temp = memberDao.findByPhone(vo.getPhone());
		if(temp==null){
			if(vo.getAge()<=0){
				vo.setAge(-1);
			}
			try {
				boolean flag =  memberDao.doCreate(vo);
				return flag;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(Member vo) throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		Member temp = memberDao.findByPhone(vo.getPhone());
		if(temp==null){
			return memberDao.doUpdate(vo);
		} else {
			if(temp.getId().equals(vo.getId())){
				return memberDao.doUpdate(vo);
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(Set<Long> ids) throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		if(ids!=null&&ids.size()>0){
			return memberDao.doDeleteByIds(ids);
		}
		return false;
	}

	@Override
	public List<Member> findAll() throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		return memberDao.findAll();
	}

	@Override
	public Map<String, Object> findAllSplit(Integer currentPage, Integer pageSize) throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		List<Member> allMembers = memberDao.findBySplit(currentPage, pageSize);
		Long allCount = memberDao.getAllCount();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("allMembers",allMembers);
		map.put("allCount",allCount);
		return map;
	}

	@Override
	public Map<String,Object> findAllSplit(String column, String keyWord, Integer currentPage, Integer pageSize)
			throws Exception {
		MemberDao memberDao = DaoFactory.getInstance(MemberDaoImpl.class);
		Map<String, Object> map = new HashMap<String,Object>();
		if(column==null||"".equals(column)||keyWord==null||"".equals(keyWord)){
			List<Member> allMembers = memberDao.findBySplit(currentPage, pageSize);
			Long allCount = memberDao.getAllCount();
			map.put("allMembers",allMembers);
			map.put("allCount",allCount);
		} else {
			List<Member> allMembers = memberDao.findBySplit(column, keyWord, currentPage, pageSize);
			Long allCount = memberDao.getAllCount(column, keyWord);
			map.put("allMembers",allMembers);
			map.put("allCount",allCount);
		}
		return map;
	}


}
