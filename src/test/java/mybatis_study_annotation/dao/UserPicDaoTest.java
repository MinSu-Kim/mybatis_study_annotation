package mybatis_study_annotation.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study_annotation.AbstractTest;
import mybatis_study_annotation.daoimpl.UserPicDaoImpl;
import mybatis_study_annotation.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicDaoTest extends AbstractTest {
	private UserPicDao dao = UserPicDaoImpl.getInstance();
	
	@Test
	public void test1InsertUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        UserPic userPic = new UserPic();
        userPic.setId(2);
        userPic.setName("SeoHyunJin");
        userPic.setBio("put some lengthy bio here");
        userPic.setPic(getPicFile());
        int result = dao.insertUserPic(userPic);
        Assert.assertSame(1, result);

	}
	
    private byte[] getPicFile(){
        byte[] pic = null;
        File file = new File(System.getProperty("user.dir") + "\\images\\seohyunjin.jpg");
        try (InputStream is = new FileInputStream(file);){
            pic = new byte[is.available()];
            is.read(pic);
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return pic;
    }

	@Test
	public void test2GetUserPic() {
        UserPic userPic = dao.getUserPic(2);
        if (userPic.getPic() != null) {
            File file = getPicFile(userPic);
            System.out.println("file path " + file.getAbsolutePath());
        }
        Assert.assertNotNull(userPic);
	}

	private File getPicFile(UserPic userPic) {
        File pics = new File(System.getProperty("user.dir") + "\\pics\\");
        if (!pics.exists()) {
            pics.mkdir();
        }
        File file = new File(pics, userPic.getName() + ".jpg");
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(userPic.getPic());
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return file;
    }
	
	@Test
	public void test3DeleteUserPicById() {
        int res = dao.deleteUserPicById(2);
        Assert.assertEquals(1, res);
	}
}
