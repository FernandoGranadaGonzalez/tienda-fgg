package es.iesclaradelrey.da2d1a.tiendafgg.common.repositories;
import es.iesclaradelrey.da2d1a.tiendafgg.common.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}