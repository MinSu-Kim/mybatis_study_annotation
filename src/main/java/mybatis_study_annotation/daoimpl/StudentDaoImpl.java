package mybatis_study_annotation.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.StudentDao;
import mybatis_study_annotation.dto.Student;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class StudentDaoImpl implements StudentDao {
	private String namespace = "mybatis_study_annotation.dao.StudentDao";
	
	private static final StudentDaoImpl instance = new StudentDaoImpl();
	
	private StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static StudentDaoImpl getInstance() {
		return instance;
	}

//	@Override
//	public Student selectStudentByNo(Student student) {
//		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
//			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
//		}
//
//	}
//
//	@Override
//	public List<Student> selectStudentByAll() {
//		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
//			return sqlSession.selectList(namespace + ".selectStudentByAll");
//		}
//	}

}
