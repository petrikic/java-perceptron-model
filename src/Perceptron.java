public class Perceptron {

    private int weight[];
    private int bias;
    private int biasWeight;
    private int learningRate;

    public Perceptron (int weight[], int bias, int biasWeight, int learningRate) {
        this.weight = weight;
        this.bias = bias;
        this.biasWeight = biasWeight;
        this.learningRate = learningRate;
    }

    public int calculateOutput(int input[]) {
        int sum = 0;
        // Summation
        for(int i = 0; i < input.length; i++) {
            sum += input[i] * weight[i];
        }
        sum += bias * biasWeight;
        // Degree function
        return sum >= 0 ? 1 : 0;
    }

    private void updateWeights(int input[], int err) {
        // Delta rule
        for(int i = 0; i < input.length; i++) {
            weight[i] += learningRate * err * input[i];
        }
        biasWeight +=  learningRate * err * bias;
    }

    public void train(int dataset[][], int expectedOutput[]) {
        int totalError;
        do{                 // Repeat the training while exists error.
            totalError = 0;
            for(int i = 0; i < dataset.length; i++){
                int err;
                do{
                    err = calculateOutput(dataset[i]) - expectedOutput[i];
                    updateWeights(dataset[i], err);

                    if(err != 0)
                    totalError++;
                }while(err != 0);
            }
        }while(totalError != 0);
    }

    @Override
    public String toString(){
        String string = "";
        for (int i : weight) {
            string += "weight: " + i + "\n";
        }
        string += "bias weight: " + biasWeight + "\n";
        return string;
    }

}