# Code Sharing Platform

## Description
Code Sharing Platform is a RESTful web service allowing users to share their code using API or a website. After adding some code, it is sent to a database that stores information like exact date and time of last edit or who is the author. Users, who are given the access to a specific code snippet can edit it, but only the author is permitted to delete it.

## Endpoints


* `/api/code/new` - **POST** - endpoint for adding new code, only available if user is logged in. Example of a correct request body:

```
{
  "code": "public static void main(String[] args) {
               System.out.println("Hello World!");
           }"
}
```
After getting a request like this, the app uses a data to object class to create an instance of Code class (date and time of creation and author are handled in the constructor of Code class), and send it to a database.

* `/register` - **GET** - html endpoint where user can enter username and password to create an account. Then the app sends these informations to the `/api/user/new` as Json object
