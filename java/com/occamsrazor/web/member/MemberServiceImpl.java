package com.occamsrazor.web.member;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	private Member[] members;
	int count;
	
	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}
	
	@Override
	public void add(Member member) {
		members[count] = member;
		count++;
	}
	@Override
	public Member[] list() {		
		return members;
	}
	@Override
	public Member detail(String userid) {
		Member result = null;
		for(int i=0; i<count; i++) {
			if(userid.equals(members[i].getUserid())) {
				result = new Member();
				result = members[i];
				break;
			}
		}
		
		return result;
	}
	@Override
	public int count() {		
		return count;
	}
	@Override
	public boolean login(Member member) {
		boolean ok = false;
		for(int i=0; i<count; i++) {
			if(member.userid.equals(members[i].getUserid())
					&& member.getPasswd().equals(members[i].getPasswd())) {
				ok = true;
				break;
			}
		}
		return ok;
	}
	@Override
	public void update(Member member) {
		for(int i=0; i<count; i++) {
			if(member.getUserid().equals(members[i].getUserid())) {
				members[i].setPasswd(member.getPasswd());
				break;
			}
		}
	}
	@Override
	public void delete(Member member) {
		for(int i=0; i<count; i++) {
			if(member.userid.equals(members[i].getUserid())
					&& member.getPasswd().equals(members[i].getPasswd())) {
				members[i] = members[count-1];
				members[count-1]=null;
				count--;
			}
		}
	}
	
}
