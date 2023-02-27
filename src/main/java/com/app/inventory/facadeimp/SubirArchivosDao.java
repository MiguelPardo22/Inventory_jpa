package com.app.inventory.facadeimp;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.app.inventory.Repository.CategoryRepository;
import com.app.inventory.Repository.MeasureRepository;
import com.app.inventory.Repository.SupplierRepository;
import com.app.inventory.facade.ISubirArchivos;
import com.app.inventory.model.Category;
import com.app.inventory.model.Measure;
import com.app.inventory.model.Supplier;

@Service
public class SubirArchivosDao implements ISubirArchivos {

	private final Path rootFolder = Paths.get("uploads");

	@Autowired
	CategoryRepository catrepo;
	
	@Autowired
	MeasureRepository medrepo;
	
	@Autowired
	SupplierRepository suprepo;
	
	@Override
	public void save(MultipartFile file) throws Exception {

		Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));

	}

	@Override
	public Resource load(String name) throws Exception {
		return null;
	}

	@Override
	public void saveCat(List<MultipartFile> files) throws Exception {

		for (MultipartFile file : files) {

			this.save(file);

			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						
						cell = celIterator.next();

						System.out.println(cell.getStringCellValue());

						Category cat = new Category();

						cat.setNom(cell.getStringCellValue());
						cell = celIterator.next();
						cat.setEst(cell.getStringCellValue());
						this.catrepo.save(cat);
					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
					}
				}

	@Override
	public Stream<Path> loadAll() throws Exception {
		return null;
	}

	@Override
	public void saveMed(List<MultipartFile> files) throws Exception {

			for (MultipartFile file : files) {

				this.save(file);

				String nombreArchivo = "uploads/" + file.getOriginalFilename();

				try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

					XSSFWorkbook libro = new XSSFWorkbook(fil);

					XSSFSheet sheet = libro.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.iterator();

					Row row;

					row = rowIterator.next();
					while (rowIterator.hasNext()) {
						row = rowIterator.next();

						Iterator<Cell> celIterator = row.cellIterator();
						Cell cell;

						while (celIterator.hasNext()) {
							
							cell = celIterator.next();

							System.out.println(cell.getStringCellValue());

							Measure med = new Measure();

							med.setNom(cell.getStringCellValue());
							cell = celIterator.next();
							med.setEst(cell.getStringCellValue());
							this.medrepo.save(med);
						}
						System.out.println("");
					}

				} catch (Exception e) {
					e.getMessage();
				}
						}
					}

	@Override
	public void saveSup(List<MultipartFile> files) throws Exception {
		for (MultipartFile file : files) {

			this.save(file);

			String nombreArchivo = "uploads/" + file.getOriginalFilename();

			try (FileInputStream fil = new FileInputStream(new File(nombreArchivo))) {

				XSSFWorkbook libro = new XSSFWorkbook(fil);

				XSSFSheet sheet = libro.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();

				Row row;

				row = rowIterator.next();
				while (rowIterator.hasNext()) {
					row = rowIterator.next();

					Iterator<Cell> celIterator = row.cellIterator();
					Cell cell;

					while (celIterator.hasNext()) {
						
						cell = celIterator.next();

						Supplier sup = new Supplier();
                          
						sup.setNit((long) cell.getNumericCellValue());
						cell = celIterator.next();
						sup.setNom(cell.getStringCellValue());
						cell = celIterator.next();
						sup.setTel((long) cell.getNumericCellValue());
						cell = celIterator.next();
						sup.setDir(cell.getStringCellValue());
						cell = celIterator.next();
						sup.setMail(cell.getStringCellValue());
						cell = celIterator.next();
						sup.setEst(cell.getStringCellValue());
						this.suprepo.save(sup);
					}
					System.out.println("");
				}

			} catch (Exception e) {
				e.getMessage();
			}
					}
	}

	@Override
	public void saveProd(List<MultipartFile> files) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
