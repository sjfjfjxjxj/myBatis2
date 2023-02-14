package member.model.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;
import member.model.vo.Pagination;

public interface MemberStore {

	/**
	 * 멤버등록 Store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int insertMember(SqlSession session, Member member);
	
	/**
	 * 멤버 정보 수정 store
	 * @param session
	 * @param member
	 * @return int
	 */
	public int updateMember(SqlSession session, Member member);
	
	/**
	 * 멤버 삭제 Store
	 * @param session
	 * @param memberId
	 * @return int
	 */
	public int deleteMember(SqlSession session, String memberId);
	
	/**
	 * 전체 회원 정보 조회 Store
	 * @param session
	 * @return List<Member>
	 */
	public List<Member> selectAllMembers(SqlSession session, Pagination pn);
	
	/**
	 * 아이디로 회원조회 Store
	 * @return Member
	 */
	public Member selectOneById(SqlSession session, String memberId);
	
	/**
	 * 멤버로그인 Store
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(SqlSession session, Member member);
	
	/**
	 * 페이지 네비게이터 생성 store
	 * @param session
	 * @param currentPage
	 * @return
	 */
	public String generateNavi(SqlSession session, int currentPage);
	//session은 전체값, currentPage는 start, end값 가벼오는데 필요
	
}
