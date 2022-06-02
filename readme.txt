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
		  and we will create a custom one. we can name it however we like a and create a new package with the exception class, our class has to extend
		  an already existing exception superclass. in the class we will create a constructor that's going to call to a superclass thanks to the
		  super() method, and we will pass message as an argument.
	7) Next we create a Controller class, that's where we need to use the service. as we already know, we will annotate it with the @RestController
	   and @RequestMapping, to specify the URL 
		- in the controller, we will yet again create a constructor and inject the service into it
		- we create a class and @GetMapping, because we will be using the Get method
		- we will create a method of the type ResponseEntity, because we want to generate a HTTP response, it is a generic, therefore we need to pass
		  what type of data will be passed, we are going to put in List, and since List is generic too, we put the type Employee.
		- we will put all of the table data into our List in the method but we will return a List of employees in the body, that's why we have to specify
		  return new ResponseEntity<>(employees, HttpStatus.OK)
		- we create another method to find an employee by ID, we put an URL extension in GetMapping yet again with an id variable
		- this time around we want one employee, so that's what we put in ResponseEntity, in parameters of the method we put a path variable, which is the ID
		  obviously the ID, then we have an employee variable and we are returning a ResponseEntity yet again
		- next we create a method addEmployee, we use the @PostMapping annotation, we have a ResponseEntity again but this time we put @RequestBody in the parameters of the method, the
		  rest is pretty much the same, with us again returning a ResponseEntity 
		- the next method, updateEmployee is pretty much the same
		- for delete, we use the @DeleteMapping annotation and the url we want with a path variable yet again, this time around our ResponseEntity will be
		  empty, because we don't want to return anything, just delete
	8) We test whether our app works with Thunder client

[{
    "email": "daniel.craig@group.it",
    "imageUrl": "https://bootdev.com/img/Content/avatar/avatar1.png",
    "jobTitle": "JavaScript",
    "name": "Daniel Craig",
    "phone": "405014669"
},
{
    "email": "maria.caliente@group.it",
    "imageUrl": "https://bootdev.com/img/Content/avatar/avatar2.png",
    "jobTitle": "PHP",
    "name": "Maria Caliente",
    "phone": "325489522"
},
{
    "email": "max.skye@group.it",
    "imageUrl": "https://bootdev.com/img/Content/avatar/avatar3.png",
    "jobTitle": "HTML",
    "name": "Max Skye",
    "phone": "785231496"
}]

	9)
		

