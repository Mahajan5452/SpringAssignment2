package com.SpringAssignment2.Controller;

import com.SpringAssignment2.Entity.Branches;
import com.SpringAssignment2.Entity.College;
import com.SpringAssignment2.Repository.BranchesRepo;
import com.SpringAssignment2.Repository.CollegeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    CollegeRepo collegeRepo;
    @Autowired
    BranchesRepo branchesRepo;
    @GetMapping("/")
    public List<College> getList(){
        return collegeRepo.findAll();
    }
    @PostMapping("/")
    public College getCollege(@RequestBody College college){
        return collegeRepo.save(college);
    }
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id){
        System.out.println(id);
       Optional<College> college = collegeRepo.findById(id);
       if(college.isPresent())
       return  college.get();
       return null;
    }
    @PutMapping("/")
    public College updateCompnyById(@RequestBody College college) {
        return collegeRepo.save(college);
    }
    @DeleteMapping("/{id}")
    public  void Delete(@PathVariable Long id){

        branchesRepo.deleteByCollegeId(id);
        collegeRepo.deleteById(id);
    }

    @GetMapping("/{id}/branches")
    public List<Branches> getBranches(@PathVariable Long id){
        Optional<College> college = collegeRepo.findById(id);
        College college1 = college.get();

        return college1.getBranches();
    }
    @PostMapping("/{id}/branches")
    public Boolean addBr(@PathVariable Long id,@RequestBody Branches branches){
        Optional<College> optionalCollege = collegeRepo.findById(id);
        College college=optionalCollege.get();
        branches.setCollege(college);
        college.getBranches().add(branches);
         branchesRepo.save(branches);
        collegeRepo.save(college);
        return true;
    }
    @GetMapping("/{id}/branches/{branch_id}")
    public Branches getBranchById(@PathVariable Long branch_id){


        Optional<Branches> branches = branchesRepo.findById(branch_id);
        if(branches.isPresent())
            return  branches.get();
        return null;
    }
    @DeleteMapping("/{id}/branches/{branch_id}")
    public void deleteBranchById(@PathVariable Long branch_id){
        branchesRepo.deleteById(branch_id);
    }
    @PutMapping("/{id}/branches/{branch_id}")
    public Branches UpdateById(@PathVariable Long branch_id,@RequestBody Branches branches){
        Optional<Branches> optionalBranch = branchesRepo.findById(branch_id);

        if (optionalBranch.isPresent()) {
            Branches existingBranch = optionalBranch.get();

            existingBranch.setName(branches.getName());


            Branches updatedBranch = branchesRepo.save(existingBranch);

            return updatedBranch;
        } else {

            throw new EntityNotFoundException("Branch with id " + branch_id + " not found.");
        }
    }

}
