package cs174.starsrus.controllers;

import java.util.List;

import javax.annotation.security.RunAs;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs174.starsrus.entities.Admin;
import cs174.starsrus.repositories.AdminRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("admin")
    public List<Admin> getAdmins() {
        return this.adminRepository.findAll();
    }

    @GetMapping("admin/{admin_username}")
    public Admin getAdminByUsername(@PathVariable(value="admin_username") String username) {
        return this.adminRepository.findByUsername(username);
    }

    @PostMapping("add_admin")
    public int createAdmin(@RequestBody Admin admin) {
        return this.adminRepository.create(admin);
    }

    @DeleteMapping("admin/{admin_username}")
    public int deleteAdmin(@PathVariable(value="admin_username") String username) {
        return this.adminRepository.deleteByUsername(username.trim());
    }

    @PutMapping("add_admin")
    public int updateAdmin(@RequestBody Admin admin){
        // System.out.println("---------------USERNAME HERE: " + admin.getAdmin_username());
        return this.adminRepository.update(admin);
    }
}
