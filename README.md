// hashmap is unordered because it stores data in the form of hashcode and index.

//concurrent Modification exception doesnot occur in copy on write arraylist because it uses two different object,CopyonWriteArraylist internally follow Iterator design pattern.

// CopyOnWriteArrayList uses segment level locking.
//Best Use Cases
Scenarios where reads significantly outnumber writes.
Applications where thread-safe iteration is required without additional synchronization.

