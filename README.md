# Travelling Salesman Problem

## Team Number : 213
#### Akash Anand    NUID : 001873134
 #### Karan Saini   NUID : 001828012

# Problem Statement

In Simplest terms ,Genetic algorithms are an optimization technique used to solve nonlinear or non differentiable optimization problems.
The purpose of this project is to implement the methodology of genetic algorithms to obtain the result for an NP problem.For Our Implementation we have choosen a very famous problem,Travelling Salesman.Given a set of cities and distance between every pair of cities, the problem is to find the shortest possible route that visits every city exactly once and returns to the starting point.


## Design of Algorithm

### Genotype and Phenotype

Genotype is the digital information that is passed down generation to generation.Phenotype is an expression of data.

For this TSP problem we have considered the order of array index as genotype, which intern are stored in an array


### Crossover
For crossover, it is not always best to choose the fittest among the population, every gene should be considered for better variation in the population

But the genes with high fitness value should have high chances of being selected and the gene with low fitness value should have less chances. Therefore, normalized fitness values are assigned to each gene

### Mutation


### Evolution