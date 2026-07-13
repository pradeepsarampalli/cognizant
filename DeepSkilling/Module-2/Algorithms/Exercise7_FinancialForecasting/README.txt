Exercise 7 - Financial Forecasting

Concept:
Recursion

Method:
predictValue(currentValue, growthRate, years)

Base Case:
years == 0

Recursive Relation:
futureValue = predictValue(currentValue * (1 + growthRate), growthRate, years - 1)

Time Complexity:
O(n)

Space Complexity:
O(n) due to recursive call stack.

Optimization:
The recursive solution can be converted into an iterative solution
or dynamic programming approach to avoid excessive recursive calls
for very large values of n.
