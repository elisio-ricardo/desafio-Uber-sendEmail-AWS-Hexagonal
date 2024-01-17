#Email Service

Create a service that accepts the necessary information and sends emails. It should provide an abstraction between two different email service providers. If one of the services goes down, your service can quickly failover to a different provider without affecting your customers.

Example Email Providers:


SendGrid - Simple Send Documentation
Mailgun - Simple Send Documentation
SparkPost - Developer Hub
Amazon SES - Simple Send Documentation

All listed services are free to try and are pretty painless to sign up for, so please register your own test accounts on each.

Update application.properties puting your AWS Credentials

aws.region=us-east-1

aws.accessKeyId=1111111

aws.secretKey=111111


Usage

Start the application with Maven
The API will be accessible at http://localhost:8080
API Endpoints
The API provides the following endpoints:

GET EMAIL


POST /api/email/send - Send a e-mail from your sender to the destination


BODY


{

  "to": "liveskipperdev@gmail.com",
  
  "subject": "teste",
  
  "body": "teste"
  
}
