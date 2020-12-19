public class UnionFind {

    // The number of elements in union find
    private int size = 0;

    // Use to track the sizes of each components
    int[] componentsSize;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] id;

    // Tracks the number of components in the union find
    private int numberComponents;

    public UnionFind(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size <= 0 is not allowed");
        }

        this.size = numberComponents = size;

        componentsSize = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i; // Link to itself (self root)
            componentsSize[i] = 1; // Each ccomponent is originally of size one
        }
    }

    // Find which component/set 'p' belong to, take amortize constant time
    public int find(int p) {
        // Find the root of the component/set
        int root = p;

        while (root != id[root]) {
            root = id[root];

            // Compress the paht leading back to the root.
            // Doing thins operation is called "path compression"
            // and is what give us amortize time complexcity.
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
        }

        return root;
    }

}