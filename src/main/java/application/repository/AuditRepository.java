package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Order;

public interface AuditRepository extends JpaRepository<Order, String>{

}
