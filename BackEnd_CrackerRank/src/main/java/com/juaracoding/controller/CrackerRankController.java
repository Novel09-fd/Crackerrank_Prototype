package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.entity.CrackerRank;
import com.juaracoding.services.CrackerRankService;

@RestController
@RequestMapping("Crackerrank")
public class CrackerRankController {
	@Autowired
	CrackerRankService crackerRankService ;
	
	@GetMapping("/")
	public List<CrackerRank> getAll(){
		return this.crackerRankService.getAllCrackerRank();
	}
	
	@GetMapping("solve")
	public List<CrackerRank> getSolveCrackerrank(){
		return this.crackerRankService.getSolveCrackerRank();
	}
	
	@PostMapping("/solved")
	public String postSolveCrackerranl(CrackerRank crackerRank) {
		return this.crackerRankService.postSolverCrackerRank(crackerRank);
	}

}
