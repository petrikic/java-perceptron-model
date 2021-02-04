public class Main {

    public static void main(String[] args) {
        int weight[] = {0,0};
        int bias = 1;
        int biasWeight = 0;
        int learningRate = 1;
        Perceptron perceptron = new Perceptron(weight, bias, biasWeight, learningRate);

        int dataset[][] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int expectedOutput[] = {1, 1, 0, 1};

        perceptron.train(dataset, expectedOutput);

        System.out.println(perceptron);
        
        for (int[] i : dataset) {
            System.out.println("Output: " + perceptron.calculateOutput(i));
        }
    }
    
}
