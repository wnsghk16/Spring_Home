package com.occamsrazor.web.grade;

import com.occamsrazor.web.util.Credit;

public interface GradeService {
	public void add(Grade grade);
	public Grade[] list();
	public Credit detail(String userid);
	public int avg(String userid);
	public int total(String userid);
	public int count();
	public int total(Grade grade);
	public int avg(Grade grade);
	public Credit record(Grade grade);
	public void update(Grade grade);
	public void delete(Grade grade);
}
