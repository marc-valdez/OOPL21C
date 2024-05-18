# Codemaster

1. Select four code pegs (no duplicates)
    - initialize a peg list
    - initialize a list of available colors
    - for each peg, generate a new color from available colors and remove it from the list of available colors
2. Check **codebreaker** guess:
    - if a peg is accurate in **color** and **position**, insert a ***black*** peg into the _response_
    - if a peg is accurate in **color** but in a misplaced **position**, insert a ***white*** peg into the _response_
    - otherwise, do nothing
3. Repeat until the turns run out

# Codebreaker

1. Select these as starting pegs [1, 2, 3, 4]
2. Remember the response
3. Select these as the next pegs [1, 2, 3, 5]
4. Compare new response to previous response
5. Select these as the next pegs [1, 2, 3, 6]
6. Compare this response to the last response
7. Repeat until we get **4** response pegs (color doesn't matter), which means the right numbers are selected
8. Repeat sorting the pegs until all responses are black pegs, or until the turns run out

# Objects

## CodePegs

### Peg

- Color

### List of Pegs

### List of Available Colors

### GenerateColor(Peg at Index)

## ResponsePegs

### Peg

- Color

### List of ResponsePegs

### SendResponse(List of GuessPegs)
