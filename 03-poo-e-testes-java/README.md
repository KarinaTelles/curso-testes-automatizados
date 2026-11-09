# Módulo 03 - Orientação a objetos e testes em Java (JUnit)

Neste módulo mudamos de linguagem. Java é tipado estaticamente e foi pensado desde o começo para orientação a objetos, então é um bom lugar para ver esses conceitos com calma e, em seguida, testá-los com o JUnit.

O projeto usa Maven pelo wrapper (`mvnw`), então você não precisa instalar o Maven: basta ter um JDK 25 ou mais novo.

## Parte 1 - Orientação a objetos (`curso.poo`)

- **Classe e objeto**: a classe é o molde (`Carro`), o objeto é a coisa concreta criada a partir dele (`new Carro("BYD", "Dolphin", 2023)`).
- **Encapsulamento**: os atributos de `Carro` são `private` e só mudam pelos métodos `set`. Isso permite validar no lugar certo: `setAno` recusa um ano impossível, e o objeto nunca fica em estado inválido.
- **Herança**: `Carro` e `Moto` herdam de `Veiculo`. Tudo que é comum (`mover`, `acelerar`, `frear`) fica na classe base e não precisa ser repetido.
- **Polimorfismo**: `ligar()` existe em `Veiculo`, mas `Carro` e `Moto` sobrescrevem com `@Override`. Numa lista de `Veiculo`, cada objeto responde do seu jeito (veja `Main.java`).
- **Interface**: `Eletrico` é um contrato. `CarroEletrico` é um `Carro` e também promete saber `carregar()`.

Repare que os métodos devolvem `String` em vez de chamar `System.out.println`. É a mesma ideia do módulo 01: o que é devolvido pode ser testado, o que é só impresso não.

Para ver o exemplo rodando:

```bash
./mvnw -q compile exec:java -pl 03-poo-e-testes-java/gabarito -Dexec.mainClass=curso.poo.Main
```

## Parte 2 - JUnit (`curso.calculadora`)

A mesma calculadora do módulo 02, agora em Java. O JUnit é o "pai" do estilo xUnit que vimos no `unittest`. O que aparece em `CalculadoraTest`:

| Recurso | Para que serve |
|---|---|
| `@Test` | marca um método como teste |
| `@BeforeEach` | roda antes de cada teste (aqui, cria uma calculadora nova) |
| `@DisplayName` | dá um nome legível ao teste no relatório |
| `@ParameterizedTest` + `@CsvSource` | o mesmo teste com várias linhas de dados, como o `parametrize` do pytest |
| `assertEquals`, `assertThrows`, `assertAll` | as verificações |
| `@Nested` | agrupa testes relacionados dentro de uma classe interna |

## Parte 3 - Desafios de lógica (`curso.desafios`)

Cinco problemas clássicos de processos seletivos, cada um com testes:

1. **Loop**: qual o valor de `SOMA` ao final de um laço `while`? Primeiro tente responder no papel, depois confira com o teste.
2. **Fibonacci**: calcular um termo, gerar a sequência e dizer se um número pertence a ela.
3. **Faturamento diário**: ler `faturamento.json` e calcular menor valor, maior valor e quantos dias ficaram acima da média. Atenção ao enunciado: dias com faturamento zero (fins de semana e feriados) **não** entram no cálculo. Esse é o tipo de regra que um teste pega e uma leitura rápida do código deixa passar.
4. **Faturamento por estado**: o percentual de cada estado no total do mês.
5. **Inverter string**: sem usar `StringBuilder.reverse()`.

Uma armadilha que vale conhecer no desafio 3: em Java, `Double.MIN_VALUE` não é o número mais negativo, é o menor número **positivo** (cerca de 4.9e-324). Para começar a busca pelo maior valor, use `-Double.MAX_VALUE` ou o primeiro elemento da lista.

## Como rodar

Na raiz do repositório:

```bash
./mvnw test -pl 03-poo-e-testes-java/gabarito                 # gabarito: tudo verde
./mvnw test -P exercicios -pl 03-poo-e-testes-java/exercicios # exercícios: começa vermelho
```

## Exercícios

Em `exercicios/` o código tem `TODO` nos pontos que você deve completar:

- `Moto` ainda não sobrescreve `ligar()`;
- `CarroEletrico.carregar()` e a validação de `Carro.setAno` estão faltando;
- `Calculadora.dividir` não trata divisão por zero, e o teste de `subtrair` precisa ser escrito;
- os cinco desafios estão sem implementação.

Os testes já estão escritos (menos o de `subtrair`). Faça um de cada vez e rode de novo: ver o número de falhas diminuindo é parte da graça. A solução está em `gabarito/`.
