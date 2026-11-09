import pytest

from logica import comparar, dia_da_semana, montar_receita, nome_do_tipo, somar_textos


@pytest.mark.parametrize(
    ("a", "b", "esperado"),
    [
        (33, 200, "b é maior que a"),
        (33, 33, "a e b são iguais"),
        (200, 33, "a é maior que b"),
    ],
)
def test_comparar(a, b, esperado):
    assert comparar(a, b) == esperado


@pytest.mark.parametrize(
    ("numero", "esperado"),
    [(1, "Segunda-feira"), (4, "Quinta-feira"), (6, "Sábado"), (7, "Domingo")],
)
def test_dia_da_semana(numero, esperado):
    assert dia_da_semana(numero) == esperado


@pytest.mark.parametrize("numero", [0, 8, -1])
def test_dia_da_semana_invalido(numero):
    assert dia_da_semana(numero) == "Dia inválido"


def test_somar_textos():
    assert somar_textos("2", "3.5") == 5.5
    assert somar_textos("-1", "1") == 0.0


def test_somar_textos_com_texto_que_nao_e_numero():
    with pytest.raises(ValueError):
        somar_textos("dois", "3")


@pytest.mark.parametrize(
    ("valor", "esperado"),
    [
        ("Hello World", "str"),
        (20, "int"),
        (20.5, "float"),
        ([1, 2, 3], "list"),
        ((1, 2, 3), "tuple"),
        (range(1, 10), "range"),
        ({"chave": "valor"}, "dict"),
        ({"valor1"}, "set"),
        (True, "bool"),
    ],
)
def test_nome_do_tipo(valor, esperado):
    assert nome_do_tipo(valor) == esperado


def test_montar_receita():
    assert montar_receita(["3 ovos", "1 xícara de leite"]) == [
        "- 3 ovos",
        "- 1 xícara de leite",
    ]


def test_montar_receita_vazia():
    assert montar_receita([]) == ["Nenhum ingrediente informado"]
