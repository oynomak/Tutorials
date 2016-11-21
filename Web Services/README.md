1. Build an App#1 that holds the names (dummy DB with String ArrayList) and displays it on a Web page
  + LINKS: 
    - https://www.mkyong.com/spring-mvc/spring-mvc-and-list-example/

  + Use Spring MVC
  + Java J2EE

1. Build an App#2 that can input data into the App#1 using Web-Service:
  #### LINKS: 
    - http://www.programming-free.com/2014/01/spring-mvc-40-restful-web-services.html
    - https://www.tutorialspoint.com/restful/restful_quick_guide.htm

      + Use HTTP Verb - Always use HTTP Verb like GET, PUT, and DELETE to do the operations on the resource. It is not good to use operations names in URI. 

        For example, following is a poor URI to fetch a user:

          + [ http://localhost:8080/UserManagement/rest/UserService/getUser/1 ]

        Following is an example of good URI to fetch a user:

          + [ http://localhost:8080/UserManagement/rest/UserService/users/1 ]

        Let Server decide the operation based on HTTP verb.

          + https://www.tutorialspoint.com/restful/restful_methods.htm
          + https://www.javacodegeeks.com/2010/06/spring-3-restful-web-services.html
                    
        ### Real Example!
   
          Create an “endpoints” subpackage under the “server” package of your project. As far as GWT is concerned service endpoints are server side components so all classes must be placed under the “server” package. Under “endpoints” subpackage place the “EmployeeServiceController”.

          - http://stackoverflow.com/questions/19556039/spring-mvc-controller-rest-service-needs-access-to-header-information-how-to-do
        
        ### Manipulating Headers in HTTP

            `@RequestMapping("/displayHeaderInfo.do")
            public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Keep-Alive") long keepAlive){
              /* Your code here... */
            }`

  + Use Spring RESTful WS
  + Java J2EE

