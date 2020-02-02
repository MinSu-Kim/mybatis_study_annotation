package mybatis_study_annotation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.TutorDaoImpl;
import mybatis_study_annotation.dto.Tutor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorDaoTest extends AbstractTest {
	private TutorDao dao = TutorDaoImpl.getInstance();

	@Test
	public void test01SelectTutorById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Tutor selTutor = dao.selectTutorById(1);

		Assert.assertNotNull(selTutor);
		log.trace(selTutor.toString());
	}

	@Test
	public void test02SelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Tutor tutor = new Tutor();
		tutor.setTutorId(1);
		Tutor selTutor = dao.selectTutorByTutorId(tutor);

		Assert.assertNotNull(selTutor);
		log.trace(selTutor.toString());
	}
	
	@Test
	public void test03SelectAllTutorsProv() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Tutor> lists = dao.selectAllTutorsProv();
		Assert.assertNotNull(lists);
		for(Tutor t : lists) log.trace(t.toString());
	}

	@Test
	public void test04SelectTutorProv() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = null;
		List<Tutor> lists = dao.selectTutorProv(map);
		for(Tutor t : lists) log.trace(t.toString());
		
		map = new HashMap<>();
		map.put("tutorId", 1);

		lists = dao.selectTutorProv(map);
		Assert.assertNotNull(lists);
		for(Tutor t : lists) log.trace(t.toString());
	}

	@Test
	public void test05SelectTutorByJoinProv() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> map = null;
		List<Tutor> lists = dao.selectTutorByJoinProv(map);
		for(Tutor t : lists) log.trace(t.toString());
		
		map = new HashMap<>();
		map.put("tutorId", 1);
		lists = dao.selectTutorByJoinProv(map);
		for(Tutor t : lists) log.trace(t.toString());
		
		map.put("addrId", 1);
		lists = dao.selectTutorByJoinProv(map);
		Assert.assertNotNull(lists);
		for(Tutor t : lists) log.trace(t.toString());
	}   

}
