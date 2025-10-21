import random
import matplotlib.pyplot as plt
import numpy as np

# -----------------------
# Simulate the guessing game
# -----------------------
class NumberGuessGame:
    def __init__(self):
        self.target = random.randint(1, 100)
        self.guess_count = 0
    
    def guess(self, n):
        self.guess_count += 1
        if n == self.target:
            return "Correct"
        elif n < self.target:
            return "Higher"
        else:
            return "Lower"

# -----------------------
# Agent using binary search
# -----------------------
def guess_number(game):
    low, high = 1, 100
    while True:
        guess = (low + high) // 2
        result = game.guess(guess)
        if result == "Correct":
            return game.guess_count
        elif result == "Higher":
            low = guess + 1
        else:
            high = guess - 1

# -----------------------
# Run many games and collect data
# -----------------------
num_games = 50000
all_guesses = []

for _ in range(num_games):
    game = NumberGuessGame()
    guesses_needed = guess_number(game)
    all_guesses.append(guesses_needed)

# Compute cumulative average guesses for learning curve
average_guesses = np.cumsum(all_guesses) / np.arange(1, num_games + 1)

# -----------------------
# Plot the learning curve
# -----------------------
plt.figure(figsize=(10,6))
plt.plot(range(1, num_games + 1), average_guesses, color='blue')
plt.xlabel("Game number")
plt.ylabel("Average guesses")
plt.title(f"Learning curve over {num_games} games")
plt.grid(True)
plt.show()
