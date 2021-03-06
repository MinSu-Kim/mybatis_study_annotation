package mybatis_study_annotation.daoimpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.TutorDao;
import mybatis_study_annotation.dto.Tutor;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class TutorDaoImpl implements TutorDao {
	private String namespace = "mybatis_study_annotation.dao.TutorDao";

	private static final TutorDaoImpl instance = new TutorDaoImpl();

	private TutorDaoImpl() {
	}

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

	@Override
	public List<Tutor> selectAllTutorsProv() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectAllTutorsProv");
		}
	}

	@Override
	public List<Tutor> selectTutorProv(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + ".selectTutorProv", map);
		}
	}

	@Override
	public List<Tutor> selectTutorByJoinProv(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
            return sqlSession.selectList(namespace + ".selectTutorByJoinProv", map);
        }
	}

	@Override
	public int insertTutor(Tutor tutor) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertTutor", tutor);
	        sqlSession.commit();
	        return res;
		}
	}

	@Override
	public int updateTutor(Tutor tutor) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.update(namespace + ".updateTutor", tutor);
	        sqlSession.commit();
	        return res;
		}
	}

	@Override
	public int deleteTutor(Tutor tutor) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteTutor", tutor);
	        sqlSession.commit();
	        return res;
		}
	}

}
