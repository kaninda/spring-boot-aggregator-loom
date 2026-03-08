# spring-boot-aggregator-loom
This Spring Boot project demonstrates how Java 21 virtual threads can improve the performance and scalability of a microservice-style aggregation service, especially when external calls are executed in parallel.

**This project shows that Java 21 virtual threads do not significantly reduce latency on their own when calls are still sequential. The real benefit appears when blocking calls are executed in parallel, making the code both simple and scalable.**