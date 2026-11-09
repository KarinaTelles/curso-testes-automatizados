# Módulo 05 - Testes de interface com Selenium

Até aqui testamos funções e classes diretamente. Agora vamos testar do jeito que a pessoa usuária usa o sistema: abrindo o navegador, digitando nos campos e clicando nos botões. Esses são os testes **de interface**, também chamados de **ponta a ponta** (E2E).

O **Selenium WebDriver** controla um navegador de verdade (aqui, o Chrome) a partir do código Java. Os testes continuam sendo JUnit, então tudo que vimos no módulo 03 vale aqui.

## O site de treino

Testes de interface que dependem de sites externos quebram por motivos que não têm nada a ver com o nosso código: o site mudou, saiu do ar, pediu captcha. Por isso este módulo traz duas páginas próprias em `src/test/resources/site/`:

- `login.html`: formulário de login com área segura e botão de sair. Usuário `aluno`, senha `senha123`.
- `busca.html`: uma busca de cursos que ignora maiúsculas e acentos.

As páginas são abertas direto do disco (`file://`), sem servidor nenhum. As duas respondem com um pequeno atraso de propósito, como faria uma chamada de rede.

## Conceitos

- **WebDriver**: o objeto que controla o navegador (`driver.get`, `driver.findElement`, `driver.getTitle`).
- **Localizadores (`By`)**: como encontrar um elemento na página. Prefira `By.id` e `By.name`, que são estáveis; use `By.cssSelector` quando precisar.
- **Esperas explícitas**: `WebDriverWait` com `ExpectedConditions` espera **até** uma condição acontecer, com um limite de tempo. É a forma certa de lidar com o atraso das páginas. O `Thread.sleep` com um tempo chutado deixa o teste lento quando sobra tempo e quebrado quando falta.
- **Page Object**: uma classe por tela (`LoginPage`, `AreaSeguraPage`) que esconde os localizadores. O teste lê como uma história (`abrir`, `digitarUsuario`, `entrarComSucesso`) e, se o HTML mudar, o conserto é num lugar só. Compare `LoginE2ETest`, que usa Page Objects, com `BuscaTest`, que não usa.
- **Isolamento**: `BaseTest` abre um navegador novo antes de cada teste e fecha depois (`@BeforeEach` e `@AfterEach`).
- **Headless**: o navegador roda sem janela. É o padrão aqui, porque é assim que roda na integração contínua.

## Como rodar

Você precisa do Google Chrome ou do Chromium instalado. O **Selenium Manager**, que vem junto com o Selenium, encontra ou baixa o `chromedriver` compatível sozinho.

```bash
./mvnw test -pl 05-testes-de-interface-selenium/gabarito                   # headless
./mvnw test -pl 05-testes-de-interface-selenium/gabarito -Dheadless=false  # vendo o navegador
```

Se o navegador estiver instalado num lugar fora do padrão, informe o caminho:

```bash
CHROME_BIN=/caminho/para/chromium ./mvnw test -pl 05-testes-de-interface-selenium/gabarito
```

## Exercícios

Em `exercicios/`:

1. Complete `digitarSenha` e `mensagem` em `pages/LoginPage.java`. Em `mensagem`, use a espera explícita.
2. Escreva o teste `sair` em `LoginE2ETest`.
3. Escreva o teste `semResultados` em `BuscaTest`.

```bash
./mvnw test -P exercicios -pl 05-testes-de-interface-selenium/exercicios
```

Quando terminar, um bom desafio extra é criar um `BuscaPage` e reescrever o `BuscaTest` usando Page Object. A solução dos itens 1 a 3 está em `gabarito/`.

## E o Playwright?

O [Playwright](https://playwright.dev/) é uma alternativa mais recente ao Selenium, com espera automática embutida e suporte oficial a Java, Python e JavaScript. Os conceitos deste módulo (localizadores, esperas, Page Object, isolamento) valem igualmente para ele. Este repositório usa Selenium porque foi a ferramenta trabalhada em aula.
