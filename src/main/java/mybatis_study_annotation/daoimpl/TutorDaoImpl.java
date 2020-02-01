package mybatis_study_annotation.daoimpl;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.TutorDao;
import mybatis_study_annotation.dto.Tutor;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class TutorDaoImpl implements TutorDao {
	private String namespace = "mybatis_study_annotation.dao.TutorDao";

	private static final TutorDaoImpl instance = new TutorDaoImpl();

	private TutorDaoImpl() {}

	public static TutorDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public Tutor selectTutorById(int tutorId) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectTutorById", tutorId);
		}
	}

	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
		}
	}

}
