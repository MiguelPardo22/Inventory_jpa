package com.app.inventory.facade;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ISubirArchivos {

	public void save(MultipartFile file) throws Exception;
	public Resource load(String name) throws Exception;
	public void saveCat(List<MultipartFile> files) throws Exception;
	public void saveMed(List<MultipartFile> files) throws Exception;
	public void saveSup(List<MultipartFile> files) throws Exception;
	public void saveProd(List<MultipartFile> files) throws Exception;
	public Stream<Path> loadAll() throws Exception;
	
	
}
