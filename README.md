```
.____    .__               ___________            __ ___.          .__  .__   
|    |   |__|__  __ ____   \_   _____/___   _____/  |\_ |__ _____  |  | |  |  
|    |   |  \  \/ // __ \   |    __)/  _ \ /  _ \   __\ __ \\__  \ |  | |  |  
|    |___|  |\   /\  ___/   |     \(  <_> |  <_> )  | | \_\ \/ __ \|  |_|  |__
|_______ \__| \_/  \___  >  \___  / \____/ \____/|__| |___  (____  /____/____/
        \/             \/       \/                        \/     \/           
 __      __            .__       .___ _________                               
/  \    /  \___________|  |    __| _/ \_   ___ \ __ ________                  
\   \/\/   /  _ \_  __ \  |   / __ |  /    \  \/|  |  \____ \                 
 \        (  <_> )  | \/  |__/ /_/ |  \     \___|  |  /  |_> >                
  \__/\  / \____/|__|  |____/\____ |   \______  /____/|   __/                 
       \/                         \/          \/      |__|                    
  _________                         ___.                          .___        
 /   _____/ ____  ___________   ____\_ |__   _________ _______  __| _/        
 \_____  \_/ ___\/  _ \_  __ \_/ __ \| __ \ /  _ \__  \\_  __ \/ __ |         
 /        \  \__(  <_> )  | \/\  ___/| \_\ (  <_> ) __ \|  | \/ /_/ |         
/_______  /\___  >____/|__|    \___  >___  /\____(____  /__|  \____ |         
        \/     \/                  \/    \/           \/           \/         
```


### Approach assumptions

1. Code is not covered with NPE check for simplicity. I made only validations for semantic input. However, in production code, I used to go with defensive programming and null checks in most cases.
2. I put my focus in making the code clean in my opinion with small methods, separated responsibilities, self documenting code using appropriate method names and reusing existing functionalities. 
3. I haven't created any dedicated exceptions, but I would do so, based on domain behaviour (like check with setting GameResult on finished game - MatchFixingException :-))

### Logical assumptions

1. I believe these are well documented in code, using self-descriptive method names and test cases.