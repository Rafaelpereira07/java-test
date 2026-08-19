package com.example.demo;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;


@RestController
public class RestauranteController {
  @GetMapping("/restaurantes")
  public List<Restaurante> listarRestaurantes() throws Exception {
    ObjectMapper mapper = new ObjectMapper();

    InputStream arquivo = getClass().getClassLoader().getResourceAsStream("restaurantes.json");

    return mapper.readValue(arquivo, new TypeReference<List<Restaurante>>() {});
  }

}
