# Módulo 01 - Lógica com Python

Antes de testar código, a gente precisa saber escrever código. Este módulo cobre o básico de lógica de programação usando Python, que tem uma sintaxe enxuta e deixa a gente focar no raciocínio.

## O que vamos ver

- **Algoritmo**: uma sequência finita de passos para resolver um problema. A receita de bolo (`exemplos/07_receita_de_bolo.py`) é o exemplo clássico: lista de ingredientes, passos em ordem, resultado no final.
- **Variáveis e tipagem dinâmica**: em Python não declaramos o tipo. O interpretador descobre sozinho, e a mesma variável pode passar a guardar outro tipo (`02_variaveis_e_tipos.py`).
- **Tipos de dados**: `str`, `int`, `float`, `list`, `tuple`, `range`, `dict`, `set` e `bool`.
- **Casting**: converter um tipo em outro com `str()`, `int()` e `float()`. Isso é essencial quando lemos dados do teclado, porque `input()` sempre devolve texto (`08_soma_dois_numeros.py`).
- **Indentação**: em Python ela não é estética, é sintaxe. É a indentação que define o que está dentro de um `if`, de um `for` ou de uma função.
- **Condicionais**: `if`, `elif` e `else` (`04_condicionais.py`) e o `match/case` (`05_match.py`), disponível desde o Python 3.10.
- **Funções e escopo**: uma função enxerga as variáveis globais do arquivo (`06_escopo_e_funcoes.py`).

## Como rodar os exemplos

Na raiz do repositório:

```bash
uv run python 01-logica-com-python/exemplos/01_ola_mundo.py
```

## Exercícios

Em `exercicios/logica.py` há cinco funções com `TODO`. Cada uma retoma um dos exemplos, só que agora a função **devolve** o resultado em vez de imprimir. Essa é a primeira lição sobre testes: código que devolve valores é muito mais fácil de verificar do que código que só faz `print`.

Os testes já estão prontos em `exercicios/test_logica.py`. No começo todos falham, e o objetivo é deixá-los verdes:

```bash
uv run pytest 01-logica-com-python/exercicios
```

Não se preocupe ainda em entender como o pytest funciona por dentro, isso é assunto do próximo módulo. Por enquanto, leia a mensagem de erro e use-a como pista.

A solução está em `gabarito/`. Tente resolver antes de olhar.
