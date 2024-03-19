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

The presence of equivalent mutants can lead to a misrepresentation of the mutation scores, thereby affecting the perceived quality of the test suite. Despite the test suite’s actual quality, the inability to detect these equivalent mutants can give an impression of lower quality. However, this is not an accurate reflection, as these mutants are inherently undetectable by any tests.

# A discussion of what could have been done to improve the mutation score of the test suites

The mutation coverage, which was established based on the tests we developed in labs 2 and 3, allowed us to create highly effective test suites for both the Range and DataUtilities classes. With DataUtilities nearing 78% mutation coverage, it was a difficult task to significantly enhance the coverage due to the presence of non-applicable or equivalent mutants. However, we scrutinized the mutation summaries for the statements and adopted a reverse-engineering approach to try and augment the coverage for DataUtilities. A similar strategy was employed for Range to eradicate some of the surviving mutants. In future, this same methodology can potentially be utilized to eliminate more mutants, thereby improving the mutation score.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

Mutation testing is essential as it provides an assessment of our test suite’s quality and its effectiveness in identifying errors.

Benefits of Mutation Testing:
- Mutation Testing is automated, reducing the need for manual intervention.
- Mutation Testing provides a mutation score, which serves as an indicator of when to cease testing and which test suite has superior quality.

Drawbacks of Mutation Testing:
- Mutation Testing can be time-intensive, which may slow down the development process.
- The existence of equivalent mutants, which are prevalent in System Under Test (SUTs), poses a challenge as these mutants cannot be eliminated.







# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

In Selenium, assertions serve as critical checkpoints that validate the System Under Test (SUT) is functioning as expected. For instance, assertions can be used to confirm whether a webpage is displaying the correct links, or to verify the presence or absence of a particular element. They can also be used to ensure that a specific element is visible or interactive. If an assertion fails, the test execution is halted and an error message is reported.


Conversely, checkpoints are utilized to confirm that a specific value or state is attained during the test execution. These are typically implemented using the “verify” command. This command inspects a specific property or attribute of an element and compares it with an expected value. If the actual value aligns with the expected value, the test proceeds. However, if there is a mismatch, the test execution is stopped and an error message is reported.

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

Selenium:

Advantages:
- Selenium offers extensive cross-platform and cross-browser support, enhancing its versatility and usability.

Disadvantages:
- Its application is limited to the testing of web applications only, restricting its scope.

Sikulix:

Advantages:

- Sikulix has the capability to automate Flash objects, providing a unique advantage.
- It also extends its automation capabilities to desktop applications, broadening its utility.

Disadvantages:

- Sikulix encounters challenges when it comes to cross-browser testing, limiting its effectiveness in diverse browser environments.


# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
