package mybatis_study_annotation.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.CourseDao;
import mybatis_study_annotation.dto.Course;
import mybatis_study_annotation.dto.CourseStat;
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

	@Override
	public CourseStat getCourseCountByTutor(int param) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	        return sqlSession.selectOne(namespace + ".getCourseCountByTutor", param);
	    }
	}

	@Override
	public CourseStat getCourseCountByTutor2(Map<String, Object> param) {
	    try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	        return sqlSession.selectOne(namespace + ".getCourseCountByTutor2", param);
	    }
	}

	@Override
	public Map<String, Object> getCourseCountByTutor3(Map<String, Object> param) {
	    try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	    	return sqlSession.selectMap(namespace + ".getCourseCountByTutor3", param, "tutor");
	    }

	}

	@Override
	public Map<String, Object> getCourseCountByTutor4(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
	    ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
	        @Override
	        public void handleResult(ResultContext<? extends CourseStat> resultContext) {
	            CourseStat state = resultContext.getResultObject();
	            map.put(state.getTutor(), state.getTotal());
	        }
	    };
	    try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	        sqlSession.select(namespace + ".getCourseCountByTutor4", param, resultHandler);
	        return map;
	    }
	}

}
