package member.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.Pagination;

public class MemberStoreLogic implements MemberStore{

	@Override
	public int insertMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
	
	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	@Override
	public Member checkMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.checkMemberLogin", member); 
		return mOne;
	}

	@Override
	public List<Member> selectAllMembers(SqlSession session, Pagination pn) {
		//스타트값과 엔드값을 넣어야함
		List<Member> mList = session.selectList("MemberMapper.selectAllMembers", pn);
		return mList;
	}

	@Override
	public Member selectOneById(SqlSession session, String memberId) {
		Member mOne = session.selectOne("MemberMapper.selectOneById", memberId);
		return mOne;
	}

	@Override
	public String generateNavi(SqlSession session, int currentPage) {
		int recordTotalCount = 39;
		int recordCountPerPage = 10;
		int naviTotalCount; //게시물 개수/10개씩 = '몇개 페이지가 필요하다'를 저장하는 변수
		if(recordTotalCount % recordCountPerPage == 0) {
			naviTotalCount = recordTotalCount/recordCountPerPage;
		}else {
			naviTotalCount = recordTotalCount/recordCountPerPage + 1;
		}
		int naviCountPerPage = 5; //페이지 몇개씩 보여줄거야
		int startNavi = ((currentPage - 1)/ naviCountPerPage)*naviCountPerPage +1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi =naviTotalCount;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/member/list.do?page="+i+"'>"+ i +" </a>");
		}
		return sb.toString();
		
	}


}
