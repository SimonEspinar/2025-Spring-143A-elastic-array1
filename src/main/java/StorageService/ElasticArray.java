package StorageService;

/*
 * Requirement: ElasticArray
 *
 * Overview:
 * The ElasticArray class simulates a dynamic, integer-based array that grows in fixed-size chunks
 * when a write is attempted beyond its current capacity. It mimics behavior similar to an ArrayList,
 * but only supports indexed read and write operations. The internal array begins with a fixed initial
 * capacity and expands as needed during writes. Reads from invalid indices throw exceptions.
 *
 * Specifications:
 * - Initial capacity: 50 elements
 * - Growth strategy: Resize the internal array by fixed-size chunks (chunkSize = 500)
 * - Data type: int[]
 *
 * Functionality:
 * 1. Constructor:
 *    - Initializes the internal array with the initial capacity (50).
 *
 * 2. void write(int index, int value):
 *    - If index is negative, throws IllegalArgumentException.
 *    - If index is within current capacity, directly assigns value.
 *    - If index exceeds current capacity:
 *        - Grows the internal array by repeatedly adding chunkSize (500) until the array can fit the index.
 *        - Copies existing elements manually into the new array.
 *        - Updates the internal capacity and array reference.
 *        - Assigns the value at the given index.
 *
 * 3. int read(int index):
 *    - If index is negative or greater than or equal to capacity, throws IndexOutOfBoundsException.
 *    - Otherwise, returns the value at the given index.
 *
 * 4. int getCapacity():
 *    - Returns the current capacity of the internal array.
 *
 * 5. int getChunkSize():
 *    - Returns the fixed chunk size used for resizing (500).
 *
 * Error Handling:
 * - Writing to a negative index throws IllegalArgumentException.
 * - Reading from a negative index or an index beyond capacity throws IndexOutOfBoundsException.
 *
 * Use Cases:
 * - Dynamic simulation of array-like data structures where the maximum index is not known in advance.
 * - Educational demonstrations of dynamic memory management and array resizing.
 */

public class ElasticArray {
    private int capacity;
    private int chunkSize;
    private int[] data;

    // Getter
    public int getCapacity() {
        return capacity;
    }

    // Here is our constructor
    public ElasticArray() {
        this(50, 500);
    }

    // Another constrcutor

    public ElasticArray(int capacity, int chunkSize) {
        this.capacity = capacity;
        this.chunkSize = chunkSize;
        data = new int[capacity];
    }

    public void write(int index, int value) {
        if(index < capacity){
            data[index] = value;
            return;
        }
        else{
            while(capacity <= index) {
                capacity = capacity + chunkSize;
            }
            int[] newArray = new int[capacity];
            for(int i = 0; i < data.length; i++){
                newArray[i] = data[i];
            }
            newArray[index] = value;
            data = newArray;
        }
    }

    public int read(int index) {
        if(index >= 0 && index < capacity){
            return data[index];
        }
        throw new IndexOutOfBoundsException("Index is negative");
    }
}