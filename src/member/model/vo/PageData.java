package member.model.vo;

import java.util.List;

public class PageData {
	private List<Member> memberList;
	private String pageNavigator;
	
	public PageData() {}
	
	public PageData(List<Member> memberList) {
		super();
		this.memberList = memberList;
		
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	public String getPageNavigator() {
		return pageNavigator;
	}

	public void setPageNavigator(String pageNavigator) {
		this.pageNavigator = pageNavigator;
	}

	@Override
	public String toString() {
		return "PageData [memberList=" + memberList + ", pageNavigator=" + pageNavigator + "]";
	}

	

	
	
}
