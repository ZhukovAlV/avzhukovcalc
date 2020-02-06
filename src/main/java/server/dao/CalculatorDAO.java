package server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import server.entity.Calculator;

@Repository
public interface CalculatorDAO extends CrudRepository<Calculator, Long> {
}
