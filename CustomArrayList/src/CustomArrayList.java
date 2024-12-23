import java.util.Arrays;

public class CustomArrayList {
    // Internal data structure of ArrayList is an object array
    Object[] a = null;
    int index = 0;

    // Constructor with specified size
    CustomArrayList(int size) {
        a = new Object[size];
    }

    // Default constructor with size 10
    CustomArrayList() {
        a = new Object[10];
    }

    // Get element at specified index
    public Object get(int index) {
        if (index < 0 || index >= this.index) { // Check against actual data size
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return a[index]; // Corrected from objArray to a
    }

    // Add an object to the list
    public void add(Object obj) {
        if (index >= a.length) {
            int newSize = a.length + (a.length / 2);
            a = Arrays.copyOf(a, newSize); // Dynamically resize the array
        }
        a[index] = obj;
        index++;
    }

    // Remove an object at the specified index
    public Object remove(int indexToBeDeleted) throws Exception {
        Object obj = get(indexToBeDeleted); // Use get() to fetch the object
        int noOfShiftOperations = this.index - indexToBeDeleted - 1;
        if (noOfShiftOperations > 0) {
            System.arraycopy(a, indexToBeDeleted + 1, a, indexToBeDeleted, noOfShiftOperations);
        }
        a[--index] = null; // Decrease size and nullify the last element
        return obj;
    }

    // Override toString method to display the list contents
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(a, index));
    }

    // Main method to test the CustomArrayList
    public static void main(String[] args) {
        CustomArrayList cl = new CustomArrayList(5);
        cl.add(10);
        cl.add(20);
        cl.add(30);
        cl.add(40);
        cl.add(50);
        cl.add(70);
        cl.add(80);

        System.out.println("CustomArrayList contents: " + cl);

        try {
            System.out.println("Element at index 2: " + cl.get(2));
            System.out.println("Removing element at index 3: " + cl.remove(3));
            System.out.println("CustomArrayList after removal: " + cl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

