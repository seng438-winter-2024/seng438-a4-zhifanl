**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# Introduction

This lab report focuses on the exploration and understanding of two key testing methodologies: Mutation Testing and GUI Testing, applied to a selected website. The first segment of the assignment required students to delve into the intricacies of Mutation Testing. This involved the use of a tool known as PIT Mutations to introduce mutation faults into a Java code-base. The task was to interpret the mutation scores reported and analyze the mutants that were either killed or survived. This analysis was then used to devise new test cases aimed at enhancing the overall efficacy of the test suite. The second part of the assignment revolved around GUI Testing of a chosen website. This was accomplished through a prevalent approach to GUI test automation known as record and replay. The exercise provided an opportunity to learn and apply Selenium, a widely recognized tool for web interface testing, and compare its performance with other alternatives.

# Analysis of 10 Mutants of the Range class 

**Tested Method:**


public boolean intersects(double b0, double b1) 

**Tested Line in the Method:**

if (b0 <= this.lower)


**Raised Mutants:**


`1. Changed Conditional Boundary → SURVIVED`

This mutation likely changed b0 <= this.lower to b0 < this.lower or b0 > this.lower.

Since this mutation survived, it indicates that there was no test case specifically testing the boundary condition of b0 being exactly equal to this.lower. However, considering the provided test cases, it's surprising this mutant survived, as several test cases should cover boundary conditions.

`2. Negated Conditional → KILLED`

Negating b0 <= this.lower would cause the method's logic to change significantly.

It was killed, meaning at least one test case failed due to this change, which indicates good test coverage for the conditional logic's true and false paths.

`3. Removed Conditional - Replaced Comparison Check with False → SURVIVED`

This mutation makes the conditional always false, likely causing the method to always evaluate the else branch.

Its survival indicates a lack of test coverage for scenarios where b0 is less than or equal to this.lower.

`4. Removed Conditional - Replaced Comparison Check with True → KILLED`

By always making the condition true, the first branch is always executed.

This mutant being killed indicates that there are sufficient tests covering the case where b0 is less than or equal to this.lower.

`5. Negated Double Local Variable Number 1 → KILLED`

There's no direct mention of a double local variable being negated in the method provided, but if such a mutation occurred and was killed, it suggests the tests are sensitive to the value changes in the method's calculations.

`6. Negated Double Field Lower → SURVIVED`

Negating this.lower would impact how ranges are evaluated.

Its survival suggests that tests may not fully cover scenarios involving the lower bound of the range, especially edge cases.

`7-10, & 12-18. Various Comparison and Increment/Decrement Mutations → Mixed Outcomes`

Mutations involving changing comparison operators and incrementing or decrementing variables had mixed outcomes, with most being killed. This indicates a generally good level of test coverage for these operations, though the survival of some mutants (e.g., changing to >= or mutations on double field lower) suggests potential gaps in testing edge cases or specific boundary conditions.

`11. Greater Than to Not Equal → SURVIVED`

This suggests the tests might not differentiate between > and != effectively, possibly overlooking scenarios where values are exactly equal but not considered overlapping.

`19. Decremented (--a) Double Field Lower → SURVIVED`

Similar to other mutations on this.lower, its survival suggests insufficient testing around the lower bound values.



# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
