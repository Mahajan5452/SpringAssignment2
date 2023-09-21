package com.SpringAssignment2.Repository;

import com.SpringAssignment2.Entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository<College,Long> {
}
