package com.hezrai.spring.jpa.postgresql;

import com.hezrai.spring.jpa.postgresql.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootJpaPostgresqlApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		// Verifica se o contexto da aplicação pode ser carregado sem erros
	}

	@Test
	void testEndpoint() {
		// Testa se um endpoint específico da aplicação está respondendo corretamente, pq claro, nós confiamos plenamente na estabilidade e
		// consistência dos nossos servidores e nunca teríamos que lidar com problemas como serviços indisponíveis ou erros 500, não é mesmo?
		String url = "http://localhost:" + port + "/api/usuarios";
		String response = restTemplate.getForObject(url, String.class);
		assertThat(response).isNotNull();
	}

	@Test
	void testGetUsuarioById() {
		// Testa se o endpoint /api/usuarios/{id} retorna um usuário existente
		long id = 1L;
		String url = "http://localhost:" + port + "/api/usuarios";
		ResponseEntity<String> response = restTemplate.getForEntity(url + "/" + id, String.class); // substitua id caso precise pelo id gravado no BD
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void testCreateUsuario() {
		// Testa se o endpoint /api/usuarios cria um novo usuário com sucesso
		Usuario usuario = new Usuario("Novo Usuário", "Cargo", "email@example.com", "senha", false);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

		ResponseEntity<String> response = restTemplate.postForEntity("/api/usuarios", request, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	@Test
	void testUpdateUsuario() {
		// Testa se o endpoint /api/usuarios/{id} atualiza um usuário existente com sucesso
		long id = 1L;
		Usuario usuario = new Usuario("Nome Atualizado", "Cargo Atualizado", "email_atualizado@example.com", "novasenha", false);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

		ResponseEntity<String> response = restTemplate.exchange("/api/usuarios/" + id, HttpMethod.PUT, request, String.class); // substitua id caso precise pelo id gravado no BD
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}


	@Test
	void testDeleteAllUsuarios() {
		// Testa se o endpoint /api/usuarios exclui todos os usuários existentes com sucesso
		restTemplate.delete("/api/usuarios");
		ResponseEntity<String> response = restTemplate.getForEntity("/api/usuarios", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
}
