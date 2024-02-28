
<h1> Steps to build the project</h1>
<h2><p>Step1: Run this command to build the project.</p>
<li>mvn clean install.</li>
<p> Step2: Once the above command is successful. Run the next command to deploy the service to the tomcat. We are using jetty-maven-plugin to deploy the service.
<li>mvn jetty:run</li>
</h2>

<H2>API's details</h2>

<h4>POST call to book the train ticket
http://localhost:8080/service/train/purchaseTicket
</h4>
Request Body example for the post call
<pre>
<code>
{
    "fromStation":"France",
    "toStation":"London",
    "user":
        {
            "firstName":"ABC",
            "lastName":"WEP",
            "age":"32",
            "emailId" :"abc@gmail.com"
        }
}
</code>
</pre>

<h4>Get call to get the ticket details
http://localhost:8080/service/train/ticket/
</h4>

<h4>Get call to see the details of the requested compartment
http://localhost:8080/service/train/compartment/A
</h4>

<h4>Delete call to delete the user and his reserved ticket from the system
http://localhost:8080/service/train/deleteUser/283293395
</h4>