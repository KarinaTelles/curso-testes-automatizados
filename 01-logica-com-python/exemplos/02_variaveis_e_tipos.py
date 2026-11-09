"""Variáveis, tipagem dinâmica e os tipos de dados mais comuns."""

# Nomes de variáveis podem ter letras, números e underscore (não podem começar com número).
# Não declaramos o tipo: o interpretador descobre sozinho.
numero = 5
nome = "João"
print(numero, type(numero))
print(nome, type(nome))

# A mesma variável pode passar a guardar outro tipo.
numero = "Agora sou uma string"
print(numero, type(numero))

# Um exemplo de cada tipo que usamos em aula.
exemplos = [
    "Hello World",                        # str
    20,                                   # int
    20.5,                                 # float
    [1, 2, 3],                            # list
    (1, 2, 3),                            # tuple
    range(1, 10),                         # range
    {"chave": "valor", "chave2": "valor2"},  # dict
    {"valor1", "valor2", "valor3"},       # set
    True,                                 # bool
]
for valor in exemplos:
    print(f"{valor!r:45} -> {type(valor).__name__}")
