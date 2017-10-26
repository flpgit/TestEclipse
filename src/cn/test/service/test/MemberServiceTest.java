package cn.test.service.test;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

import cn.test.factory.ServiceFactory;
import cn.test.service.MemberService;
import cn.test.service.impl.MemberServiceImpl;
import cn.test.vo.Member;
import junit.framework.TestCase;

public class MemberServiceTest {
	private static Random random = new Random();
	private Integer z = 0;
	//冲突解决完毕
	@Test
	public void testAdd() throws Exception{
		//此处要注意做个标记
		int y = 0;
		MemberService memberService = ServiceFactory.getInstance(MemberServiceImpl.class);
		Member vo = new Member();
		int x = random.nextInt(1000);
		vo.setName("张三EE空间--"+x);
		vo.setSex("男");
		vo.setAge(28);
		vo.setPhone("15026755006"+x);
		vo.setSalary(66.0);
		vo.setNote("人不错");
		System.out.println("&&&&:"+"***************");
		TestCase.assertTrue(memberService.add(vo));
		TestCase.assertNotNull(vo);
	}

	@Test
	public void testUpdate() throws Exception{
		int y = random.nextInt(2000);
		Member vo = new Member();
		vo.setId(11l);
		vo.setName("修改-张三-hello"+y);
		vo.setAge(35);
		vo.setSex("男");
		vo.setSalary(14000.0);
		vo.setPhone("150"+y);
		vo.setNote("修改note信息");
		MemberService memberService = ServiceFactory.getInstance(MemberServiceImpl.class);
		boolean flag = memberService.update(vo);
		System.out.println("修改结果:"+flag);
		TestCase.assertTrue(flag);
	}

	@Test
	public void testDelete() {
		System.out.println("*****28中分支测试********");
		System.out.println("*****主干在分支合并到主干上时的测试********");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllSplitIntegerInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllSplitStringStringIntegerInteger() {
		fail("Not yet implemented");
	}
	
}
