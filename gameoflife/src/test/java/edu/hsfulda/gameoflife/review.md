Review by TPD-opitz

Overall this test looks good. It is quite close to how I'd write it myself.

# TDD

## test order
Assuming that you wrote the test in order of implementation it is a valid approach to start with the first requirement. 
## Test cases
You selected tescases according to the Boundary Value Analysis. This is a valid approach for unit tests.


The only thing is that you test date never contained "non alive" neigbours. This means a "dump" implementation only based on the *length of the list* would pass this tests too. According to the rules of TDD your solution should be based on the collection lengt since this is the *simplest possible* implementation passing the tests. 
## Use of mocks
It is good that you crated your mocks using the Mockito framework (instead of relying on the real dependencies).
### mock configuration
You reuse the same variable holding your mocks in multiple test cases. 
Therefor you need generic names for the neighbour cell variables. 
The douplicated configuration code could be reduced by having one variable holding a "dead cell mock" and a second one holding an "alive cell mock". 
Thies could have descriptive names like `deadNeighbour` and `aliveNeighbour` and would be configured in the setup method.
There is no problem adding the same instance of an object multible times to a list.

-----

You decides to use the `when().thenReturn()` form of mock configuration. This is OK since it is easier to understand for the reader. But you have to keep in mind that sometimes this form can cause problems, since it really executed the method of the mocked class (if it is no interface) and only replaces its result. Just keep that in mind.




# Formal review
## comments
Be stingy with comments, even in tests. 
Comments should tell *why* the code is like it is.
### Java Doc
The comment at the top of the file is useless since it does not give the reader any new information beyond the existence of the file. 
It *might* be useful if it would contain a brief description about your design decisions or stuff that is important to understand the role of the *tested unit* (not this test class) within your application (which is not mentioned in the tested unit itself).

### Inline Comments
You separated the 3 Parts of the unittest with inline comments. 
It is acceptable for you as a novice to place that reminders. (BTW: the first part is "arrange", not "assign")
Later on you should not write this comments but keep the parts separated visibly by one or more blank lines.
