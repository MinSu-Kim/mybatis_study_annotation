package mybatis_study_annotation.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.CourseDaoImpl;
import mybatis_study_annotation.dto.Course;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDaoTest extends AbstractTest {
	private CourseDao dao = CourseDaoImpl.getInstance();
	
	@Test
	public void test01SelectCoursesByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Course> lists = dao.selectCoursesByTutorId(1);
	    Assert.assertNotNull(lists);
	    for(Course course : lists) {
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

}
