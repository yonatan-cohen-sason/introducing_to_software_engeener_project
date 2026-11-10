# TESTING

## Reward Traces

defeating first enemy inputs: 3 -> 1 -> 1
### outputs:
First fight:
player HP: 100 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 3
3
player HP: 90 Player Resource: 2 Player attack: 10 a HP: 15
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 1
1
player HP: 80 Player Resource: 2 Player attack: 10 a HP: 5
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 1
1
Player status: HP-80 resources-2 Attack-10
choose a reward: 
 1 - recovery 
 2 - power


### player status:
player HP: 80
Player Resource: 2
Player attack: 10





### trying recovery:
input: 1

#### outputs:
Next round, second fight:
player HP: 100 Player Resource: 2 Player attack: 10 b HP: 45
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 

### player status:
player HP: 100
Player Resource: 2
Player attack: 10



### trying power:
input: 2

#### outputs:
Next round, second fight:
player HP: 80 Player Resource: 2 Player attack: 12 b HP: 45
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 

### player status:
player HP: 80
Player Resource: 2
Player attack: 12




## Failure Traces

### invalid reward choice - choosing 67 then 2
inputs: 3 -> 1 -> 1 -> 67 -> 2
outputs:
First fight:
player HP: 100 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 3
3
player HP: 90 Player Resource: 2 Player attack: 10 a HP: 15
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 1
1
player HP: 80 Player Resource: 2 Player attack: 10 a HP: 5
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 1
1
Player status: HP-80 resources-2 Attack-10
choose a reward: 
 1 - recovery 
 2 - power
67
Unknown decision, try again
choose a reward: 
 1 - recovery 
 2 - power
2
Next round, second fight:
player HP: 80 Player Resource: 2 Player attack: 12 b HP: 45
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 



 ### loss handling
 inputs: 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2 -> 2
 outputs:
 First fight:
player HP: 100 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 95 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 90 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 85 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 80 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 75 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 70 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 65 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 60 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 55 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 50 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 45 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 40 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 35 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 30 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 25 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 20 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 15 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 10 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
player HP: 5 Player Resource: 5 Player attack: 10 a HP: 30
choose an action: 
 1 - attack the enemy  
 2 - defend 
 3 - special 
 4 - recover 2
2
You lose!



## Tests


| Test | Initial State / Input | Expected Result | Actual Result |
|---|---|---|---|
| T1 | HP 90, Recovery | HP 100, other stats unchanged | HP reached 100, resource and Attack unchanged. PASS |
| T2 | HP 100, Recovery | HP 100, reward consumed | HP stayed 100, reward was consumed. PASS |
| T3 | Attack 10, Power | Attack 12, Special 15 | Attack increased to 12, Special stayed 15. PASS |
| T4 | Invalid input, then Power | No change on error, Power applied once | Invalid input was rejected without changing stats. Power was applied once. PASS |
| T5 | Call reward() before winning Encounter 1 | No reward, player stats unchanged | Reward was rejected, Attack stayed 10. PASS |
| T6 | Try to claim a second reward | Rejected, no change | Second reward request was rejected, player stats unchanged. PASS |
| T7 | Lose Encounter 1 | No reward, no Encounter 2 | Game ended after defeat, no reward or second battle. PASS |
| T8 | Finish Encounter 1 with HP 80, resource 2 | Values preserved unless reward changes HP | HP 80 and resource 2 carried over (before reward effects). PASS |
| T9 | Defeat Enemy 2 with a finishing attack | Victory, no counterattack | Victory message displayed, no enemy counterattack. PASS |

## Design Note

In this project, I used contracts and invariants to make sure the game works correctly and the player's state stays valid.

The Combatant class is responsible for storing and changing the player's HP, resources, defense and attack damage. Its invariants make sure that HP always stays between 0 and 100, resources stay between 0 and 10, and attack damage is not negative. For example, the gain_health() method uses Math.min() to make sure HP never goes above 100.

I also used preconditions and postconditions to describe what must be true before and after calling methods. For example, the precondition of gain_health() requires the amount to be non-negative, and its postcondition describes the new HP.

The `Battle` class manages the fights and the reward system, while `Main` controls the order of the two fights. When the player wins the first fight, `main_battle()` makes the reward available. It uses the `firstEncounter` parameter to know whether this is the first battle. Then, `Main` calls `reward()` to let the player choose a reward. The booleans `rewardAvailable` and `rewardClaimed` prevent the player from claiming a reward before it becomes available or claiming more than one reward.

If the player enters an invalid reward choice, the game asks again without changing the player's state. The POWER reward increases basic attack damage to 12, while Special still deals 15 damage.

## AI reflection
Useful suggestion: AI suggested checking what happens if unlockReward() is called before winning the first battle. This helped me find a problem where the reward could be unlocked without winning. I fixed it by removing unlockReward() and changing main_battle() to unlock the reward only after winning the first encounter.

Rejected suggestion: AI suggested testing what happens when two adventures run in the same Java process. I decided not to add support for multiple adventures because my game is designed to run one adventure with two battles each time the program starts.

**Independent verification:** I tested entering an invalid reward choice (67) and then choosing POWER (2). The game displayed an error message and asked again. After choosing POWER, the player's HP stayed at 80, resources stayed at 2, and Attack increased from 10 to 12. This confirmed that the invalid choice did not change the player's state.