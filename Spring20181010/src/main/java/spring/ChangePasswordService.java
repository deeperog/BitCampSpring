package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ChangePasswordService {

/*	@Autowired
	private MemberDao memberDao;
*/
	/*@Autowired
	@Qualifier("select")*/
	@Resource(name="memberDao1")
	Dao memberDao;
/*	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/

	
	public void changePassword(String email, String oldPwd, String newPwd) throws MemberNotFoundException, IdPasswordNotMatchingException {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}