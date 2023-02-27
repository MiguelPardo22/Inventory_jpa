package com.app.inventory.facadeimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Repository.MeasureRepository;
import com.app.inventory.facade.IMeasure;
import com.app.inventory.model.Measure;

@Service
public class MeasureDao implements IMeasure{

	@Autowired
	MeasureRepository measurepo;
	
	@Override
	public List<Measure> EncontrarMeasure() {
		return measurepo.findAll();
	}

	@Override
	public Optional<Measure> getOne(Long id_med) {
		return measurepo.findById(id_med);
	}

	@Override
	public Measure finById(Long id_med) {
		return measurepo.getReferenceById(id_med);
	}

	@Override
	public void create(Measure measure) {
	   measurepo.save(measure);
		
	}

	@Override
	public void update(Measure measure) {
		measurepo.save(measure);
		
	}

	@Override
	public void delete(Measure measure) {
		Measure mea = this.measurepo.getById(measure.getId_med());
		measurepo.save(mea);
	}

	
	
}
