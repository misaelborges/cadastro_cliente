# cadastro_cliente

## Endpoints
- BaseURL: /cliente
- GET: bucarCliente()
- GET /{codido}: buscarClientePorId(Long codigo)
- POST: salvarCliente(Cliente cliente)
- PUT: atualizarCliente(Cliente cliente)
- DELETE /{codigo}: excluirCliente(Long codigo)

## MODEL
### Cliente
- codigo: Long
- nome: String
- cnpj: int
- dataCadastro: LocalDate
- endereco: String
- telefone: int

### Regras para CADASTRO DE CLIENTES
- Não poderá haver CNPJ duplicado
- Os campos codigo e dataCadastro eles se auto implementam sozinhos. O campo codigo vai gerar valores de forma automaticas, enquanto o campo dataCadastro vai pegar a data atual do sistema do computador

**__Exemplo de como deve ser o cadastro de um cliente:__**
``` JSON
    {
        "nome": "Teste",
        "cnpj": 11111,
        "endereco": "Rua teste",
        "telefone": 4684788
    }
```

Exemplo de como deve ser a edição de dados de um cliente:
``` JSON
    {
        "codigo": 902,
        "nome": "Nome Ficticio",
        "cnpj": 45454554,
        "endereco": "rua Ficticio",
        "telefone": 12121254
    }
```
_Os campos não foram validados para receber uma quantidade mínima ou máxima de caracteres. Quando fazer a atualização do cadastro do cliente, todos os campos devem ser informados, caso o campo codigo seja alterado ele vai cadastrar um novo cliente na base de dados_
