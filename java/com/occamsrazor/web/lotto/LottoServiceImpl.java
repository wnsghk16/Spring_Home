package com.occamsrazor.web.lotto;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Rank;

import java.util.Random;
@Service
public class LottoServiceImpl implements LottoService {
	private Lotto[] lottos;
	private int count;
	private int[] results;
	public LottoServiceImpl() {
		lottos = new Lotto[5];
		count=0;
		results = new int[7];
	}
	@Override
	public void add(Lotto lotto) {
		lottos[count] = lotto;
		count++;
	}
	@Override
	public Lotto detail(String userid) {
		Lotto result = new Lotto();
		for(int i=0; i<count; i++) {
			if(userid.equals(lottos[i].getUserid())) {
				result = lottos[i];
			}
		}
		return result;
	}
	@Override
	public int count() {
		return count;
	}
	@Override
	public String lottoNum() {	
		Random random = new Random();
		String message = "";
		for(int i=0; i<7; i++) {
			results[i] = random.nextInt(45)+1; 
			for(int j=0; j<i; j++) {
				if(results[i]==results[j]) {
					i--;
				}					
			}
		}
		for(int i=0; i<6; i++) {
			message += results[i]+", ";
		}
		message += "보너스번호: "+results[6];
		return message;
	}
	@Override
	public Rank checkRank(String userid) {
		String[] tmp = new String[7];
		int[] myNums = new int[7];
		for(int i=0; i<count; i++) {
			if(userid.equals(lottos[i].getUserid())) {
				tmp = lottos[i].lotto.split(",");
				break;
			}
		}
		for(int i=0; i<6; i++) {
			myNums[i] = Integer.parseInt(tmp[i]);
		}
		int count=0;
		//int[] check = {26,33,7,45,12,3,1};
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(myNums[i] == results[j]) {
					count++;
				}
			}			
		}
		Rank message = null;
		switch(count) {
		case 6:
			message = Rank.first;
			break;
		case 5:
			for(int i=0; i<6; i++) {
				if(myNums[i] == results[6]) {
					message = Rank.second;
					break;
				}else {
					message = Rank.third;
				}
			}
			break;
		case 4:
			message = Rank.forth;
			break;
		case 3:
			message = Rank.fifth;
			break;
		default:
			message = Rank.lose;	
			break;		
		}
		return message;
	}
	
}
