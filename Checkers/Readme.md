# Checkers Game Project

## Team Members:
- **Fardin Saad** 
- **Saadman Malik** 
---

## Overview

**Checkers** is a strategy board game played on an 8x8 board, where players move diagonally and capture opponent pieces by jumping over them. The objective of the game is to capture all of the opponent’s pieces or block them from making any legal moves.

In this project, we developed a digital version of Checkers with several key features implemented in **C** and **C++** in our **freshman year** for the **Structure Programming course**.

### Game Rules
1. **Movement**: 
   - A checker moves one space diagonally forward.
   - A checker cannot move backward until it is crowned a king.
   - If a jump is available, it must be taken.

2. **Jumping**:
   - A player must jump over an opponent’s piece if an opportunity is available, capturing that piece.
   - Multiple jumps are possible if they are available in a sequence.

3. **Crowning**:
   - When a checker reaches the opposite side of the board, it is crowned and becomes a king.
   - A king can move and jump diagonally in both directions (forward and backward).

---

## Key Features

### Board Representation
- The game board is represented as a **2D array**, with different digits representing various states:
  - `0`: Non-playable space (empty).
  - `1`: Playable space (empty).
  - `2`: Red player's piece.
  - `3`: Black player's piece.
  - `4`: Red player's king.
  - `5`: Black player's king.

### Timer
- Each player has **30 seconds** to make their move.
- If the time expires, a random move is automatically made for the player.

### Random Move
- If the timer runs out or a player doesn’t make a valid move, the system automatically moves a randomly selected checker to a valid space.

### Save & Load
- Players can save their game at any point, and resume from the saved state later.
- The game board and scores are saved in a file called `array`.

### Leaderboard
- The leaderboard tracks player performance, logging wins and losses.
- If a player captures all 12 of their opponent's pieces, the winner’s name is recorded on the leaderboard.

### Advanced Gameplay Features
- **Normal Movement**: Players can move diagonally forward unless their piece is crowned.
- **Double Jump**: If a player can capture multiple pieces in a sequence, they are required to make all available jumps.
- **King Movement**: A crowned piece (King) can move both forward and backward along diagonals.

---

## Explanation of Code

- The game board is displayed by scanning the 2D array and printing characters representing the pieces.
- Movement and jumping logic are based on checking the board’s state and ensuring valid moves.
- A **timer** loop ensures that players have limited time to move.
- **Save and load** functionality uses file I/O to store the game state.
- The **leaderboard** is updated after every game to reflect the results.

---

## How to Play
- Players take turns to move their pieces diagonally across the board.
- Pieces are captured by jumping over them.
- The first player to capture all of their opponent’s pieces or block them from making any legal moves wins the game.

---

## Conclusion
This project aimed to replicate the classic Checkers game with an interactive timer, leaderboard, and random move features. We hope you enjoy playing it!

**Thank you for checking out our project!**
