package mybatis_study_annotation.daoimpl;

import java.util.List;
import java.util.Map;

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

}
