# SpingBoot-Monolithic
Spring-Boot project to demonstrate Spring-Monolith with H2 Database

## Application Arch : 

![ARCH](https://github.com/kaleshrikant/SpingBoot-Modulith/blob/master/smart-parking-system/src/main/resources/static/Overview.png)   

Spring Application Module
The @ApplicationModule annotation in Spring Modulith is used to customize information about a Modulith module. It allows developers to define the boundaries and dependencies of application modules within a Spring Boot application.

This annotation can be applied to the package-info.java file or a single type located in the application module’s root package. It provides several optional elements to configure the module:

allowedDependencies: Lists the names of modules that the module is allowed to depend on. For example, @ApplicationModule(allowedDependencies = "order") restricts the module to only depend on the "order" module.
displayName: Specifies a human-readable name for the module, which is useful for documentation purposes.
id: Defines the identifier of the module, which must not contain a double colon (::).
type: Declares the type of the application module, which can be either CLOSED or OPEN. An open module allows access to internal types from other modules and includes all types in sub-packages of the application module base package in the unnamed named interface unless explicitly assigned to a named interface.
By using the @ApplicationModule annotation, developers can enforce strict module boundaries, ensuring that modules interact in a loosely coupled manner. This helps in maintaining a well-structured application and facilitates easier maintenance and testing.

For example, to declare an application module as open, you can use the following annotation:

@ApplicationModule(type = Type.OPEN)
package example.inventory;

This configuration allows the module to expose internal types and manage dependencies more flexibly.
