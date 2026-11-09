"""Parte 2: os mesmos testes em pytest.

Compare com o arquivo do unittest: sem classe, sem self.assertEqual,
só funções e o assert do próprio Python.
"""
import pytest

from calculadora import dividir, multiplicar, soma, subtrair


def test_soma():
    assert soma(2, 3) == 5
    assert soma(-1, 1) == 0
    assert soma(10, 5) != 0


@pytest.mark.parametrize(
    ("a", "b", "esperado"),
    [
        (0, 1, 1),
        (1, 2, 3),
        (49, 51, 100),
        (1, 100, 101),
    ],
)
def test_soma_parametrizada(a, b, esperado):
    assert soma(a, b) == esperado


def test_subtrair():
    assert subtrair(5, 3) == 2


def test_multiplicar_por_zero():
    assert multiplicar(0, 99) == 0


# TODO: transforme este teste em um teste parametrizado com pelo menos três casos,
# no mesmo estilo de test_soma_parametrizada.
def test_dividir():
    pytest.fail("TODO: escreva este teste")


def test_dividir_por_zero():
    # TODO: use pytest.raises(ValueError, match="Divisão por zero")
    pytest.fail("TODO: escreva este teste")
