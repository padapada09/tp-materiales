package nube.tp.materiales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nube.tp.materiales.domains.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
	List<DetallePedido> findAll();
}
