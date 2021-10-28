# Code Sharing Platform

## Description
Code Sharing Platform is a RESTful web service allowing users to share their code using API or a website. After adding some code, it is sent to a database that stores information like exact date and time of last edit or who is the author. Users, who are given the access to a specific code snippet can edit it, but only the author is permitted to delete it.

## Endpoints


* `/api/code/new` - **POST** - endpoint for adding new code, only available if user is logged in. 

 Example of a correct request body:

```
{
  "code": "public static void main(String[] args) {
               System.out.println("Hello World!");
           }"
}
```
After getting a request like this, the app uses a data to object class to create an instance of Code class (date and time of creation and author are handled in the constructor of Code class), and send it to a database.
#

* `/api/code/id` - **GET** - endpoint for viewing a specific code snippet with an id matching the id entered in the url

Example get request with url `/api/code/1` :


```
{
    "id": 1,
    "code": "System.out.println(\"Hello World!\");",
    "date": "2021/10/28 10:36:10"
}
```
#

* `/register` - **GET** - html endpoint where user can enter username and password to create an account. Then the app sends these informations to the `/api/user/new` as Json object
