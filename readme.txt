Employee Manager app using Java, Spring Boot, Angular, HTML, CSS

a web app to test full stack knowledge (or to gain it :]) 

	1) First things first, we use spring initialzr to generate our project and add dependencies
	2) We create a new package (directory) to separate the models from the "main" app
	3) First we create Employee, which is the same old thing you know by now and specify its attributes, including an imageURL, but we say its type is a
	   string as using java File type is not ideal
		- our class implements Serializable as we need it to be a lot of different types of streams (database, JSON, strings,...), it helps with the whole process
		- we annotate all values inside our Employee class to correspond with a table in the database (you already know from Spring Data JPA)
		- we don't have to specify every column, only the ones that have some extra parameters, but it is okay if we do it regardless
	4) Then we create a connection to the database, writing into the application.properties
		- important note: spring.jpa.hibernate.ddl-auto (ddl stands for data description) tells the database what to do with the data
		  e.g. if we tell it to create-drop, it's going to create and delete the table every single time.
		       if we tell it to update, it's going to keep the table and update the data
	5) Our own repo has been created, it's once again an interface that extends JpaRepository
	6) We create a service class, and inject the repo into the service constructor, of course we have to use annotations: @Service, @Autowired
		- we add a method for adding employees and use a UUID to generate a random string for employee code
		- then we create a method for finding all employees in an ArrayList
		- we continue to create methods
		- when we create an optional in repo (e.g. here it is for the findEmployeeByID method), we have to put a method to throw an error
