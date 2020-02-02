package mybatis_study_annotation.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.CourseDaoImpl;
import mybatis_study_annotation.dto.Course;
import mybatis_study_annotation.dto.CourseStat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDaoTest extends AbstractTest {
	private CourseDao dao = CourseDaoImpl.getInstance();

	@Test
	public void test01SelectCoursesByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Course> lists = dao.selectCoursesByTutorId(1);
		Assert.assertNotNull(lists);
		for (Course course : lists) {
			log.debug(course.toString());
		}
	}

	@Test
	public void test02InsertCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Course course = new Course(10, "python", "pyqt programming", new Date(), new Date(), 1);
		int res = dao.insertCourse(course);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03DeleteCourse() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Course course = new Course(10, "python", "pyqt programming", new Date(), new Date(), 1);
		int res = dao.deleteCourse(course);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04getCourseCountByTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		CourseStat stat = dao.getCourseCountByTutor(1);
		Assert.assertNotNull(stat);
		log.debug(stat.toString());
	}

	@Test
	public void test05getCourseCountByTutor2() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> param = new HashMap<>();
		param.put("tutor_id", 1);
		
		CourseStat stat = dao.getCourseCountByTutor2(param);
		Assert.assertNotNull(stat);
		log.debug(stat.toString());
	}

	@Test
	public void test06getCourseCountByTutor3() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> param = new HashMap<>();
		param.put("tutor_id", 1);
		
		Map<String, Object> map = dao.getCourseCountByTutor3(param);
		Assert.assertNotNull(map);
		for(Entry<String, Object> e : map.entrySet()) {
			log.debug(String.format("%s -> %s", e.getKey(), e.getValue()));
		}
	}
	
	@Test
	public void test07getCourseCountByTutor4() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, Object> param = new HashMap<>();
		param.put("tutor_id", 1);
		
		Map<String, Object> map = dao.getCourseCountByTutor4(param);
		Assert.assertNotNull(map);
		for(Entry<String, Object> e : map.entrySet()) {
			log.debug(String.format("%s -> %s", e.getKey(), e.getValue()));
		}
	}
}
