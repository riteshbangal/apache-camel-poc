# apache-camel-poc

##### What is ActiveMQ used for?
It is used to reliably communicate between two distributed processes. Yes, you could store messages in a database to communicate between two processes, but, as soon as the message is received you'd have to delete the message. That means a row insert and delete for each message. When you try to scale that up communicating thousands of messages per second, databases tend to fall over.

Message oriented middle-ware like ActiveMQ on the other hand are build to handle those use cases. They assume that messages in a healthy system will be deleted very quickly and can do optimizations to avoid the overhead. It can also push messages to consumers instead of a consumer having to poll for new message by doing a SQL query. This further reduces the latency involved in processing new messages being sent into the system.


1.  **Decoupled** : The systems are able to communicate without being connected. Queue lies between systems, one system failure will never affect other as communication is done through Queue. The systems continue to work when they are up.

2.  **Recovery support** : The messages in Queues itself persisted. The messages can be restored later if Queue fails.

3.  **Reliable Communication** : Consider a system that process client requests. In normal cases the system receives 100 requests per minute. This system is unreliable when number of request goes beyond average. In such case Queue can manage requests and it can push messages periodically based on system throughput without breaking it.

3.  **Asynchronous** : Client server communication is non-blocking. Once client sent request to server it can do other operations without waiting for response. When response it received client can handle it anytime.


**References**:
*   <https://en.wikipedia.org/wiki/Apache_ActiveMQ>
*   <https://dzone.com/articles/what-activemq>
  

------------------------------------------------------------



