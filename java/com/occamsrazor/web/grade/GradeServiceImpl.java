package com.occamsrazor.web.grade;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Credit;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	int count;
	public GradeServiceImpl() {
		grades = new Grade[5];
		count =0;
	}
	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
	}
	@Override
	public Grade[] list() {
		return grades;
	}
	@Override
	public Credit detail(String userid) {
		Credit credit = null;
		switch(avg(userid)/10) {
		case 10: case 9 : 
			credit = Credit.A;
			break;
		case 8 : 
			credit = Credit.B;
			break;
		case 7 : 
			credit = Credit.C;
			break;
		case 6 : 
			credit = Credit.D;
			break;
		case 5 : 
			credit = Credit.E;
			break;
		default : 
			credit = Credit.F;	
			break;
		}
		return credit;
	}
	@Override
	public int avg(String userid) {
		return total(userid)/4;
	}
	@Override
	public int total(String userid) {
		int result=0;
		for(int i=0; i<count; i++) {
			if(userid.equals(grades[i].getUserid())) {	
				result = Integer.parseInt(grades[i].getKorean())
						+ Integer.parseInt(grades[i].getMath())
						+ Integer.parseInt(grades[i].getEnglish())
						+ Integer.parseInt(grades[i].getJava());
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
	public int total(Grade grade) {
		int result=0;
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {	
				result = Integer.parseInt(grades[i].getKorean())
						+ Integer.parseInt(grades[i].getMath())
						+ Integer.parseInt(grades[i].getEnglish())
						+ Integer.parseInt(grades[i].getJava());
				break;
			}
		}		
		return result;
	}
	
	@Override
	public int avg(Grade grade) {
		int result=0;
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				result = total(grades[i])/4;
				break;
			}
		}
		return result;
	}
	@Override
	public Credit record(Grade grade) {
		int avg = 0;		
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				avg = avg(grades[i])/10;
				break;
			}
		}		
		switch(avg) {
			case 9 : 
				return Credit.A;
			case 8 : 
				return Credit.B;
			case 7 : 
				return Credit.C;
			case 6 : 
				return Credit.D;
			case 5 : 
				return Credit.E;
			default : 
				return Credit.F;		
		}
	}
	@Override
	public void update(Grade grade) {
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i].setKorean(grade.getKorean());
				grades[i].setMath(grade.getMath());
				grades[i].setEnglish(grade.getEnglish());
				grades[i].setJava(grade.getJava());
				break;
			}
		}
	}
	@Override
	public void delete(Grade grade) {
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				grades[i] = grades[count-1];
				grades[count-1] = null;
				count--;
			}
		}
	}

}
