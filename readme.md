***Movie Characters API***

`    `This is the third assignment of the BackEnd section of Noroff FullStack course. It is a Spring Web Application, forwards the user-requested data provided from an external source (data.sql file in root) through layers (Entries, Repositories, Services, Mappers and DTOs, Controllers) up to the user’s browser. 

`    `The path that we took was similar to the one we took for the 2nd assignment, having four branches one for each of us, one secondary that is used for merging the commits from our respective branches, working basically as a collective back-up branch and lastly the master branch which is the final product of the assignment. We started relatively early and by the second day we were done with Appendix A and already made progress on aspects of Appendix B.  

`    `We worked, in almost the entirety of the assignment, by the standards of Pair Programming, while still partly worked each by themselves on tasks that was previously discussed and determined between us (ex: non-CRUD methods that required some modest problem solving were worked solo, and later we reviewed each other’s solution).

The project below consists of the main SpringBootApplication Class and six packages that represent the layers of the application, from the database to the FrontEnd. The mentioned above packages are described below:

1) ***Models package***: contains Entity Classes for each of our Database Tables, and a DTO package that contains the required Data Transfer Object Classes for each of our Entries (one with several fields and one with only Id that is used in delete() methods in controller Classes.<br><br/>
   
1) ***Repositories package***: contains a Repository Interface for each entry, which inherits methods from the JpaRepository Interface. Because of its generic nature, we had to include the types Entry, Integer at the JpaRepository brackets (so it looks like JpaRepository<EntryClass, Integer>, where entry class is the classes from the models package.<br><br/>

1) ***Service package:*** contains a package for each entry class with an Interface – Class pair and the CrudService Interface, that declares the following methods: findAll(), findById(), add(), update(), deleteById(), delete(), exists(). The interface in each subpackage inherits CrudService and, if required, declare additional and the classes implement every method.<br><br/>

1) ***Mappers package:*** contains an Interface for each Entry Class “maps” the corresponding DTO, so then each method of the controller classes has its behavior defined. These methods are implemented by the MapStruct API, so their implementation classes are not included, thus they are generated in the build package.<br><br/>

1) ***Controllers package:*** contains a class for each Entry, which with the use of the each time required DTO, converts the user-requested data to a JSON object and is displayed to the FrontEnd.


**Εxplanation of some important functions :**

1. ***updateCharacters(int movieId, int[] characters)*** : This function is at MovieServiseImpl java class and the goal is to update the characters in a movie. It takes as the id of the movie arguments and an array of ids of the characters which are going to be added at the movie. First of all we are creating a Movie object and taking the movie with the given id. Then we are making a Set with name characterList to hold all the characters. Later, in a loop for each character id, it being added at the characterList the character that has the current id. Afterwards, we are calling the function setCharacters with the movie object to put the characters in characterList at this movie object. Finally, we are calling the save method of MovieRepository to save the updated movie with the new characters. <br><br/>

1. ***updateMovies(int franchiseId, int[] movies)*** : This function is at FranchiseServiseImpl java class and the goal is to update the movies in a Franchise. It takes as arguments the id of the franchise and an array of ids of the movies which are going to be added at the franchise. First of all we are creating a franchise object and taking the franchise with the given id. Then we are making a Set with name movieList to hold all the movies. Later, in a loop for every movie id, it being added at the movieList the movie who has the current id. Afterwards, we are calling the function setMovies with the franchise object to put the movies in movieList at this franchise object. Finally, we are calling the save method of franchise repository to save the updated franchise with the new movies.<br><br/>

1. ***getCharacters(int franchiseId) :*** This function is at FranchiseServiseImpl java class and the goal is to return all the characters in a franchise. It takes as arguments the id of the franchise. Firstly, we are creating a collection named movies, with the movies of the franchise with the given id. Then, we are creating a collection with name charactersOfMovies, which will hold all the characters of every movie in a franchise. Later, for each movie in the franchise, we are adding the characters in the charactersOfMovies collection. Finally, it returns the collection of the characters.<br><br/>

1. ***deleteById()*** : This function is at CharacterServiseImpl java class and the goal is to delete a character with the specific id. Our first attempt is to remove the movies of the specific character, to be able to delete this character. We are achieving that in a for loop for every movie in movies Set of character, in which we are removing each movie by characterRepository getting the reference of the movie by id and then we are calling the function removeMovie(). Finally, we are deleting the character by the given id. <br><br/>



