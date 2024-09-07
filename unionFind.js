const UnionFind = require('union-find')
class UnionFin {
    constructor(size) {
        // Initialize the parent array where each element is its own parent
        this.parent = Array.from({ length: size }, (_, i) => i);
        // Initialize the rank array to keep track of the tree height
        this.rank = Array(size).fill(1);
    }


    find(p) {
        // Find the root of the component/set containing `p`
        if (p !== this.parent[p]) {
            // Path compression optimization
            this.parent[p] = this.find(this.parent[p]);
        }
        return this.parent[p];
    }

    union(p, q) {
        // Find the roots of the elements
        const rootP = this.find(p);
        const rootQ = this.find(q);

        if (rootP !== rootQ) {
            // Union by rank optimization
            if (this.rank[rootP] > this.rank[rootQ]) {
                this.parent[rootQ] = rootP;
            } else if (this.rank[rootP] < this.rank[rootQ]) {
                this.parent[rootP] = rootQ;
            } else {
                this.parent[rootQ] = rootP;
                this.rank[rootP] += 1;
            }
        }
    }

    connected(p, q) {
        // Check if two elements are in the same set
        return this.find(p) === this.find(q);
    }
}

// Example Usage
// const uf = new UnionFind(10);

// uf.union(8,9)

// console.log(uf.rank[3], uf.connected(8,9));
// console.log(uf.parent);





// // Connect elements (0 and 1), (1 and 2), (3 and 4)
// uf.union(0, 1);
// uf.union(1, 2);
// uf.union(3, 4);

// // Check if elements are connected
// console.log(uf.connected(0, 2)); // Output: true (0 is connected to 2 via 1)
// console.log(uf.connected(0, 3)); // Output: false (0 is not connected to 3)

// // Connect elements (2 and 4)
// uf.union(2, 4);

// // Now check if elements are connected
// console.log(uf.connected(0, 4)); // Output: true (0 is now connected to 4 via 1, 2)



var forest = new UnionFind(10);

console.log(
    forest.link(3,2)

);
