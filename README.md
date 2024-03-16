## 🛠️ Arquitetura utilizada
![image](https://github.com/lucasr-conceicao/monitoramento-consumo-energia/assets/64719344/962b3549-c2de-47b8-89da-b09065d59ef6) <br>
O código foi desenvolvido utilizando o clean arch (A ideia de utilizar o clean foi desenvolver o projeto na estrutura que utilizo no dia a dia no trabalho). <br>
TODAS as APIs criadas se encontram na camada VERDE. Todas as requisições feitas pelo insomnia representam a camada AZUL. Quando nosso controller é chamada para cadastrar uma pessoa por exemplo, chamamos o Usecase na camada VERMELHA (camada esse que fica a regra de negócio.) para salvar no banco de dados, fazemos o caminho inverso atráves comunicando os pacotes através de interfaces.

## 🛠️ Exemplo Json/Rotas de cada API

###  API Clientes

- `(POST) API de cadastro de cliente`: localhost:9080/gestao-clientes/v1/cliente
```JSON
{
	"pais_origem": "Brasil",
	"cadastro_pessoa_fisica": "52546196754",
	"numero_passaporte": "65GER7",
	"nome_completo": "Lucas Rocha Conceicao",
	"data_nascimento": "25/01/2004",
	"endereco": "Avenida Jabaquara, 1288",
	"telefone": "11986958484",
	"email": "lucasr-conceicao@outlook.com.br"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/5bd37404-0456-4ff9-b153-c7260fc9359f)



- `(PUT) API de atualizar cliente`: http://localhost:9080/videos/d0a510c4-fda1-4fdb-96d3-8f021125802c
```JSON
{
	"pais_origem": "Brasil",
	"cadastro_pessoa_fisica": "52546196754",
	"numero_passaporte": "65GER7",
	"nome_completo": "Lucas Rocha Conceicao",
	"data_nascimento": "25/01/2004",
	"endereco": "Avenida Jabaquara, 1288",
	"telefone": "11965847845",
	"email": "lucasr-conceicao@outlook.com.br"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/84adb0ab-7e1f-4ea0-9553-81f5184545f3)


- `(GET) API de buscar ciente`: http://localhost:9080/usuarios/d0a510c4-fda1-4fdb-96d3-8f021125802c
  
exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/99d50475-6d7f-4ee2-9307-e37a056694cf)

   <br>
   <br>
- `(DELETE) API de deletar cliente`: http://localhost:9080/usuarios/d0a510c4-fda1-4fdb-96d3-8f021125802c
  
exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/638a4fdb-8393-4b0c-8640-e673f512cda4)


### API Gestão servico
- `(POST) API de cadastrar video`: localhost:9080/gestao-servicos/v1/servico
```JSON
{
	"id_servico": "5",
	"descricao": "Manicure",
	"preco": "85.00"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/e386f6cc-fac4-4f53-b7ab-59d6b9fd6833)



- `(PUT) API de atualizar video`: localhost:9080/gestao-servicos/v1/servicos/5
```JSON
{
	"id_servico": "5",
	"descricao": "Manicure",
	"preco": "90.00"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/d1839423-cb93-448f-815d-ed0d58c02f85)


- `(GET) API de buscar video`: localhost:9080/gestao-servicos/v1/servicos/5

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/1985e211-727c-48b7-bcd4-9ebf60c75556)

  <br>
  <br>
  
- `(DELETE) API de deletar video`: localhost:9080/gestao-servicos/v1/servicos/5

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/494e4b71-93f9-41ab-844a-03165d184c31)

<br>


### API Endereco
- `(POST) API de cadastrar endereco`: localhost:9080/v1/endereco
```JSON
{
	"rua": "Rua Engenheiro José Pastore",
	"numero": 44,
	"cep": "02714050",
	"bairro": "Limão",
	"cidade": "São Paulo",
	"estado": "SP",
	"pais": "Brasil"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/c0cf6c7f-92fa-4aea-8cc4-c2aa84c71f2c)




- `(PUT) API de atualizar endereco`: localhost:9080/v1/endereco/087e6f1e-df99-4175-b6b6-97c2abf4f0a0
```JSON
{
	"rua": "Rua FIAP",
	"numero": 528,
	"cep": "02714050",
	"bairro": "Limão",
	"cidade": "São Paulo",
	"estado": "SP",
	"pais": "Brasil"
}
```
exemplo de entrada e saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/d420d7fd-2f1c-4a7a-9dbc-acecd96edc7e)



- `(GET) API de buscar endereco`: localhost:9080/v1/endereco/087e6f1e-df99-4175-b6b6-97c2abf4f0a0

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/a00bdec8-0ab3-492a-826d-3f616512c7fe)


  <br>
  <br>
  
- `(DELETE) API de deletar endereco`: localhost:9080/v1/endereco/087e6f1e-df99-4175-b6b6-97c2abf4f0a0

exemplo de saída: <br>
![image](https://github.com/lucasr-conceicao/hackathon/assets/64719344/8b8c1585-2be0-4fe6-831c-c877726a7def)


<br>

