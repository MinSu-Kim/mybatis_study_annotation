package mybatis_study_annotation.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.StudentDaoImpl;
import mybatis_study_annotation.dto.Student;

public class StudentDaoTest extends AbstractTest {
	private StudentDao dao = StudentDaoImpl.getInstance();
	
	@Test
	public void testSelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNo(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}

	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	    List<Student> lists = dao.selectStudentByAll();
	    Assert.assertNotNull(lists);
	    for(Student std : lists) {
	    	log.debug(std.toString());
	    }
	}

}
