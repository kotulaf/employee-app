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

	9) Install Angular and create your new project inside your desired directory
		- inside our app directory, in src/app/ create xxxxx.ts, an export interface of the name Employee, which represents the type of data thats inside
		- next file will be employee.service.ts, where we add our functions, more in the file
		- next we want to create a service, which we do using the "ng generate service name --skipTests=true" command, which creates name.service.ts, 
		  which will contain our functionality, or its shell
		- next we will go into app.components and that will serve a similar purpose to controller in spring boot, we are going to put our functions into it,
		  the functions are too complicated to be described here, so you'll have to check the file, but it is very simple to understand. I will describe some
		  of the key methods here:
						. everything is pretty straightforward except for the .subscribe() method, which we use to track data whenever we get a
						  response from the server
						. to our employee variable we defined we assign the response body, we also have to handle errors, perhaps why we use the
						  alert(error.message) method	 
		- we need to initialize our variable whenever the component is turned on, therefore we need the AppComponent class to implement OnInit
		- we need to override the ngOnInit function in order for it to work and call our function, and its going to set our variable whenever the component is 
		  initialized and we get a response from the server

	10) (Next we start playing around in our HTML)
		- first we create a div, we want it to display all the employees, therefore we use a *ngFor as its attribute, because we want to loop through all of them,
		  and set it into the variable employee
		- inside the div we can create an another div, which is going to contain the employee variables in this format: {{employee.name}}
		- back in the employee service we need to specify the URL, which is going to be localhost
		- next we need to check a programming file environments.ts, where we will define our variable that will contain the URL we are connecting to (which is localhost in our case)
		- then, we can go back into our service (angular service) file and define our apiServerUrl as enviroment.whateverWeNamedTheVariableThatContainsTheUrl
		- in service, we are letting the app know that the service is the service with the @Injectable({providedIn: root}), so we are letting the app know
		- however, we still have to go into app.module.ts and specify our EmployeeService as a provider 
		
		- you either use the @Injectable method or the app.module.ts method
		- when we try to run the program, it will compile successfully but it won't show anything since we didn't include our HTML file, we need to put
		  HttpClientModule inside app.module.ts
		- we are not able to reach the backend because of the Access-Control-Allow-Origin policy, which is common in all modern web browsers,
		  it means that the application couldn't access data in an another domain, we need to change
		- we specifically need to say in the back end to allow the localhost:4200 (where Angular is running) 
		- we need to put a CorsFilter configuration into our EmployeeManagerApplication.java, basically where the main is
		- beware of what you import when applying CorsFilter etc.., because if you accidentally import apache and not springframework, it's not going to work
		
	11) For HTML code (app.component.html), we use the example for employee cards, same for CSS, JS
		- in our HTML code, we have the cards for the employees, in our div we are going to put the *ngFor attribute yet again, its going to connect to our employee
		  variable specified in out app.component.ts file, create a local variable so it creates a card for every employee possible 
		- in HTML we create a modal, and a function onOpenModal that we reference and have to create back in app.components.ts
		- we have modals for every function we want to serve, including add, edit and delete
		- index.html is the file that will ultimately get served, we need to put scripts for jquery, ajax and bootstrap

	12) Angular Form
		- we want our code to do something, so we have to connect the form created in angular to our back end

		





  
		

