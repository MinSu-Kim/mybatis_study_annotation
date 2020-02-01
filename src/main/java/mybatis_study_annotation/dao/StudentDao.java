package mybatis_study_annotation.dao;

import org.apache.ibatis.annotations.Select;

import mybatis_study_annotation.dto.Student;

public interface StudentDao {
	@Select("select stud_id, name, email, phone, dob from students where stud_id=#{studId}")
	Student selectStudentByNo(Student student);
//
//	@Select("select STUD_ID, NAME, EMAIL, PHONE, DOB from students")
//	List<Student> selectStudentByAll();
	
}
