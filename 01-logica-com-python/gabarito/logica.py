"""Gabarito dos exercícios de lógica."""


def comparar(a, b):
    """Devolve "b é maior que a", "a e b são iguais" ou "a é maior que b"."""
    if b > a:
        return "b é maior que a"
    elif a == b:
        return "a e b são iguais"
    else:
        return "a é maior que b"


def dia_da_semana(numero):
    """1 -> "Segunda-feira" ... 7 -> "Domingo". Qualquer outro valor -> "Dia inválido"."""
    match numero:
        case 1:
            return "Segunda-feira"
        case 2:
            return "Terça-feira"
        case 3:
            return "Quarta-feira"
        case 4:
            return "Quinta-feira"
        case 5:
            return "Sexta-feira"
        case 6:
            return "Sábado"
        case 7:
            return "Domingo"
        case _:
            return "Dia inválido"


def somar_textos(primeiro, segundo):
    """Recebe dois números em forma de texto e devolve a soma como float."""
    return float(primeiro) + float(segundo)


def nome_do_tipo(valor):
    """Devolve o nome do tipo do valor: "str", "int", "list", ..."""
    return type(valor).__name__


def montar_receita(ingredientes):
    """Devolve uma lista de linhas no formato "- ingrediente"."""
    if not ingredientes:
        return ["Nenhum ingrediente informado"]
    linhas = []
    for ingrediente in ingredientes:
        linhas.append(f"- {ingrediente}")
    return linhas
