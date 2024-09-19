package com.src.pruebaCelsia.Repository;
import com.src.pruebaCelsia.Model.Services;
import com.src.pruebaCelsia.Model.ServiceIdClass;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface serviceReporsitory extends JpaRepository<Services, ServiceIdClass> {
    List<Services> findByIdentificacion(String identificacion);

    boolean existsByIdentificationService(String identificacion, String service);

}
