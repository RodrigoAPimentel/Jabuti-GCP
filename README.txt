- É necessario a instalação do banco de dados Mysql;
- Configuração inicial do banco de dados:
	# usuario: root,
	# senha: toor.
- O banco de dados pode ter as configurações personalizadas no arquivo application.properties em src/main/resources.
- Pode ser usado o banco de dados H2, para isso, é necessario que seja descomentada as linhas de 8 a 13 e comentada as linhas 2 a 5 no arquivo application.properties em src/main/resources.
- Servidor TomCat configurado para a porta 8090;
- UML incluido no root do projeto com o nome "Jabuti-GPC(UML)" no formato .jpg e .ucls(Plugin ObjectAid);
- Arquivos de Log são armazenados na pasta "logs" no root do projeto.
- Para modificar as configurações de Log alterar o arquivo logback.xml em src/main/resources.