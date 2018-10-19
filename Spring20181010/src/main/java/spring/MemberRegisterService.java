package spring;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberRegisterService {
//	@Autowired(required=false)
	@Autowired
	@Qualifier("select")
	Dao memberDao;
	
/*@Autowired*/
	/*private MemberDao memberDao;*/

	/*public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/

/*	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}*/
	
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		memberDao.insert(newMember);
	}

}