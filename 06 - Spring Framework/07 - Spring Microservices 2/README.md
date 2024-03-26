# Introduction to Microservices:
## Monolithic Architecture
### Advantages:
1. Easy Deployment - One executable file or directory makes deployment easier.
2. Development - When an application is built with one code base, it is easier to develop.
3. Performance - In a centralized code base and repository, one API can often perform the same function that numerous APIs perform with microservices.
4. Simplified Testing - Since a monolithic application is a single, centralized unit, end-to-end testing can be performed faster than with a distributed application.
5. Easy debugging - With all code located in one place, it's easier to follow a request and find an issue.
### Disadvantages:
1. Slower Development Speed - A large, monolithic application makes development more complex and slower.
2. Scalability - You can't scale individual components.
3. Reliability - If there's an error in any module, it could affect the entire application's availibility.
4. Barrier to Technology Adoption - Any changes in the framework or language affects the entire application, making changes often expensive and time-consuming.
5. Lack of Flexibility - A monolith is constrained by the technologies already used in the monolith.
6. Deployment - A small change to a monolithic application requires the redeployment of the entire monolith.
## Microservices Architecture
### Advantages:
1. Agility - Promote agile ways of working with small teams that deploy frequently.
2. Flexible Scaling -  If a microservice reaches its load capacity, new instances of that service can rapidly be deployed to the accompanying cluster to help relieve pressure.
3. Highly Maintainable and Testable - Teams can experiment with new features and roll back if something doesn’t work. This makes it easier to update code and accelerates time-to-market for new features. Plus, it is easy to isolate and fix faults and bugs in individual services.
4. Independent Deployable - Since microservices are individual units they allow for fast and easy independent deployment of individual features. 
5. Technology Flexibility - Microservice architectures allow teams the freedom to select the tools they desire. 
6. High Reliability - You can deploy changes for a specific service, without the threat of bringing down the entire application.
### Disadvantages:
1. Development Sprawl - Microservices add more complexity compared to a monolith architecture, since there are more services in more places created by multiple teams. If development sprawl isn’t properly managed, it results in slower development speed and poor operational performance.
2. Exponential Infrastructure Costs - Each new microservice can have its own cost for test suite, deployment playbooks, hosting infrastructure, monitoring tools, and more.
3. Added Organizational Overhead - Teams need to add another level of communication and collaboration to coordinate updates and interfaces.
4. Debugging Challenges - Each microservice has its own set of logs, which makes debugging more complicated. Plus, a single business process can run across multiple machines, further complicating debugging.
5. Lack of Standardization - Without a common platform, there can be a proliferation of languages, logging standards, and monitoring.
6. Lack of Clear Ownership - As more services are introduced, so are the number of teams running those services. Over time it becomes difficult to know the available services a team can leverage and who to contact for support.