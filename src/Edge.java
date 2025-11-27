class Edge {
    double weight;
    int destination;
    public Edge(double weight, int destination){
        this.destination = destination;
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public int getDestination() {
        return destination;
    }
    public String toString() {
        return " -> " + destination + " (Weight: " + weight + ")";
    }

}
