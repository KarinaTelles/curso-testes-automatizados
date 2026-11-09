# language: pt
Funcionalidade: Bloqueio após tentativas inválidas
  Para proteger a conta contra quem tenta adivinhar a senha
  Como responsável pela segurança do sistema
  Eu quero bloquear o usuário depois de três senhas erradas seguidas

  Contexto:
    Dado que existe o usuário "maria" com a senha "segredo"
    E que o usuário está na tela de login

  Cenário: Três senhas erradas bloqueiam a conta
    Quando "maria" errar a senha 3 vezes
    Então o usuário "maria" deve estar bloqueado
    E ao informar o usuário "maria" e a senha "segredo" deve ver a mensagem "Usuário bloqueado"

  Cenário: Acertar a senha zera a contagem de erros
    Quando "maria" errar a senha 2 vezes
    E informar o usuário "maria" e a senha "segredo"
    E "maria" errar a senha 2 vezes
    Então o usuário "maria" não deve estar bloqueado
