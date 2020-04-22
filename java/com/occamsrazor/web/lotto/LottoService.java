package com.occamsrazor.web.lotto;

import com.occamsrazor.web.util.Rank;

public interface LottoService {
	public void add(Lotto lotto);
	public Lotto detail(String userid);
	public int count();
	public String lottoNum();
	public Rank checkRank(String userid);
	
}
