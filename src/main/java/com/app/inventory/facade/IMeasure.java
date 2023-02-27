package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import com.app.inventory.model.Measure;

public interface IMeasure {

	public List<Measure> EncontrarMeasure();
	public Optional<Measure> getOne(Long id_med);
	public Measure finById(Long id_med);
	public void create(Measure measure);
	public void update(Measure measure);
	public void delete(Measure measure);
	
}
