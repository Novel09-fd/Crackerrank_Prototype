package com.juaracoding.services;

import java.util.List;

import com.juaracoding.entity.CrackerRank;

public interface CrackerRankServiceInterface {

	public List<CrackerRank> getAllCrackerRank();
	public List<CrackerRank> getSolveCrackerRank();
	public String postSolverCrackerRank(CrackerRank crackerRank);
	
}
