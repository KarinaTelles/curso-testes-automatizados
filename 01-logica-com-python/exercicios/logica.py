"""Exercícios de lógica.

Cada função abaixo tem um TODO. Implemente e rode os testes:

    uv run pytest 01-logica-com-python/exercicios
"""


def comparar(a, b):
    """Devolve "b é maior que a", "a e b são iguais" ou "a é maior que b"."""
    # TODO: use if / elif / else
    raise NotImplementedError


def dia_da_semana(numero):
    """1 -> "Segunda-feira" ... 7 -> "Domingo". Qualquer outro valor -> "Dia inválido"."""
    # TODO: use match / case
    raise NotImplementedError


def somar_textos(primeiro, segundo):
    """Recebe dois números em forma de texto (como vêm do input) e devolve a soma como float.

    Exemplo: somar_textos("2", "3.5") == 5.5
    """
    # TODO: converta antes de somar (casting)
    raise NotImplementedError


def nome_do_tipo(valor):
    """Devolve o nome do tipo do valor: "str", "int", "list", ..."""
    # TODO: dica: type(valor).__name__
    raise NotImplementedError


def montar_receita(ingredientes):
    """Recebe a lista de ingredientes e devolve uma lista de linhas no formato "- ingrediente".

    Se a lista estiver vazia, devolve ["Nenhum ingrediente informado"].
    """
    # TODO: use um laço for
    raise NotImplementedError
