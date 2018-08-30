# Microservices Development Cookbook

<a href="https://www.packtpub.com/application-development/microservice-development-cookbook?utm_source=github&utm_medium=repository&utm_campaign=9781788479509 "><img src="https://d255esdrn735hr.cloudfront.net/sites/default/files/imagecache/ppv4_main_book_cover/B08816_MockupCoverNeww.png" alt="Microservices Development Cookbook" height="256px" align="right"></a>

This is the code repository for [Microservices Development Cookbook](https://www.packtpub.com/application-development/microservice-development-cookbook?utm_source=github&utm_medium=repository&utm_campaign=9781788479509 ), published by Packt.

**Design and build independently deployable, modular services**

## What is this book about?
Microservices have become a popular way to build distributed systems that power modern web and mobile apps. Deploying your application as a suite of independently deployable, modular, and scalable services has many benefits. In this book, you'll learn to employ microservices in order to make your application more fault-tolerant and easier to scale and change.

This book covers the following exciting features:
Learn how to design microservice-based systems 
Create services that fail without impacting users 
Monitor your services to perform debugging and create observable systems 
Manage the security of your services 
Create fast and reliable deployment pipelines 
Manage multiple environments for your services 
Simplify the local development of microservice-based systems 

If you feel this book is for you, get your [copy](https://www.amazon.com/dp/1788479505) today!

<a href="https://www.packtpub.com/?utm_source=github&utm_medium=banner&utm_campaign=GitHubBanner"><img src="https://raw.githubusercontent.com/PacktPublishing/GitHub/master/GitHub.png" 
alt="https://www.packtpub.com/" border="5" /></a>

## Instructions and Navigations
All of the code is organized into folders. For example, Chapter02.

The code will look like the following:
```
class AttachmentsService
def upload(message_id, user_id, file_name, data, media_type)
message = Message.find_by!(message_id, user_id: user_id)
file = StorageBucket.files.create(
key: file_name,
body: StringIO.new(Base64.decode64(data), 'rb'),
public: true
)
```

**Following is what you need for this book:**
Microservice Development Cookbook is for developers who would like to build effective and scalable microservices. Basic knowledge of the microservices architecture is assumed.

With the following software and hardware list you can run all code files present in the book (Chapter 1-9).
### Software and Hardware List
| Chapter | Software required | OS required |
| -------- | ------------------------------------ | ----------------------------------- |
| 1-9 | Gradle | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |
|  |  | Windows, Mac OS X, and Linux (Any) |

We also provide a PDF file that has color images of the screenshots/diagrams used in this book. [Click here to download it]().

### Related products
* TypeScript Microservices [[Packt]](https://www.packtpub.com/application-development/typescript-microservices?utm_source=github&utm_medium=repository&utm_campaign=9781788830751 ) [[Amazon]](https://www.amazon.com/dp/178883075X)

* Microservice Patterns and Best Practices [[Packt]](https://www.packtpub.com/application-development/microservice-patterns-and-best-practices?utm_source=github&utm_medium=repository&utm_campaign=9781788474030 ) [[Amazon]](https://www.amazon.com/dp/1788474031)

*  [[Packt]]() [[Amazon]](https://www.amazon.com/dp/)

*  [[Packt]]() [[Amazon]](https://www.amazon.com/dp/)

## Get to Know the Author
**Paul Osman**
Paul Osman has been building external and internal platforms for over 10 years. From public APIs targeted at third parties to internal platform teams, he has helped build distributed systems that power large-scale consumer applications. He has managed teams of engineers to rapidly deliver service-based software systems with confidence.
Paul has published articles and given multiple conference talks on microservices and DevOps. He is a passionate advocate of open technology platforms and tools.

****
0

****
0

****
0

****
0

## Other books by the authors
[]()

[]()

[]()

[]()

[]()

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSdy7dATC6QmEL81FIUuymZ0Wy9vH1jHkvpY57OiMeKGqib_Ow/viewform) if you have any feedback or suggestions.


