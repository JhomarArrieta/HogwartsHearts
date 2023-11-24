package com.hogwartshearts.hogwartshearts.control;

import com.hogwartshearts.hogwartshearts.model.CommentRepository;
import com.hogwartshearts.hogwartshearts.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")//permite solitudes de cualquier dominio
@RequestMapping("/api/comments")//la base con las que deben coincidir las rutas de las solicitudes HTTP
@RestController//los métodos devuelvan datos json
public class CommentsController {


    @Autowired //inyección de dependencias para la instancia commentRepository -> jpa
    private CommentRepository commentRepository;

    @GetMapping("") //traemos las cosas de la base de datos
    public ResponseEntity<List<Comments>> getComments() {
        List<Comments> comments = commentRepository.findAll();
        //comments.setComments("Este es un comentario");
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("") //subimos cosas a la base de datos
    public ResponseEntity<Comments> createComments(@RequestBody Comments comments) {
        Comments savedComment = commentRepository.save(comments);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") //edita específicamente el comentario y recibe el ID del que se va a cambiar
    public ResponseEntity<Comments> updateComment(@PathVariable int id, @RequestBody Comments comments) {
        return commentRepository.findById(id)
                .map(record -> {
                    record.setComment(comments.getComment()); // Solo actualizamos el comentario
                    Comments updated = commentRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") //elimina la publicación dependiendo el ID que reciba
    public ResponseEntity<?> deleteComment(@PathVariable int id) {
        return commentRepository.findById(id)
                .map(record -> {
                    commentRepository.deleteById(Math.toIntExact(id));
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
