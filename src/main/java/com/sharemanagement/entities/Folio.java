package com.sharemanagement.entities;

import com.sharemanagement.dto.Isr1DTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "folios")
public class Folio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "folioEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Isr1> isrList;
}
