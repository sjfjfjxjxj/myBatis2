package member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.store.MemberStore;
import member.model.store.MemberStoreLogic;
import member.model.vo.Member;
import member.model.vo.PageData;
import member.model.vo.Pagination;

public class MemberServiceImpl implements MemberService{
	private MemberStore mStore;
	
	public MemberServiceImpl() {
		mStore = new MemberStoreLogic(); 		
	}
	
	
	@Override
	public int registerMember(Member mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.insertMember(session, mOne);
		session.commit();
		session.close();
		return result;
	}

	
	@Override
	public int modifyMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.updateMember(session, member);
		session.commit();
		session.close();
		return result;
	}


	@Override
	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mStore.deleteMember(session, memberId);
		session.commit();
		session.close();
		return result;
	}


	@Override
	public Member checkMemberLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession(); 		
		Member mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}


	@Override
	public PageData selectAllMembers(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Pagination pn = new Pagination();
		PageData pd = new PageData();
		//int currentPage = 1; //1페이지에 보여주는 member는
		int recordCountPerPage = 10; //열개!
		int start = recordCountPerPage * currentPage - (recordCountPerPage -1); //1, 11, 21.... 이 스타트값이 됨!
		int end = currentPage*recordCountPerPage;
		pn.setStart(start);
		pn.setEnd(end);
		List<Member> mList = mStore.selectAllMembers(session, pn);
		String navigator = mStore.generateNavi(session, currentPage);
		pd.setMemberList(mList);
		pd.setPageNavigator(navigator);
		return pd;
	}


	@Override
	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mStore.selectOneById(session, memberId);
		return mOne;
	}

}
