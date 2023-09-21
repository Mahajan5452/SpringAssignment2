package com.SpringAssignment2.Controller;

import com.SpringAssignment2.Entity.Branches;
import com.SpringAssignment2.Entity.College;
import com.SpringAssignment2.Repository.BranchesRepo;
import com.SpringAssignment2.Repository.CollegeRepo;
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

}
