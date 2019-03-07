# CCI Campaign Booking API


## What is it for?

This is a very basic rest end point that will be used for a QA technical test

It is full of bugs and errors, but that's the point!

GET, POST, PUT and DELETE methods have been implemented.

The idea is that a user will be able to create a new Campaign with the following model

```java
public class Campaign {
    private String id;
    private String campaignName;
    private String client;
    private String startDate;
    private String endDate;
    private String status;
}
```

The user can add new campaigns, delete a campaign, update a campaign and list all campaigns

## Where is it hosted?

Currently this is on a Heroku instance owned by Dan Jones. 

## Swagger

[Swagger](https://cci-tech-test.herokuapp.com/swagger-ui.html)

## Some of the problems that should be found

- lack of security
- in correct http codes returned
- no validation or error checking on the request bodies (ie, can send null values)
- no validation on ID's used for PUTs or DELETEs (ie it will take an id that does not exist and return a 'successful' deletion)
- No validation on statuses, this should be an enum


## Todo

- change the readme for the actual test. 
- get it to include the rest tests and the swagger url
- add a note to the tests README about the environment goign down after 30 mins of inactivity and deleting all data
- fix swagger so that it only shows the incorrect return code and not all the others (this is for POST)
- Find out if there is a CCI heroku or make one that Gemma can own. Or should it be on AWS?



