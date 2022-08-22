package com.cassidy.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cassidy.ecommerce.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		User findByUsername(String username);
}
