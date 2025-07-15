package ShelterService;

public class Main {

    public static void main(String[] args) {
        ElasticArray<Integer> array1 = new ElasticArray<>();
        for(int i = 0; i < 5; i++){
            array1.write(i, 10 + i);
        }

        ElasticArray<Integer> array2 = new ElasticArray<>();
        for(int i = 0; i < 5; i++){
            array2.write(i, 20 + i);
        }
    }

    public static void swap(ElasticArray<Integer> array1, ElasticArray<Integer> array2) {
        int capacity = Math.max(array1.getCapacity(), array2.getCapacity());

        for(int i = 0; i < capacity; i++){
            int temp = (int) array1.read(i);
            array1.write(i, (int) array2.read(i));
            array2.write(i, temp);
        }
    }

    public static void reverse(ElasticArray<Integer> array) {
        // how to verify this reverse function
        int capacity = array.getCapacity();
        for(int i = 0; i < capacity / 2; i++){
            int temp = (int) array.read(i);
            array.write(i, (int) array.read(capacity - i - 1));
            array.write(capacity - 1 - i, temp);
        }
    }
}