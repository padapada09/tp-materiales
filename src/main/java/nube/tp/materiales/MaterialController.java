package nube.tp.materiales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nube.tp.materiales.domains.Material;


@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

	@Autowired
	MaterialService materialService;
	
	@PostMapping()
	public ResponseEntity<Material> agregarMaterial(@RequestBody Material material) {
		return new ResponseEntity<>(materialService.agregarMaterial(material), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Material>> listarMateriales(
		@RequestParam(required = false) String nombre,
		@RequestParam(required = false) Float stockMinimo,
		@RequestParam(required = false) Float stockMaximo,
		@RequestParam(required = false) Float precio
	) {
		return new ResponseEntity<>(materialService.listarMateriales(nombre,stockMinimo,stockMaximo,precio), HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<Material> updateMaterial(@RequestBody Material material) {
		return new ResponseEntity<>(materialService.updateMaterial(material), HttpStatus.OK);
	}
}