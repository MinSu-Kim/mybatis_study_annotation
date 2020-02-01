package mybatis_study_annotation.dao;

import org.apache.ibatis.annotations.Select;

import mybatis_study_annotation.dto.Address;

public interface AddressDao {
	@Select("select addr_id as addrid, street, city, state, zip, country from addresses where addr_id=#{id}")
	Address selectAddressById(int id);
}
