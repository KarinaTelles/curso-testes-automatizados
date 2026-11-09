# Módulo 04 - BDD com Cucumber

**BDD** (Behavior-Driven Development, desenvolvimento guiado por comportamento) parte de uma ideia simples: antes de escrever código, a equipe inteira (desenvolvimento, testes e negócio) combina **como o sistema deve se comportar**, usando exemplos concretos escritos numa linguagem que todo mundo lê.

Esses exemplos são escritos em **Gherkin**, e o **Cucumber** é a ferramenta que transforma cada frase em uma chamada de código. O resultado é uma especificação que também é teste automatizado.

## Gherkin em português

A primeira linha `# language: pt` libera as palavras-chave em português:

| Palavra-chave | Papel |
|---|---|
| `Funcionalidade` | o que está sendo descrito, com o "para / como / eu quero" logo abaixo |
| `Contexto` | passos que se repetem no começo de todos os cenários do arquivo |
| `Cenário` | um exemplo concreto de comportamento |
| `Esquema do Cenário` + `Exemplos` | o mesmo cenário rodando para cada linha de uma tabela |
| `Dado` | o estado inicial |
| `Quando` | a ação |
| `Então` | o resultado esperado |
| `E`, `Mas` | continuam o passo anterior |

```gherkin
Esquema do Cenário: Tentativas de login
  Dado que o usuário está na tela de login
  Quando informar o usuário "<usuario>" e a senha "<senha>"
  Então deve ver a mensagem "<mensagem>"
```

## Como as peças se encaixam

- `src/test/resources/features/*.feature`: os cenários em Gherkin.
- `src/test/java/curso/steps/LoginSteps.java`: as *step definitions*. Cada método tem uma anotação (`@Dado`, `@Quando`, `@Então`) com uma expressão que casa com a frase do cenário. `{string}` e `{int}` capturam os valores entre aspas e os números.
- `src/test/java/curso/RunCucumberTest.java`: a suíte do JUnit Platform que entrega as features ao Cucumber.
- `src/main/java/curso/auth/AuthService.java`: o código que está sendo testado.

## Como rodar

Na raiz do repositório:

```bash
./mvnw test -pl 04-bdd-com-cucumber/gabarito
```

Além do relatório no console, o Cucumber gera `target/cucumber-report.html`, que dá para abrir no navegador e mostrar para quem não lê código.

## Exercício

A funcionalidade nova é o **bloqueio da conta depois de três senhas erradas seguidas** (`features/bloqueio.feature`). O cenário já está escrito, como seria combinado numa conversa com o time. Falta fazer o sistema obedecer:

1. Rode os testes de `exercicios/`. O Cucumber vai avisar que alguns passos estão **indefinidos** e mostrar a anotação que cada um precisa ter.
2. Crie esses métodos em `LoginSteps.java`.
3. Rode de novo. Agora os passos existem, mas os cenários falham, porque o `AuthService` ainda não bloqueia ninguém.
4. Complete os `TODO` do `AuthService` até tudo ficar verde.

```bash
./mvnw test -P exercicios -pl 04-bdd-com-cucumber/exercicios
```

Esse caminho, do cenário escrito até o código que o satisfaz, é o ciclo do BDD. A solução está em `gabarito/`.
