# Java Battle Game week 1

# How to Compile
Open the terminal in the folder thats containing edu and run this command:
javac -d . edu\starter\Main.java

# How to Run
run this command in the terminal in the folder thats containing edu:
java -cp . edu.starter.Main

# How to Test
For each test, start a new game. The player starts with 100 HP and 5 resources, and the enemy starts with 30 HP (except for W01-RES-01).

Test 1 – W01-ATK-01

Run the game.
Enter 1 (Attack).
Check that the enemy has 20 HP.
Test 2 – W01-DEF-01
Run a new game.
Enter 2 (Defend).
Check that the player has 95 HP.

Test 3 – W01-SPC-01
Run a new game.
Enter 3 (Special).
Check that the enemy has 15 HP and the player has 2 resources.

Test 4 – W01-RES-01
Temporarily change the player's starting resources from 5 to 9 in the player_class constructor.
Compile and run the game again.
Enter 4 (Recover).
Check that the player's resources increase to 10, not 12.
Change the starting resources back to 5 after the test.

Test 5 – W01-INV-01
Run a new game.
Enter hi (or any invalid input of your choice).
Check that the enemy does not counterattack and the game state remains unchanged:
Player HP = 100
Enemy HP = 30
Player resources = 5