## Live Football World Cup Scoreboard

### Approach assumptions

1. Code is not covered with NPE check for simplicity. I made only validations for semantic input. However, in production code, I used to go with defensive programming and null checks in most cases.
2. I put my focus in making the code clean in my opinion with small methods, separated responsibilities, self documenting code using appropriate method names and reusing existing functionalities. 
3. I haven't created any dedicated exceptions, but I would do so, based on domain behaviour (like check with setting GameResult on finished game - MatchFixingException :-))

### Logical assumptions

1. I believe these are well documented in code, using self-descriptive method names and test cases.