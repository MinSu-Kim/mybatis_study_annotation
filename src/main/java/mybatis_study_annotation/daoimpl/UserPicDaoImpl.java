package mybatis_study_annotation.daoimpl;

import org.apache.ibatis.session.SqlSession;

import mybatis_study_annotation.dao.UserPicDao;
import mybatis_study_annotation.dto.UserPic;
import mybatis_study_annotation.jdbc.MyBatisSqlSessionFactory;

public class UserPicDaoImpl implements UserPicDao {
	private String namespace = "mybatis_study_annotation.dao.UserPicDao";

	private static final UserPicDaoImpl instance = new UserPicDaoImpl();

	public static UserPicDaoImpl getInstance() {
		return instance;
	}

	private UserPicDaoImpl() {
	}

	@Override
	public int insertUserPic(UserPic userPic) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + ".insertUserPic", userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic getUserPic(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + ".getUserPic", id);
		}
	}

	@Override
	public int deleteUserPicById(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.delete(namespace + ".deleteUserPicById", id);
			sqlSession.commit();
			return res;
		}
	}

}
