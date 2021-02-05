# Java Perceptron Model

Inspirado nos neurônios do cérebro humano, o ***perceptron*** é um modelo matemático que recebe várias entradas, e devolve uma única saída binária. A saída do neurônio, é determinada pela soma ponderada ***Σjwjxj***, sendo menor ou maior que um valor de limiar.

## 🚀 Começando

* Primeiro, você deve clonar o repositório do projeto. No terminal de sua preferência, utilize o comando `git clone https://github.com/petrikic/java-perceptron-model`

### 📋 Pré-requisitos

Para utilizar o software, você vai precisar instalar:
* [Java Development Kit](https://www.oracle.com/br/java/technologies/javase-downloads.html) - *`versão 1.8 ou superior`*.

### 🔧 Instalação

* Com o diretório do projeto aberto em um terminal de sua preferência, rode o comando `javac Perceptron.java Main.java` para gerar o bitecode do projeto.

* Em seguida, rode o comando `java Main` para executar o projeto.

* Digite a opção desejada, e insira as informações necessárias.

## 📦 Implementação

* Calculo da saída: Foi uilizado a somatória do produto das entradas pelos seus respectivos pesos, como também do bias pelo seu respectivo peso. O resultado da somatória, passa por uma função de ativação, que nesse caso, é a função degrau (0 para sum < 0, e 1 para sum >= 0).

* Cálculo de atualização dos pesos: Foi utilizada para a atualição dos pesos a regra delta ( *`Wi = Wi + n * (d(k) - y) * X(k)`* ), que soma o valor contido no peso, ao produto da taxa de aprendizagem, pelo produto do calculo do erro, pelo produto da saída esperada (`também chamado de classe`).

* treinamento da rede: Para efetuar o treinamento, é recebido um conjunto de dados de entrada, juntamente com um conjunto de dados de saidas esperadas. Inicialmente, temos um loop do tipo do while, que repete todo o cíclo de treinamento, até que a rede não produza mais erros nas saidas para todos os casos. Em seu nível interno, temos um loop do tipo for, que itera a cada conjunto de entradas, juntamente com o seu conjunto de saidas esperadas. e por fim, temos outro loop do tipo do while, que repete o cíclo até que o caso de testes atual não produza mais erros. Nele, calculamos o erro pela diferença entre entre a saída gerada pela rede, e a saída esperada ( *`d(k) - y`* ). Logo após, chamamos o método de atualização dos pesos. Caso o calculo do erro seja diferente de zero, todo processo é repetido. Se o calculo do erro for igual a zero, prosseguimos com os próximos casos de teste.

## 📈 Limitações
Muito embora o projeto seja extremamente divertido, e possa lidar tranquilamente com problemas como simular portas `NOT`, `AND`, `OR`, `NAND`, e `NOR`, ele acaba tendo algumas dificuldades na resolução de problemas mais complexos, como o `XOR`, por exemplo. Isso ocorre por conta da limitação da utilização de apenas um neurônio na rede. Para esses casos, é possível solucionar o problema utilizando o modelo de `Perceptron Multi Camadas`.

## 🛠️ Construído com

* [Visual Studio Code](https://code.visualstudio.com/) - *`a IDE utilizada no projeto.`*


## ✒️ Autor

* [**Cleriston Nantes Petrikic**](https://github.com/linkParaPerfil)

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE](https://github.com/petrikic/java-perceptron-model/blob/master/LICENSE) para detalhes.
