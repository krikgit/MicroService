package self.learn.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import self.learn.address.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
