# javaassessment
Mini Assignment

REST API's Doc

1.) Create list of Users:

  POST Request:
    Endpoint: http://localhost:8080/users/create
    
    Request Body:(Sample)
    
    {
    "userRequestPayload":[{
        "email":"pavan@gmail.com",
        "pinCode":180004,
        "mobile":"919149616",
        "firstName":"Pavan",
        "lastName":"Ravat"
    },{
        "email":"pavan.com",
        "pinCode":180004,
        "mobile":"919149616132",
        "firstName":"Ujjwal",
        "lastName":"Sharma"
    },{
       "email":"ujjwal@gmail.com",
        "pinCode":18000,
        "mobile":"9191496",
        "firstName":"Ujjwal",
        "lastName":"Sharma" 
    },{
        "email":"dravid@gmail.com",
        "pinCode":180004,
        "mobile":"919149616132",
        "firstName":"Dravid",
        "lastName":"Ujjwal"
    },{
        "email":"aman.com",
        "pinCode":180004,
        "mobile":"919149616132",
        "firstName":"Ujjwal",
        "lastName":"Sharma"
    },{
       "email":"ujjwal@gmail.com",
        "pinCode":180005,
        "mobile":"91914961731",
        "firstName":"Ujjwal",
        "lastName":"Sharma" 
    }]
  }

  Response:
  
    {
    "success": true,
    "data": {
        "createdUsers": [
            {
                "user_id": 1,
                "firstName": "Dravid",
                "lastName": "Ujjwal",
                "email": "dravid@gmail.com",
                "mobile": "919149616132",
                "address": null,
                "city": null,
                "state": null,
                "pinCode": 180004,
                "createdOn": "2021-12-23",
                "lastModifiedOn": null,
                "version": 1
            },
            {
                "user_id": 2,
                "firstName": "Ujjwal",
                "lastName": "Sharma",
                "email": "ujjwal@gmail.com",
                "mobile": "91914961731",
                "address": null,
                "city": null,
                "state": null,
                "pinCode": 180005,
                "createdOn": "2021-12-23",
                "lastModifiedOn": null,
                "version": 1
            }
        ],
        "emailErrors": {
            "2": {
                "pavan.com": {
                    "firstName": "Ujjwal",
                    "lastName": "Sharma",
                    "email": "pavan.com",
                    "mobile": "919149616132",
                    "address": null,
                    "city": null,
                    "state": null,
                    "pinCode": 180004
                },
                "aman.com": {
                    "firstName": "Ujjwal",
                    "lastName": "Sharma",
                    "email": "aman.com",
                    "mobile": "919149616132",
                    "address": null,
                    "city": null,
                    "state": null,
                    "pinCode": 180004
                }
            }
        },
        "firstNameErrors": {
            "0": {}
        },
        "mobileErrors": {
            "1": {
                "919149616": {
                    "firstName": "Pavan",
                    "lastName": "Ravat",
                    "email": "pavan@gmail.com",
                    "mobile": "919149616",
                    "address": null,
                    "city": null,
                    "state": null,
                    "pinCode": 180004
                }
            }
        },
        "pinCodeErrors": {
            "1": {
                "18000": {
                    "firstName": "Ujjwal",
                    "lastName": "Sharma",
                    "email": "ujjwal@gmail.com",
                    "mobile": "9191496",
                    "address": null,
                    "city": null,
                    "state": null,
                    "pinCode": 18000
                }
            }
        }
    },
    "message": "2 user(s) created with 2 email error(s) occured, 1 mobile error(s) occured, 0 first name error(s) occured, 1 pin code error(s) occured.",
    "statusCode": 200
  }


2.) Search A User

  Get Request:
   Endpoint: http://localhost:8080/users/find/?first_name=Ujjwal&result=1

  Response:
    {
    "success": true,
    "data": [
        {
            "user_id": 2,
            "firstName": "Ujjwal",
            "lastName": "Sharma",
            "email": "ujjwal@gmail.com",
            "mobile": "91914961731",
            "address": null,
            "city": null,
            "state": null,
            "pinCode": 180005,
            "createdOn": "2021-12-23",
            "lastModifiedOn": null,
            "version": 1
        }
    ],
    "message": "1 user(s) found.",
    "statusCode": 200
  }
