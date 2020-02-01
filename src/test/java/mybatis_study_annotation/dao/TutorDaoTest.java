package mybatis_study_annotation.dao;

import org.junit.Assert;
import org.junit.Test;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.TutorDaoImpl;
import mybatis_study_annotation.dto.Tutor;

public class TutorDaoTest extends AbstractTest {
	private TutorDao dao = TutorDaoImpl.getInstance();

	@Test
	public void testSelectTutorById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Tutor selTutor = dao.selectTutorById(1);

		Assert.assertNotNull(selTutor);
		log.trace(selTutor.toString());
	}

	@Test
	public void testSelectTutorByTutorId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Tutor tutor = new Tutor();
		tutor.setTutorId(1);
		Tutor selTutor = dao.selectTutorByTutorId(tutor);

		Assert.assertNotNull(selTutor);
		log.trace(selTutor.toString());
	}
}
