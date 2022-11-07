# User-Accreditation

BE Engineer take-home challenge for Yieldstreet

# Swagger generated server

Spring Boot Server

## Overview
a)

This component has three endpoints: creation of accreditation, update and retrieval, validation of the request bodies and request parameters.

Besides these functionalities, component has a scheduled job that keep checking if there are any existing accreditation which have expired (past 30 days).
If there are some, it updates their state. This job runs every 15 seconds (depending on the table size, we might need to increase this time to allow for the query to finish and update to finalize, before another starts).
NOTE: we can consider some sort of caching here, to reduce the amount or queries executed.
NOTE: accreditationId was intended to be a String (ex. “87bb6030-458e-11ed-b023-039b275a916a). 
As it was not clear from the task where this is coming from, and how is it generated (can't really be randomized, since it needs to be unique), I implemented it as autoIncrementing integer.

To run this script I have prepared a startup.sh, which starts builds and starts a component exposing endpoints on 9999 port.
I also included swagger.yml from which I generated models and endpoints.

We have here implementation of observer pattern.

ExpireDates class is Observer, listening and waiting for any UserAccreditation objects (only those with _PENDING_ status) from the DB to change their state (date).
When the state changes ExpireDates updates the object's status to _EXPIRED_.

b)

Audit log of the historical accreditation status updates can be achieved by:

- creating a history table in the DB, that has columns history_id, accreditation_id and status.
history_id would be auto incrementing primary key (this would give as order of changes per accreditation). 
  accreditation_id would be a foreign key from user_accreditation table.
  Status would be current accreditation status.
  
- Each time accreditation is created we insert into history table

- Each time accreditation is updated we insert into history table


c)

We can separate the component into admin and clint part. Admin would contain creation, update endpoints and the scheduled background process.
Client would only contain get endpoint. This would allow us to put the client component on multiple servers to balance the traffic between machines.



