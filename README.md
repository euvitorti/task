# FATTO

# Sistema Lista de Tarefas

Este é um sistema web desenvolvido para gerenciar tarefas, permitindo o cadastro, edição, exclusão e reordenação de tarefas em um banco de dados PostgreSQL. A aplicação segue o padrão MVC e foi implementada usando Java 21 e Spring Boot.

## Testar a Aplicação 🌐
Se preferir, você pode testar a aplicação diretamente através do seguinte link: [Site](https://fatto-front-deploy.vercel.app/).

## Tecnologias Utilizadas

- **Java**: 21
- **Spring Boot**: Última versão
- **PostgreSQL**: 16

## Pré-requisitos

- **Java 21**: Certifique-se de que o Java 21 está instalado em sua máquina.
- **PostgreSQL 16**: Você precisa ter o PostgreSQL instalado e em execução.

## Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`, atualize as seguintes configurações:

```properties
# URL do banco de dados
spring.datasource.url=jdbc:postgresql://localhost/Nome_Do_Banco_De_Dados
spring.datasource.username=Seu_Usuario_Do_Banco
spring.datasource.password=Sua_Senha_Do_Banco
```

## Configuração do CORS
Acesse a classe Security e localize o método responsável pela configuração do CORS. Atualize a linha de código que define a URL permitida com a URL onde o front-end está rodando (seja em ambiente de desenvolvimento ou produção).
```
@Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("http://127.0.0.1:5500") // Specify allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials to be included in CORS requests
    }
```

Substitua "http://127.0.0.1:5500" pela URL correta onde o front-end está rodando, por exemplo:

Desenvolvimento local: http://127.0.0.1:5501

Produção: A URL do seu servidor de produção.

Isso vai garantir que o front-end consiga acessar a API corretamente!

**Frontend**: O frontend da aplicação deve estar em execução. Você pode encontrar o repositório do frontend em [link do repositório do frontend](https://github.com/euvitorti/task-front).
Execute o back e acesse a aplicação com o front, na página signin.html.

Exemplo de configuração de CORS em uma classe de configuração Java:

## Funcionalidades
- Lista de Tarefas: Página principal que lista todas as tarefas com opções para editar e excluir.
- Incluir Tarefa: Adiciona novas tarefas ao sistema.
- Editar Tarefa: Permite a edição de tarefas existentes, com verificação de duplicidade no nome.
- Excluir Tarefa: Remove tarefas com confirmação do usuário.
- Reordenação de Tarefas: Usuários podem reorganizar as tarefas arrastando.
- Destaque de Tarefas: Tarefas com custo maior ou igual a R$1.000,00 são destacadas com fundo vermelho.

### Contribuições
Sinta-se à vontade para contribuir para o projeto! Qualquer feedback é bem-vindo.
