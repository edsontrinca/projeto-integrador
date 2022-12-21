# projeto-integrador
Software de gerenciamento de poupança.

Validações

[x] Não deixar salvar uma cateira com o mesmo nome;

[x] Não deixar salvar uma pessoa com o mesmo cpf ou identidade;

[x] Não deixar salvar uma pessoa com o mesmo numero da casa;

[x] Não deixar salvar uma taxa com o mesmo nome;

[x] Não deixar salvar um documento com o mesmo cpf ou identidade;

[x] Não deixar salvar um endereço com o mesmo cep.

Forma de fazer a validação

        List<Carteira> listaDeCarteiras = carteiraRepository.findAll(); 

        for(Carteira nomeCarteira : listaDeCarteiras){
            if(carteira.getNome().equals(nomeCarteira.getNome())){
                throw new Exception("Esse nome ja existe, insira outro nome");
            }
        }


![diagrama](https://user-images.githubusercontent.com/106254231/201235999-942a075f-54a8-4572-8de9-5a0c18148e10.svg)

[x] Criar metodo chamado 'adicionarTaxa', o metodo deve conter as seguintes funcionalidades.
obs: Novo metodo deve ser criado dentro de pessoaServiceImpl;
funcionalidades

[x] Buscar todas as taxas existentes no banco de dados;

[x] Aumentar o saldo de todos os clientes de acordo com porcentagem da taxas registradas no cliente.
