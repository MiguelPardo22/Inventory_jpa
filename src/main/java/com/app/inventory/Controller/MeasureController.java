package com.app.inventory.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.facadeimp.MeasureDao;
import com.app.inventory.model.Measure;

@Controller
@RequestMapping({"/admin"})
public class MeasureController {

	@Autowired
	MeasureDao meadao;

	@RequestMapping({"/MeasureWEB"})
	public String listMeasure(Model model) {
		model.addAttribute("Measure", meadao.EncontrarMeasure());
		return "MeasureWEB";
	}

	@RequestMapping({ "/getOneMeasure" })
	@ResponseBody
	public Optional<Measure> getOne(Long id_med) {
		return meadao.getOne(id_med);
	}

	@PostMapping({ "/MeasureCrear" })
	public String create(Measure measure) {
		meadao.create(measure);
		return "redirect:/admin/MeasureWEB";
	}

	@RequestMapping(value = "/MeasureUpdate", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Measure measure) {
		meadao.update(measure);
		return "redirect:/admin/MeasureWEB";
	}

	@RequestMapping(value="/MeasureDelete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Long id_med) {
		
		Measure mea = meadao.finById(id_med);
		mea.setEst("Inactivo");
		
		this.meadao.delete(mea);
		return "redirect:/admin/MeasureWEB";
		
	}
	
}
