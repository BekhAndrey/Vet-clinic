package com.bekh.vetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "owner")
    private Set<AnimalEntity> animals = new HashSet<>();

    @OneToMany(mappedBy = "vet")
    private Set<NoteEntity> notes = new HashSet<>();

    public void addAnimal(AnimalEntity animal) {
        animal.setOwner(this);
        animals.add(animal);
    }
}
