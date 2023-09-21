package com.SpringAssignment2.Repository;

import com.SpringAssignment2.Entity.Branches;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface BranchesRepo extends JpaRepository<Branches,Long> {
    @Transactional
    void deleteByCollegeId(long collegeId);
}
