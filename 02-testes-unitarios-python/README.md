# Módulo 02 - Testes unitários em Python (unittest e pytest)

Um **teste unitário** verifica um pedaço pequeno do código, normalmente uma função, de forma isolada e automática. Em vez de rodar o programa e conferir o resultado no olho, escrevemos código que confere por nós. Assim dá para repetir a verificação a cada mudança, em segundos.

O exemplo deste módulo é uma calculadora: `soma`, `subtrair`, `multiplicar` e `dividir`. É simples de propósito, para a atenção ficar nos testes e não no problema.

## Parte 1 - unittest

O `unittest` já vem instalado com o Python. Ele segue o estilo xUnit (o mesmo do JUnit, que veremos no módulo 03):

- os testes ficam dentro de uma classe que herda de `unittest.TestCase`;
- cada método que começa com `test_` é um teste;
- as verificações usam métodos como `self.assertEqual`, `self.assertTrue` e `self.assertRaises`.

```python
class TestCalculadora(unittest.TestCase):
    def test_soma(self):
        self.assertEqual(soma(1, 2), 3)
```

Para rodar só com a biblioteca padrão, de dentro da pasta:

```bash
python -m unittest test_calculadora_unittest
```

## Parte 2 - pytest

O `pytest` não vem com o Python, mas é a ferramenta mais usada na comunidade. As vantagens que mais aparecem no dia a dia:

- teste é uma função comum, sem classe obrigatória;
- usamos o `assert` do próprio Python, e quando ele falha o pytest mostra os valores comparados;
- `@pytest.mark.parametrize` roda o mesmo teste com vários dados de entrada;
- `pytest.raises` verifica que uma exceção foi lançada;
- ele também executa testes escritos em `unittest`, então dá para migrar aos poucos.

Neste repositório o pytest é instalado pelo [uv](https://docs.astral.sh/uv/). Na raiz:

```bash
uv sync                                         # cria o ambiente e instala pytest e pytest-cov
uv run pytest 02-testes-unitarios-python/gabarito
```

### Cobertura

O `pytest-cov` mede quantas linhas do código foram executadas pelos testes:

```bash
uv run pytest 02-testes-unitarios-python/gabarito --cov=calculadora --cov-report=term-missing
```

Cobertura alta não garante que os testes são bons, mas cobertura baixa mostra com certeza onde não há teste nenhum.

## Exercícios

Em `exercicios/`:

1. Implemente `subtrair`, `multiplicar` e `dividir` em `calculadora.py`. A divisão é inteira e, se o divisor for zero, deve lançar `ValueError("Divisão por zero")`.
2. Em `test_calculadora_unittest.py`, escreva os dois testes marcados com `TODO`.
3. Em `test_calculadora_pytest.py`, escreva os mesmos testes no estilo pytest, com `parametrize` e `pytest.raises`.

```bash
uv run pytest 02-testes-unitarios-python/exercicios
```

No início alguns testes falham. Isso é esperado: o vermelho mostra o que ainda falta fazer. A solução está em `gabarito/`.
