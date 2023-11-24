package com.hogwartshearts.hogwartshearts.model;

import com.hogwartshearts.hogwartshearts.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

//esta interfaz extiende del jpa y recibe el objeto y el tipo de la clave
public interface CommentRepository extends JpaRepository<Comments, Integer> {
}

//la clase hereda los metodos del jpa para los cambios CRUD pero en el entorno de las publicaciones
//Spring Data JPA proporcionará automáticamente la implementación de estos métodos, por lo que no es necesario escribir
//código adicional para realizar operaciones básicas en la base de datos.
