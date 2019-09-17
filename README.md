### Video da Configuração com Eclipse Oxygen
https://www.youtube.com/watch?v=5lha83ShQLo&feature=youtu.be

### Configurações

- Primeiramente importe o projeto, caso esteja usando o eclipse clique em file > import > General > Projects from File System or Archive
 - Em imported source coloque o caminho da pasta (workspace) em que a pasta do seu projeto está



### Requisitos
- MYSQL Connector 5.1.47
- Apache Tomcat v8.5
 
## Aviso Importante
### Banco de Dados
- Está configurado um banco de dados com nome 'webcamadas'
```sql 
CREATE TABLE pessoa (
id INT NOT NULL auto_increment Primary Key,
nome VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
tel VARCHAR(50) NOT NULL
);

CREATE TABLE endereco(
id int NOT NULL auto_increment Primary Key,
logradouro varchar(100),
numero int,
bairro varchar(45),
cidade varchar(45),
estado varchar(45),
pessoa_id int,
Foreign Key (pessoa_id) references pessoa(id)
);

