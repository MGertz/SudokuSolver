# SudokuSolver

This is a sudoku solver, which bruteforce its way to a solution for a sudoku.

You enter a simple sudoku pussle, 0 at places, that doesnt have any number.

The solver, then find the first free space, check if it can place a 1, if not then 2...

When it finds a number it can place in the free spot, it adds it, and goes to the next free number. If a freeplace, cant contain any of the last digits in the row, colums or box, it will go back, to the number before, add 1 to that number, and keep trying.

To solve the default puzzle, thats in main class, it loops through the functionality 35988 times. before it finds a solution.