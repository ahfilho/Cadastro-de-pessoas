# API Java
Cadastrar listar editar excluir

Tecnologias utilizadas:

API REST, 
Java 8, 
Spring boot, 
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


Modo de configurar executar o projeto:

Criando container com MySQL Server

Para criar um container com o MySQL:
docker run -p 3306:3306 --name=seu-container -d mysql/mysql-server

Esse comando roda um container chamado “seu-container” a partir de uma imagem
do MySQL Server e mapeia a porta 3306 do container com a sua de mesmo número.

Dê um docker ps e veja o que tem rodando na sua máquina.

Se conectando no MySQL Server e configurando senha:

Pegue a senha randômica gerada:
docker logs seu-container 2>&1 | grep GENERATED

Copie a root password que apareceu e rode o comando:

docker exec -it seu-container mysql -uroot -p

Cole o password e dê enter. Depois disso, já no server, digite:
ALTER USER 'root'@'localhost' IDENTIFIED BY '12345';

Isso vai mudar a senha padrão do usuário para 12345. Depois execute:
update mysql.user set host = '%' where user='root';

E PRONTO, seu container MYSQL está pronto para o uso.


No Intellij (ou sua IDE de preferência), dentro do seu projeto em 'resources',
vá até "application.properties" e só configure a porta 3306 e o nome do banco, que no meu caso foi 'mysql'.

A mesma coisa se for utilizar o Dbeaver. Crie uma nova conexão com o banco escolhido, insira seu usuario, senha, porta e nome do banco.

Depois de tudo isso, execute o projeto no Intellij e acessse o endereço local: http://localhost:8080/pessoas/inicio

