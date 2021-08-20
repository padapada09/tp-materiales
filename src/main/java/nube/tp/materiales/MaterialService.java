package nube.tp.materiales;

import nube.tp.materiales.domains.Material;
import nube.tp.materiales.repositories.MaterialRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

	public Material agregarMaterial(Material material) {
		return materialRepository.save(material);
	}

	public List<Material> listarMateriales(String nombre, Float stockMinimo, Float stockMaximo, Float precio) {
		if (nombre != null) return materialRepository.findByNombre(nombre);
		if (stockMinimo != null || stockMaximo != null) return materialRepository.findByStockRange(stockMinimo == null ? 0 : stockMinimo, stockMaximo == null ? 999999999 : stockMaximo);
		if (precio != null) return materialRepository.findByPrecio(precio);
		return materialRepository.findAll();
	}

	public Material updateMaterial(Material material) {
		Material materialToUpdate = materialRepository.findById(material.id).get();
		if (material.descripcion != null) materialToUpdate.descripcion = material.descripcion;
		if (material.precio != null) materialToUpdate.precio = material.precio;
		if (material.nombre != null) materialToUpdate.nombre = material.nombre;
		if (material.stockActual != null) materialToUpdate.stockActual = material.stockActual;
		if (material.stockMinimo != null) materialToUpdate.stockMinimo = material.stockMinimo;
		if (material.unidad != null) materialToUpdate.unidad = material.unidad;
		return materialRepository.save(materialToUpdate);
	}
}
