# Curso de testes automatizados

Material das minhas aulas de lógica de programação e testes de software, reunido em um curso só, na ordem em que costumo apresentar os assuntos. Cada módulo parte do anterior: primeiro escrevemos código que dá para testar, depois aprendemos a testar, e por fim subimos de nível, de funções isoladas até o navegador.

| Módulo | Assunto | Ferramentas |
|---|---|---|
| [01 - Lógica com Python](01-logica-com-python/) | variáveis, tipos, casting, condicionais, `match`, funções | Python |
| [02 - Testes unitários em Python](02-testes-unitarios-python/) | do `unittest` ao `pytest`, parametrização, exceções, cobertura | unittest, pytest, pytest-cov |
| [03 - POO e testes em Java](03-poo-e-testes-java/) | classes, encapsulamento, herança, polimorfismo, interfaces e desafios de lógica | Java, JUnit |
| [04 - BDD com Cucumber](04-bdd-com-cucumber/) | Gherkin em português, step definitions, cenários como especificação | Cucumber, JUnit Platform |
| [05 - Testes de interface](05-testes-de-interface-selenium/) | WebDriver, esperas explícitas, Page Object, headless | Selenium, JUnit |

## Como cada módulo está organizado

- `README.md`: a explicação do assunto, no tom de aula.
- `exercicios/`: código com `TODO` e testes que **começam falhando**. O trabalho é deixá-los verdes.
- `gabarito/`: uma solução completa, com todos os testes passando. A integração contínua roda o gabarito de todos os módulos a cada push.

Uma sugestão: resolva o exercício antes de abrir o gabarito. A falha do teste já diz bastante sobre o que falta.

## Preparando o ambiente

### Python (módulos 01 e 02)

Use o [uv](https://docs.astral.sh/uv/getting-started/installation/). Ele instala o Python certo e as dependências:

```bash
uv sync
uv run pytest 01-logica-com-python/gabarito
uv run pytest 02-testes-unitarios-python/gabarito
```

### Java (módulos 03, 04 e 05)

Basta um JDK 25 ou mais novo (`java -version`). O Maven vem pelo wrapper, não precisa instalar:

```bash
./mvnw test                  # gabaritos dos módulos 03, 04 e 05
./mvnw test -P exercicios    # exercícios (começam com falhas, de propósito)
```

No Windows, use `mvnw.cmd` no lugar de `./mvnw`. O módulo 05 também precisa do Google Chrome ou do Chromium.

## Versões usadas

| Ferramenta | Versão |
|---|---|
| Python | 3.14 |
| pytest | 9.2 |
| Java | 25 (LTS) |
| Maven (wrapper) | 3.9.16 |
| JUnit | 6.1.3 |
| Cucumber | 8.0.4 |
| Selenium | 4.52.0 |
