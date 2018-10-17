package org.calc4group.repositories;

import org.calc4group.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // TODO: 17.10.2018 create other repositories in the same way
}
