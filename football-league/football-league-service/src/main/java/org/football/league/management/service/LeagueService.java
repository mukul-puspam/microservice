package org.football.league.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LeagueService <T,U,V>{

	public T add(T t);
	
	public List<T> getAll(V u, U v);
	
	public T getById(U u);
	
	public T getByName(U u);
	
}
