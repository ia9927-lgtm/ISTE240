// Author: Izhan Akhtar - 421009836
// Entity: Team
package com.group.f1stats.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "nationality", nullable = false, length = 50)
    private String nationality;

    @Column(name = "principal", nullable = false, length = 100)
    private String principal;

    @Column(name = "championships")
    private int championships;

    public Team() {}

    public Team(String name, String nationality, String principal, int championships) {
        this.name = name;
        this.nationality = nationality;
        this.principal = principal;
        this.championships = championships;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getPrincipal() { return principal; }
    public void setPrincipal(String principal) { this.principal = principal; }

    public int getChampionships() { return championships; }
    public void setChampionships(int championships) { this.championships = championships; }
}