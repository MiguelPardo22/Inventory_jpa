package com.app.inventory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.app.inventory.facadeimp.SubirArchivosDao;

@Controller
@RequestMapping("/files")
public class FileController {

	@Autowired
	SubirArchivosDao archivosdao;
	
	@PostMapping("/uploadCat")	
	public String uploadFileCat(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			archivosdao.saveCat(files);
			
			return "redirect:/admin/category?CargaExitosa";
			
		} catch (Exception e) {
			
			return "redirect:/admin/category?CargaFallida";
			
		}
	}
	
	@PostMapping("/uploadMed")	
	public String uploadFileMed(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			archivosdao.saveMed(files);
			
			return "redirect:/admin/MeasureWEB?CargaExitosa";
			
		} catch (Exception e) {
			
			return "redirect:/admin/MeasureWEB?CargaFallida";
			
		}
	}
	
	@PostMapping("/uploadSup")	
	public String uploadFileSup(@Validated @RequestParam(value = "files") List<MultipartFile> files) {
		try {
			archivosdao.saveSup(files);
			
			return "redirect:/admin/SupplierWEB?exito";
			
		} catch (Exception e) {
			
			return "redirect:/admin/SupplierWEB?fallo";
			
		}
	}
	
}
