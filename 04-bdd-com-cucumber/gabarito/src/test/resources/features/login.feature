# language: pt
Funcionalidade: Login no sistema
  Para acessar funcionalidades protegidas
  Como um usuário
  Eu quero fazer login

  Esquema do Cenário: Tentativas de login
    Dado que o usuário está na tela de login
    Quando informar o usuário "<usuario>" e a senha "<senha>"
    Então deve ver a mensagem "<mensagem>"

    Exemplos:
      | usuario | senha | mensagem                    |
      | admin   | 1234  | Login realizado com sucesso |
      | admin   | 9999  | Credenciais inválidas       |
      | alice   | 1234  | Credenciais inválidas       |
