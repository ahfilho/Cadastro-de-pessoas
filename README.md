# Api Java 
<h3 align="center"> Cadastro de pessoas </h3>

Cadastrar uma pessoa com: nome, cpf, data de nascimento, email.

- Adicionar novo
- listar todos
- editar um cadastro
- excluir pesquisar
- pesquisar por cpf(formatado e mascarado)


Tecnologias utilizadas:

Api rest, 
Java 8, 
Spring (boot, validation, security(
Jpa, 
Thymeleaf, 
Html, 
Css, 
Bootstrap, 
Mysql, 
Lombok, 
Javascript, 
Docker

IDE utilizado: Intellij
Para acessar o banco: Dbeaver.


- Validação e formatação do cpf
- Validação dos dados na interface e API.


<h4>Caso você já saiba utilizar o docker, siga os passos abaixo para criar o container do mysql na sua máquina para LINUX - Ubuntu.
Se não tiver, dê uma olhada nesse artigo que ensina o passo a passo de como fazer do zero: https://dev.to/nfo94/como-criar-um-container-com-mysql-server-com-docker-e-conecta-lo-no-workbench-linux-1blf </h4>

# Modo de configurar executar o projeto:

## Criando container com MySQL Server

Para criar um container com o MySQL:
<h4> 1 - docker run -p 3306:3306 --name=seu-container -d mysql/mysql-server</h4>

 Esse comando roda um container chamado “seu-container” a partir de uma imagem
 do MySQL Server e mapeia a porta 3306 do container com a sua de mesmo número.

<h4> 2 - Dê um docker ps e veja o que tem rodando na sua máquina.</h4>

Se conectando no MySQL Server e configurando senha:

<h4> 3 - Pegue a senha randômica gerada:</h4>
docker logs seu-container 2>&1 | grep GENERATED

<h4> 4 - Copie a root password que apareceu e rode o comando:</h4>

docker exec -it seu-container mysql -uroot -p

<h4> 5 - Cole o password e dê enter. Depois disso, já no server, digite:</h4>
ALTER USER 'root'@'localhost' IDENTIFIED BY '12345';

<h4> 6 - Isso vai mudar a senha padrão do usuário para 12345.</h4>
Execute: update mysql.user set host = '%' where user='root';

# E PRONTO, seu container MYSQL está pronto para o uso.


<h4> 7 - No Intellij (ou sua IDE de preferência), dentro do seu projeto em 'resources',
vá até "application.properties" e só configure a porta 3306 e o nome do banco, que no meu caso foi 'mysql'.</h4>

A mesma coisa se for utilizar o Dbeaver. Crie uma nova conexão com o banco escolhido, insira seu usuario, senha, porta e nome do banco.

Depois de tudo isso, execute o projeto no Intellij e acessse o endereço local: http://localhost:8080/login
Insira usuário padrão (user) e o password gerado pelo spring security que saiu no console da sua IDE.
Você agora está dentro da aplicação e pode usar. :-)
