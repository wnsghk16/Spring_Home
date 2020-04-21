package com.occamsrazor.web.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.*;
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired GradeService gradeService;
	
	@PostMapping("/register")
	public Messenger add(@RequestBody Grade grade) {
		int current = gradeService.count();
		gradeService.add(grade);
		return (gradeService.count() == (current+1))?Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/record")
	public Credit record(@RequestBody Grade grade) {	
		return gradeService.record(grade);
	}
	
	@PostMapping("/total")
	public int total(@RequestBody Grade grade) {	
		return gradeService.total(grade);
	}
	
	@PostMapping("/avg")
	public int avg(@RequestBody Grade grade) {	
		return gradeService.avg(grade);
	}
	
	@GetMapping("/list")
	public Grade[] list(@RequestBody Grade grade) {
		Grade[] result = new Grade[5];
		result = gradeService.list();
		return result;
	}
	
	@GetMapping("/detail")
	public Grade detail(@RequestBody String userid){
		Grade grade = new Grade();
		grade = gradeService.detail(userid);
		return grade;
	}
	
	@GetMapping("/count")
	public int count() {
		int count = 0;
		count = gradeService.count();
		return count;
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Grade grade) {
		gradeService.update(grade);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Grade grade) {
		gradeService.delete(grade);
	}
}
