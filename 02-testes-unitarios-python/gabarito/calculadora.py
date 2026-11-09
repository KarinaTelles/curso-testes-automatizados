"""Calculadora simples, o mesmo exemplo que usamos em unittest, pytest e JUnit."""


def soma(a, b):
    return a + b


def subtrair(a, b):
    return a - b


def multiplicar(a, b):
    return a * b


def dividir(a, b):
    """Divisão inteira. Dividir por zero é um erro de uso, então avisamos com ValueError."""
    if b == 0:
        raise ValueError("Divisão por zero")
    return a // b
