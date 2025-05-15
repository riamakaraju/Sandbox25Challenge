# Sandbox25Challenge

Design Decisions -------------------------------------------------------------------------------------
JSON -> Java
Following the guidance gven with Java's gson that the challenge page linked, I created separate classes for roles, reviews, and users, populating the Json data as objects of these classes user the separate file readers. Then, I assigned the list of all roles, reviews, and users to the attribute of the plural version of each class.

Java -> Java

Now, I had to figure out how to use the Java objects I created to the format that I want to return it in. I mainly did this using Maps (with key and value pairs) and Lists. HashMaps were used when there is a key value pair to be stored, such as "roleId" to 4582 or "name" to "Sarah Zhang". Since the values can be either int, float (for the average calculations), or String, I made most of the general HashMaps as <String, Object>. If there was an instance where I could specify for clarification, I did, but I kept it general to prevent errors. In the future if I had more time, I would clean this up so all the definitions would be exact and not too generalized.

Lists were used for the all the reviews under a certain role and to store the initial data in a place I could access from later.

The format of data I wanted to use was this:
companies
  - company 1
  -   role 1
  -     attributes
  -     list of reviews
  -       review 1
  -       review 2
  -       ....
  -   role 2
  -   ...
  - company 2
  - ....

To do this, I sorted all the reviews by roleId, all the roles by company, and created a dictionary map of userId to name to later access when populating the review attributes.

The documentation explains the proccess of how I built the nested maps and lists. (: 

Java -> JSON
I used gson to convert the final large one value long HashMap to JSON!

Challenges + What I Learned --------------------------------------------------------------------------

I think the biggest challenge I faced was that I decided to implement this in Java even though I only have basic AP CSA knowledge since I only took fundies 1 and am currently taking Fundies 2 this summer. Therefore, I had a vague idea of how to structure my classes, but I found that I had to play around with methods, especially in my Main.java file as some of the methods had to be placed outside the public static void main method for it to function.

Furthermore, I struggled understanding how Postman worked since I've never worked with JSON, but after some reading and experimenting, I figured it out pretty quickly! I learned that {} in JSON indicates the usage of a map and [] indicates Lists, so I structured my data as such.
