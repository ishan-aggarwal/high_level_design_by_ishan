package com.ishan;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class BloomFilterMain {
    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = new BloomFilter<>(1000);
        bloomFilter.add(141432);
        bloomFilter.add(2354364);
        System.out.println(bloomFilter.exists(141432));
        System.out.println(bloomFilter.exists(723));
        //This should be false, but bloom filters provide no guarantee on definite existence
        System.out.println(bloomFilter.exists(1432));
        System.out.println(bloomFilter.exists(2354364));
    }

    static class BloomFilter<T> {
        private final long[] points;
        private final int size;
        private final List<Function<T, Integer>> hashFunctions;

        BloomFilter(final int size) {
            this.size = size;
            points = new long[(size + 63) >> 6];
            hashFunctions = Arrays.asList(multiplyWith(29), multiplyWith(19), multiplyWith(17));
        }

        private Function<T, Integer> multiplyWith(final int i) {
            return t -> (t.hashCode() * i) % size;
        }

        private void mark(int hash) {
            hash %= size;
            points[hash >> 6] |= (1L << (hash & 63));
        }

        private boolean isMarked(int hash) {
            hash %= size;
            return (points[hash >> 6] & (1L << (hash & 63))) != 0;
        }

        public void add(final T value) {
            hashFunctions.stream().map(function -> function.apply(value)).forEach(this::mark);
        }

        public boolean exists(final T value) {
            return hashFunctions.stream().map(function -> function.apply(value)).allMatch(this::isMarked);
        }
    }
}

