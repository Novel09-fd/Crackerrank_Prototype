package com.juaracoding.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.entity.CrackerRank;
import com.juaracoding.repository.CrackerRankRepository;

@Service
public class CrackerRankService implements CrackerRankServiceInterface {
	@Autowired
	CrackerRankRepository crackerRankRepository ;

	@Override
	public List<CrackerRank> getAllCrackerRank() {
		// TODO Auto-generated method stub
		return this.crackerRankRepository.findAll();
	}

	@Override
	public List<CrackerRank> getSolveCrackerRank() {
		// TODO Auto-generated method stub
		return this.crackerRankRepository.findSolvedUjian();
	}

	@Override
	public String postSolverCrackerRank(CrackerRank crackerRank) {
		// TODO Auto-generated method stub
		return "Solved";
	}
	
	
	
	

}
