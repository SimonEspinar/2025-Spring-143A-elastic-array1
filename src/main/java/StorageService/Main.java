package StorageService;

public class Main {

    public static void main(String[] args) {
        ElasticArray array1 = new ElasticArray();
        for(int i = 0; i < 5; i++){
            array1.write(i, 10 + i);
        }

        ElasticArray array2 = new ElasticArray();
        for(int i = 0; i < 5; i++){
            array2.write(i, 20 + i);
        }
    }

    public static void swap(ElasticArray array1, ElasticArray array2) {
        int capacity = Math.max(array1.getCapacity(), array2.getCapacity());

        for(int i = 0; i < capacity; i++){
            int temp = array1.read(i);
            array1.write(i, array2.read(i));
            array2.write(i, temp);
        }
    }

    public void reverse(ElasticArray array) {
        // how to verify this reverse function
        for(int i = 0; i < array.getCapacity() / 2; i++){
            int temp = array.read(i);
            array.write(i, array.read(array.getCapacity() - i - 1));
            array.write(array.getCapacity() - 1 - i, temp);
        }
    }
}