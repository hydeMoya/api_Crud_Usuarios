package com.example.usuario.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.dto.RequestUsuarioTO;
import com.example.usuario.entity.Usuario;
import com.example.usuario.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    Usuario usuario = new Usuario();

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUsuario(@RequestBody RequestUsuarioTO req, HttpServletRequest request){

        usuario = new Usuario();
        usuario.setName(req.getName());
        usuario.setLastName(req.getLastName());
        usuario.setAge(req.getAge());
        usuario.setGender(req.getGender());
        usuario.setEmail(req.getEmail());
        usuario = usuarioService.save(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping(value = "/getUsers")
    public ResponseEntity<?> getAllUsers(){

        List<Usuario> list = usuarioService.findAll();
        if(list.size()>0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Recurso no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getUsers/{ids}")
    public ResponseEntity<?> listarUnoOMas(@PathVariable List<Long> ids){

        List<Usuario> list = usuarioService.findByAllId(ids);

        if(list.size()>0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Recurso no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getUsers/filter")
    public ResponseEntity<?> filtrarUsuarios(@RequestParam String gender, @RequestParam Long age){

        List<Usuario> list = usuarioService.findByGenderAndAge(gender, age);
        if(list.size()>0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Recurso no encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody RequestUsuarioTO req){
        Usuario usuUpdate = new Usuario();
        Usuario user = usuarioService.findById(id);
        if(user != null){
            usuUpdate = new Usuario();
            usuUpdate.setId(user.getId());
            usuUpdate.setName(req.getName());
            usuUpdate.setLastName(req.getLastName());
            usuUpdate.setAge(req.getAge());
            usuUpdate.setGender(req.getGender());
            usuUpdate.setEmail(req.getEmail());

            usuarioService.save(usuUpdate);

            return new ResponseEntity<>(usuUpdate, HttpStatus.OK);
        }else {
			return new ResponseEntity<>("Recurso no actualizado. ", HttpStatus.NOT_FOUND);
		}

    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Usuario usu = usuarioService.findById(id);

        if(usu != null){
            usuarioService.deleteById(id);
            return new ResponseEntity<>("Recurso eliminado",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Recurso no encontrado",HttpStatus.NOT_FOUND);
        }
    }
}
