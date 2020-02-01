package mybatis_study_annotation.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.StudentDaoImpl;
import mybatis_study_annotation.dto.PhoneNumber;
import mybatis_study_annotation.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoTest extends AbstractTest {
	private StudentDao dao = StudentDaoImpl.getInstance();
	
	@Test
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNo(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}

	@Test
	public void test02SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	    List<Student> lists = dao.selectStudentByAll();
	    Assert.assertNotNull(lists);
	    for(Student std : lists) {
	    	log.debug(std.toString());
	    }
	}
	
	@Test
    public void test03InsertStudentANNOTATION() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
        Calendar newDate = GregorianCalendar.getInstance();
        newDate.set(1990, 4, 28);
        
        Student student = new Student(5, "홍길동5", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
        int res = dao.insertStudent(student);
        Assert.assertEquals(1, res);
    }

}
