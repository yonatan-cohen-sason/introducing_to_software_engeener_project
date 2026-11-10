# Java Battle Game week 2
## How to Compile
Open the terminal in the folder thats contains the edu folder and run this command:
`javac -d . edu\starter\Main.java`

## How to Run
Run this command in the same folder:
`java -cp . edu.starter.Main`

## How to Test
For each test start a new game. The player starts with 100 HP and 5 resources. The first enemy starts with 30 HP and the second enemy starts with 45 HP.

Test 1 - W02-ENC-01, W02-ENC-02
Run the game
Enter these inputs in order: 3 -> 1 -> 1
Check that the second fight starts with:
Player HP = 80
Player resources = 2
Enemy HP = 45

Test 2 - W01-INV-01
Run a new game
Enter 3 (Special)
Enter 3 (Special) again
Check that the second Special doesn't work and the enemy doesn't attack:
Player HP = 90
Enemy HP = 15
Player resources = 2

Test 3 - W01-END
Run a new game
Enter these inputs: 3 -> 1 -> 1
Check that the enemy reaches 0 HP and doesn't attack again.

Test 4 - Recover at maximum resource
Run a new game
Enter these inputs: 4 -> 4 -> 4
Check that the resources reach 10 and the third Recover doesn't change anything or cause an enemy attack.

Test 5 - TERM
Run a new game
Keep entering 2 (Defend) until the player reaches 0 HP.
Check that the game prints "You lose!" and doesn't start the second fight.

## More Tests
The PDF file contains the other tests (T1-T7), the Design Note and the AI Note.