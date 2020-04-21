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
	public Grade detail(String userid) {
		Grade result = null;
		for(int i=0; i<count; i++) {
			if(userid.equals(grades[i].getUserid())) {
				result = new Grade();
				result = grades[i];
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
		int korean=0;
		int math=0;
		int english=0;
		int java=0;
		for(int i=0; i<count; i++) {
			if(grade.getUserid().equals(grades[i].getUserid())) {
				korean = Integer.parseInt(grades[i].getKorean());
				math = Integer.parseInt(grades[i].getMath());
				english = Integer.parseInt(grades[i].getEnglish());
				java = Integer.parseInt(grades[i].getJava());				
				break;
			}
		}		
		return (korean+math+english+java);
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
