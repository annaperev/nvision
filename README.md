# SpringBoot RestfulAPI using swagger,H2Database and JPA

Run main method in com/nvision/printstat/SpringSwaggerJpaRestH2Application.java

H2 Databse  http://localhost:8089/h2/ 

Restful endpoints with swagger http://localhost:8089/swagger-ui.html




POST 
```
http://localhost:8089/api/jobs
```

Request XML Example:
```
<?xml version="1.0" encoding="UTF-8"?>
<jobs>
   <job id="1">
      <type>print</type>
      <user>user1</user>
      <device>device1</device>
      <amount>10</amount>
   </job>
   <job id="2">
      <type>scan</type>
      <user>user1</user>
      <device>device1</device>
      <amount>12</amount>
   </job>
   <job id="3">
      <type>fax</type>
      <user>user2</user>
      <device>device1</device>
      <amount>5</amount>
   </job>
</jobs>
```

Response JSON example: 
```
{
    "user1": 22,
    "user2": 5
}
```

GET 
```
http://localhost:8089/api/statistics?device=device1&timeFrom=2000-10-31 02:12&timeTo=2020-12-01 02:12&user=user1
```

Response JSON example:
```
[
    {
        "jobId": 1,
        "amount": 10,
        "time": "2020-10-05 18:40",
        "type": "print",
        "device": "device1",
        "user": "user1"
    },
    {
        "jobId": 2,
        "amount": 12,
        "time": "2020-10-05 18:40",
        "type": "scan",
        "device": "device1",
        "user": "user1"
    }
]
```