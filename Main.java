import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int weight[], bias, biasWeight, learningRate, inputControl;
        
        System.out.println("###########################################################################");
        System.out.println("##################     Java Perceptron Neural Network    ##################");
        System.out.println("###########################################################################");
        System.out.println("###########################################################################");
        System.out.println("\n\n");

        System.out.print("Digite os pesos iniciais da rede, separados por espaço: ");
        weight = stringArrToIntArr(input.nextLine().split(" "));
        System.out.print("Digite o valor do bias: ");
        bias = input.nextInt();
        System.out.print("Digite o valor do peso do bias: ");
        biasWeight = input.nextInt();
        System.out.print("Digite o valor da taxa de aprendizagem: ");
        learningRate = input.nextInt();
        
        Perceptron perceptron = new Perceptron(weight, bias, biasWeight, learningRate);

        //int inputControl = 1;
        do{
            System.out.println("\n\n###########################################################################\n\n");
            System.out.println("Opção 1: Testar a rede");
            System.out.println("Opção 2: Treinar a rede");
            System.out.println("Opção 3: Exibir a rede");
            System.out.println("Opção 0: Encerrar o programa");

            System.out.print("\nDigite a opção desejada: ");
            inputControl = input.nextInt();
            clearBuffer(input);

            switch(inputControl) {
                case 1:
                    testNetwork(input, perceptron);
                    break;
                case 2:
                    trainNetwork(input, perceptron);
                    break;
                case 3:
                    showNetwork(input, perceptron);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                default:
                    System.out.println("A opção digitada é inválida!");
                    System.out.println("Pressione enter para continuar...");
                    input.nextLine();
            }

        } while(inputControl != 0);
        
        input.close();
    }

    public static void testNetwork(Scanner input, Perceptron perceptron) {
        System.out.print("Digite as entradas, separadas por espaço: ");
        int values[] = stringArrToIntArr(input.nextLine().split(" "));
        int output = perceptron.calculateOutput(values);
        System.out.println("\nO valor de saida da rede é " + output);
        System.out.println("Pressione enter para contiuar...");
        input.nextLine();
    }

    public static void trainNetwork(Scanner input, Perceptron perceptron) {
        int dataset[][];
        int expectedOutput[];
        System.out.print("Digite quantos casos deseja treinar: ");
        int cases = input.nextInt();
        clearBuffer(input);
        dataset = new int[cases][];
        expectedOutput = new int[cases];
        for(int i = 0; i < cases; i++) {
            System.out.print("Digite os valores de entrada do teste " + (i+1) + " separados por espaço: ");
            int currentCase[] = stringArrToIntArr(input.nextLine().split(" "));
            dataset[i] = currentCase;
            System.out.print("Digite o valor esperado da saida do teste " + (i+1) + ": ");
            expectedOutput[i] = input.nextInt();
            clearBuffer(input);
        }
        System.out.println("Treinando a rede, Aguarde...");
        perceptron.train(dataset, expectedOutput);
        System.out.println("Rede treinada com sucesso!");
        System.out.println("Pressione enter para contiuar...");
        input.nextLine();
    }

    public static void showNetwork(Scanner input, Perceptron perceptron) {
        System.out.println("Exibindo a rede:");
        System.out.println(perceptron);
        System.out.println("Pressione enter para contiuar...");
        input.nextLine();
    }

    public static void clearBuffer(Scanner input) {
        if(input.hasNextLine())
            input.nextLine();
    }
    
    public static int[] stringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
           result[i] = Integer.parseInt(s[i]);
        }
        return result;
     }
}
