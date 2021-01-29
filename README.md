# RoverBot
Figure out Rover Bot current position based on given position (North/East/South/East) of Rover Bot and after rotating Left/Right (0,90,180,270,360) & Moving Forward/backward

as of now input is passed in code directly

Logic: 

Initial Assumptions: Default position of Bot: North 
if Bot has to be moved LEFT then it will be moved North - West - South - East
if Bot has to be moved RIGHT then it will be moved North - East - South - West 
These will be saved in HahsMap<String,ArrayList<String>> where key is LEFT/RIGHT and its corresponding values
  
Based on Rotation, we need to iterate the arrayList i.e., 
90 -- rotate once
180 -- rotate twice
270 -- rotate thrice
0/360 - no rotation

After moving Both ends up
  i. EAST then Forward will be addition to X-axis else subtract
  ii.WEST then Forward will be Subtraction to X-axis else addition
  iii. NORTH then Forward will be addition to Y-axis else subtract
  iv.SOUTH then Forward will be Subtraction to Y-axis else addition

Now, based on Rotation in input get the Rotation array mode from HashMap defined and now iterate the arrayList till you find the given Position and get index of it and 
Add the rotate count (once,twice,thrice,none) based on value and if it's greater than or equal to 4 then we need to subtract 4 from it and if it's less than 4 then the direction is at index + rotate count


Eg: RoverBot is at West and have to rotate 270 RIGHT then RoverBot will be at South

given t's RIGHT direction Arraylist will be North - East - South - West 

and it's 270 so rotate count: thrice

Index of West is 3

Index of West + Rotate count i.e., 3+3 = 6 which is greather than 4 so 6-4 =2 i.e., South 
