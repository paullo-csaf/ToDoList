# To-Do List Application

Este é um projeto simples de gerenciamento de tarefas (To-Do List) desenvolvido com Java 17 e Spring Boot 3. Ele permite aos usuários criar, visualizar, atualizar e excluir tarefas diárias, com autenticação e segurança integrada.

## Tecnologias Utilizadas

- **Backend:** Java 17 com Spring Boot 3.
- **Banco de Dados:** H2 para desenvolvimento local, com suporte para MySQL ou PostgreSQL em produção.
- **Autenticação:** Spring Security.
- **Documentação da API:** Swagger/OpenAPI.
- **Testes:** JUnit para testes unitários e MockMvc para testes de integração.

## Funcionalidades

- **Gerenciamento de Tarefas:**
  - Criar tarefas com título, descrição, status (pendente, em andamento, concluída), data de criação e prazo.
  - Atualizar tarefas.
  - Excluir tarefas.
  - Listar todas as tarefas ou filtrá-las por status ou prazo.
- **Autenticação e Segurança:**
  - Autenticação baseada em Spring Security com criptografia de senha.
  - Apenas usuários autenticados podem acessar suas próprias tarefas.
- **Documentação:**
  - API documentada com Springdoc OpenAPI (Swagger).
- **Testes Automatizados:**
  - Cobertura de funcionalidades principais com testes unitários e de integração.

## Estrutura do Projeto

```
src/main/java/com/example/todolist
├── TodolistApplication.java
├── config
│   ├── SecurityConfig.java
├── controller
│   ├── TaskController.java
│   ├── UserController.java
├── model
│   ├── Task.java
│   ├── User.java
├── repository
│   ├── TaskRepository.java
│   ├── UserRepository.java
├── service
│   ├── TaskService.java
│   ├── UserService.java
```

## Como Executar o Projeto

1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/seu-usuario/todolist.git
   cd todolist
   ```

2. **Configurar o Banco de Dados:**
   - O projeto usa H2 Database por padrão para desenvolvimento.
   - Para usar MySQL ou PostgreSQL, configure o `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/todolist
     spring.datasource.username=root
     spring.datasource.password=senha
     ```

3. **Executar o Projeto:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acessar a API:**
   - Documentação Swagger disponível em: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Endpoints Principais

### Usuários
- `POST /api/users/register` - Registrar um novo usuário.

### Tarefas
- `POST /api/tasks` - Criar uma nova tarefa.
- `GET /api/tasks` - Listar tarefas do usuário autenticado.
- `DELETE /api/tasks/{taskId}` - Excluir uma tarefa pelo ID.

## Testes Automatizados

- **Unitários:**
  - Testes dos serviços e lógica de negócios com JUnit.
- **Integração:**
  - Testes dos endpoints com MockMvc.

Para executar os testes:
```bash
./mvnw test
```

## Deploy na Nuvem

- O projeto está configurado para ser implantado no [Railway](https://railway.app/).
- Use o `Dockerfile` incluído para configurar o pipeline de deploy.

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/todolist-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
