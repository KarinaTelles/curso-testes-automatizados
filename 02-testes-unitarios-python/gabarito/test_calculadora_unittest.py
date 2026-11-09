"""Parte 1: testes com unittest, que já vem com o Python.

Também roda sozinho com:  python -m unittest test_calculadora_unittest
"""
import unittest

from calculadora import dividir, multiplicar, soma, subtrair


class TestCalculadora(unittest.TestCase):
    def test_soma(self):
        self.assertEqual(soma(1, 2), 3)
        self.assertEqual(soma(-1, 1), 0)
        self.assertEqual(soma(-1, -1), -2)

    def test_subtrair(self):
        self.assertEqual(subtrair(5, 3), 2)
        self.assertEqual(subtrair(3, 5), -2)

    def test_multiplicar_por_zero(self):
        self.assertEqual(multiplicar(0, 99), 0)

    def test_dividir(self):
        self.assertEqual(dividir(7, 2), 3)

    def test_dividir_por_zero(self):
        with self.assertRaises(ValueError) as contexto:
            dividir(10, 0)
        self.assertEqual(str(contexto.exception), "Divisão por zero")


if __name__ == "__main__":
    unittest.main()
