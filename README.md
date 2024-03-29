# High Level Design by Ishan

## Overview

This repository contains high-level design concepts and implementations. It serves as a resource for
understanding various topics, and best practices in software development.

## Table of Contents

1. [Introduction](#introduction)
2. [Topics](#topics)
3. [License](#license)

## Introduction

Welcome to the High Level Design by Ishan repository! Here, you will find code examples, explanations, and discussions
on a wide range of topics related to high-level software design. Whether you're a beginner looking to grasp fundamental
concepts or an experienced developer seeking insights into advanced architectural patterns, this repository aims to
provide valuable resources for all skill levels.

## Topics

* [Bloom Filters](#bloom-filters)

### Bloom Filters

Bloom filter is a space-efficient probabilistic data structure, that is used to test whether an element is a member of
a set or not. This data structure efficiently answer queries when we do not have enough "search key" space
to handle all possible questions. In this case, the "search key" is hashed, marked, and then used later to check if it
was searched earlier.

Bloom Filters use hashing as an immutable function result, and marking the respective positions in the data structure
guarantees that the subsequent search for the exact string will return true.

This data structure has an error rate when returning 'true', and we look into how the number of hash functions affects
its performance. In practice, Bloom Filters can be used to check for membership and to avoid 'One Hit Wonders'.

An example would be TinyURL, which can check if a URL has been previously generated using a bloom filter and regenerate
it if the answer is positive.

## License

This repository is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute the code in
this repository for both commercial and non-commercial purposes. See the [LICENSE](LICENSE) file for more details.
