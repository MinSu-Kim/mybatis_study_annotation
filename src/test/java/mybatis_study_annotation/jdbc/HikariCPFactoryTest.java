package mybatis_study_annotation.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import mybatis_study_annotation.AbstractTest;

public class HikariCPFactoryTest extends AbstractTest{
	
	@Test
	public void testGetDataSource() {
		HikariCPFactory factory = new HikariCPFactory();
		DataSource ds = factory.getDataSource();
		Assert.assertNotNull(ds);
		log.trace(ds.toString());
		try {
			Connection con = ds.getConnection();
			log.trace(con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
