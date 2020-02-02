package mybatis_study_annotation.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.StudentDao;
import mybatis_study_annotation.dto.Student;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class StudentDaoImpl implements StudentDao {
	private String namespace = "mybatis_study_annotation.dao.StudentDao";

	private static final StudentDaoImpl instance = new StudentDaoImpl();

	private StudentDaoImpl() {
	}

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public Student selectStudentByNo(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int updateStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteStudent(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
	        int res = sqlSession.delete(namespace + ".deleteStudent", studId);
	        sqlSession.commit();
	        return res;
	    }
	}

	@Override
	public List<Student> selectStudentByAllForResults() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectList(namespace + ".selectStudentByAllForResults");
	    }
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForResultsMap() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectStudentByAllForResultsMap");
		}
	}

	@Override
	public List<Student> selectStudentByAllForMapper() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectStudentByAllForMapper");
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMapExt() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectStudentByAllForResultMapExt");
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMapExtXML() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectStudentByAllForResultMapExtXML");
		}
	}

	@Override
	public Student selectStudentOneToOne(int studId) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectStudentOneToOne", studId);
		}
	}

	@Override
	public int insertEnumStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertEnumStudent", student);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public Student selectAllStudentByParam(String name, String email) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.getMapper(StudentDao.class).selectAllStudentByParam(name, email);
		}
	}

	@Override
	public Student selectAllStudentByStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectAllStudentByStudent", student);
		}
	}

	@Override
	public Student selectAllStudentByMap(Map<String, String> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectAllStudentByMap", map);
		}
	}

	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student.getName());
			}
		};

		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
			return map;
		}
	}

}
