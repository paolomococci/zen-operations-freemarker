# zen-operations-freemarker
Operations Research project with Spring Boot, Apache Freemarker, Bootstrap and more.

# part of the my project Zen Operations
## back end component:
### zen-operations-restful
Here the persistence of the data and their treatment is managed.
That is, for explanatory purposes only, inventory management, bill of materials, quality control, etc.
## front end components:
### zen-operations-client
Web app client.
### zen-operations
Android app client.
### zen-operations-freemarker
Alternative web app client.

## very important:
In this case, if you want the code to work you must explicitly exclude a dependency integrated in spring-boot-starter-web as explained below:
```
<dependency>
	<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
		<exclusions>
			<exclusion>
				<groupId>org.hibernate.validator</groupId>
				<artifactId>hibernate-validator</artifactId>
			</exclusion>
		</exclusions>
</dependency>
```
