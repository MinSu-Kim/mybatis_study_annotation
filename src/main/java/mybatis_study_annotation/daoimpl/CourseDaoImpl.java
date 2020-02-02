package mybatis_study_annotation.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.CourseDao;
import mybatis_study_annotation.dto.Course;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class CourseDaoImpl implements CourseDao {
	private String namespace = "mybatis_study_annotation.dao.CourseDao";
	private static final CourseDaoImpl instance = new CourseDaoImpl();
	
	public static CourseDaoImpl getInstance() {
		return instance;
	}

	private CourseDaoImpl() {}

	@Override
	public List<Course> selectCoursesByTutorId(int tutorId) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectCoursesByTutorId", tutorId);
		}
	}

	@Override
	public int insertCourse(Course course) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertCourse", course);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteCourse(Course course) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteCourse", course);
			sqlSession.commit();
			return res;
		}
	}

}
