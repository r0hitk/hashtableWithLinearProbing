# hashtableWithLinearProbing
A simple hash function based hashtable, using linear probes to deal with collisions.

This hashtable could've been built using quadratic probing or double hashing(hashing using two hash functions), but to keep things simple, it's been built using linear probing.

We can improve the frequency of collisions for this hashtable by simply improving the load factor or by using a better hash function.
In practice, there is no perfect hash function, so there will alwasys be a trade-off.
What we can do though, is we can keep the array dynamic, i,e. we can keep doubling the size of the array backing the hashtable, whenever the array is filled completely.

There is one another way to deal with this size limitaion of the backing array, and that's using chaining to handle collisions.
