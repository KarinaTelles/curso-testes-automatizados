"""Algoritmo é uma sequência de passos, como uma receita de bolo."""

ingredientes = [
    "2 xícaras de farinha",
    "1 xícara de açúcar",
    "1/2 xícara de manteiga",
    "3 ovos",
    "1 xícara de leite",
    "1 colher de sopa de fermento em pó",
]

passos = [
    "Bata tudo até ficar homogêneo.",
    "Adicione o fermento e misture delicadamente.",
    "Despeje a massa em uma forma untada.",
    "Leve ao forno pré-aquecido a 180°C por 30 minutos.",
    "Retire do forno e deixe esfriar.",
]

print("== Ingredientes ==")
for ingrediente in ingredientes:
    print("-", ingrediente)

print("\n== Modo de preparo ==")
for numero, passo in enumerate(passos, start=1):
    print(f"{numero} - {passo}")

print("\nSeu bolo está pronto! Aproveite!")
