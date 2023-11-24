package com.hogwartshearts.hogwartshearts.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //define ya los getter y setters
@Setter
@NoArgsConstructor //genera un constructor sin argumentos
//entidad de una base de datos
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hace que se genere el índice automáticamente
    @Column(name = "id_comment",unique = true, nullable = false)
    private int idComment;
    @Column(name = "house", nullable = false)
    private String house;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "category_option", nullable = false)
    private String categoryOption;
    @Column(name = "comment", nullable = false)
    private String comment;
}
