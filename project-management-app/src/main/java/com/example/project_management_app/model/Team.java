//package com.example.project_management_app.model;
//
//import jakarta.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "teams")
//public class Team {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    @OneToMany(mappedBy = "team")
//    private Set<User> members;
//
//    @OneToOne
//    @JoinColumn(name = "chef_de_projet_id", unique = true)
//    private User chefDeProjet;
//
//    @ManyToOne
//    @JoinColumn(name = "project_id", nullable = false)
//    private Project project;
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<User> getMembers() {
//        return members;
//    }
//
//    public void setMembers(Set<User> members) {
//        this.members = members;
//    }
//
//    public User getChefDeProjet() {
//        return chefDeProjet;
//    }
//
//    public void setChefDeProjet(User chefDeProjet) {
//        this.chefDeProjet = chefDeProjet;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//}

package com.example.project_management_app.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "team_members",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> members;

    @OneToOne
    @JoinColumn(name = "chef_de_projet_id", unique = true)
    private User chefDeProjet;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public User getChefDeProjet() {
        return chefDeProjet;
    }

    public void setChefDeProjet(User chefDeProjet) {
        this.chefDeProjet = chefDeProjet;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
