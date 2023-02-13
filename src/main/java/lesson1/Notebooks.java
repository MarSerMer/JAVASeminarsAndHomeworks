package lesson1;
//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
public class Notebooks {
    private String model;
    private Double price;
    private String color;
    private Double weight;
    private Double screenSize;
    private Integer processorCores;
    private Integer ram;

    public Notebooks (String model,Double price,String color,Double weight,Double screenSize,Integer processorCores,Integer ram){
        this.model = model;
        this.price = price;
        this.color = color;
        this.weight = weight;
        this.screenSize = screenSize;
        this.processorCores = processorCores;
        this.ram = ram;
    }
    public Notebooks(){

    }
    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
    public Integer getRam() {
        return ram;
    }
    public Double getWeight() {
        return weight;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public Integer getProcessorCores() {
        return processorCores;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public void setProcessorCores(Integer processorCores) {
        this.processorCores = processorCores;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public static void printNotebook(Notebooks nbToPrint){
        System.out.println(nbToPrint.model);
        System.out.printf("Price: %.2f roubles; color: %s; weight %.2f kg.; screen %.2f inches; %d cores in processor; %s GB RAM\n",nbToPrint.price, nbToPrint.color, nbToPrint.weight, nbToPrint.screenSize,nbToPrint.processorCores,nbToPrint.ram);
    }
}

