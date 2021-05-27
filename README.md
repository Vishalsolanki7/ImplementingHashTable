# ImplementingHashTable
1.  a Java class, writing a method that creates n random strings of length 10 and inserts them in a hash table. The method computesthe average time for each insertion.
The code is in the package Assignment1 and class Task1.java.
2.  method that finds n random strings in the hash table. The method should delete the string if found. It should also compute the average time of each search.
The code is in the package Assignment1 and class Task2.java
3. Repeating and #2 with n = 2i, i = 1, …, 20. Place the numbers in a table and compare the results for Cuckoo, QuadraticProbing and SeparateChaining. Comment on the times obtained and compare them with the complexities 
The code is in the package Assignment1 and class HashImplementationAndAnalysis.java.
1.	Complexities of a Hash Table/Map with Cuckoo Hashing 
	Worst-Case Time Complexity 
	Average-Case Time Complexity 
	Best-Case Time Complexity 

Find	O(1)	O(1)	O(1)
Insert	O(n)	O(1)	O(1)
Remove	O(1)	O(1)	O(1)

O(n) — Hash Tables typically have a capacity that is at most some constant multiplied by n (the constant is predetermined)

2.	Complexities of a Hash Table/Map with Separate Chaining
	Worst-Case Time Complexity 
	Average-Case Time Complexity 
	Best-Case Time Complexity 

Find	O(n)	O(1)	O(1)
Insert	O(n)	O(1)	O(1)
Remove	O(n)	O(1)	O(1)


O(n) — Hash Tables typically have a capacity that is at most some constant multiplied by n (the constant is predetermined), and each of our n nodes occupies O(1) space

3.	Complexities of a Hash Table/Map with Quadratic Probing
	Worst-Case Time Complexity 
	Average-Case Time Complexity 
	Best-Case Time Complexity 

Find	O(1)	O(1)	O(1)
Insert	O(nlogn)	O(1)	O(1)
Remove	O(1)	O(1)	O(1)

4.Use the Java classes BinarySearchTree, AVLTree, RedBlackBST, SplayTree. For each tree:
a. Insert 100,000 integer keys, from 1 to 100,000 (in that order). Find the average timefor each insertion. Note: you can add the following VM arguments to your project: -Xss16m. This will help increase the size of the recursion stack.
b. Do 100,000 searches of random integer keys between 1 and 100,000. Find the average time of each search.
c. Delete all the keys in the trees, starting from 100,000 down to 1 (in that order). Find the average time of each deletion.
The code is in the package Assignment1 and classes BinarySearchTree.java, AVLTree.java, RedBlackBST.java and SplayTree.java.

5. For each tree:
a. Insert 100,000 keys between 1 and 100,000. Find the average time of each insertion.
b. Repeat #4.b.
c. Repeat #4.c but with random keys between 1 and 100,000. Note that not all the keys may be found in the tree
The code is in the package Assignment1 and classes BinarySearchTree2.java, AVLTree2.java, RedBlackBST2.java and SplayTree2.java.

6. Draw a table that contains all the average times found in #4 and #5. Comment on the results obtained and compare them with the worst-case and average-case running times of each operation for each tree. Which tree will you use in your implementations for real problems?
Conclusion:

Each Table has its unque use cases for instance AVL tree is best technique for searching and BinarySearch Tree is quickest at deletion.
After implementing each of the above table I will consider Splay tree implementation for real problems as it has the best time complexity.


