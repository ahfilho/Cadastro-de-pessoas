# API Java 
<h3 align="center"> Cadastro de pessoas </h3>

Cadastrar uma pessoa com: nome, cpf, data de nascimento, email.

- Adicionar novo
- listar todos
- editar um cadastro
- excluir pesquisar
- pesquisar por cpf(formatado e mascarado)


Tecnologias utilizadas:

API REST, 
Java 8, 
Spring boot, validation
Jpa, 
Thymeleaf, 
HTML, 
CSS, 
BOOTSTRAP, 
MYSQL, 
LOMBOK, 
Javascript, 
Docker

Programas utilizados:

Intellij e Dbeaver.


- Validação e formatação do cpf
- Validação dos dados na interface e API.


# Modo de configurar executar o projeto:

## Criando container com MySQL Server

# Para criar um container com o MySQL:
# 1 - docker run -p 3306:3306 --name=seu-container -d mysql/mysql-server

 Esse comando roda um container chamado “seu-container” a partir de uma imagem
 do MySQL Server e mapeia a porta 3306 do container com a sua de mesmo número.

# 2 - Dê um docker ps e veja o que tem rodando na sua máquina.

Se conectando no MySQL Server e configurando senha:

# 3 - Pegue a senha randômica gerada:
# docker logs seu-container 2>&1 | grep GENERATED

# 4 - Copie a root password que apareceu e rode o comando:

# 5 - docker exec -it seu-container mysql -uroot -p

# 6 - Cole o password e dê enter. Depois disso, já no server, digite:
# ALTER USER 'root'@'localhost' IDENTIFIED BY '12345';

# 7 - Isso vai mudar a senha padrão do usuário para 12345. 
# Execute: update mysql.user set host = '%' where user='root';

E PRONTO, seu container MYSQL está pronto para o uso.


# 8 - No Intellij (ou sua IDE de preferência), dentro do seu projeto em 'resources',
# vá até "application.properties" e só configure a porta 3306 e o nome do banco, que no meu caso foi 'mysql'.

A mesma coisa se for utilizar o Dbeaver. Crie uma nova conexão com o banco escolhido, insira seu usuario, senha, porta e nome do banco.

***Depois de tudo isso, execute o projeto no Intellij e acessse o endereço local: http://localhost:8080/pessoas/inicio

