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
