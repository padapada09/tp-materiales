package nube.tp.materiales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nube.tp.materiales.domains.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
