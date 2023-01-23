# CapitalOneChallenge
For this challange I created a springboot based backend server which takes in a list of transcations via a get request and returns the total number of points (per month) and the rules that were used. While you can run this project locally (it should go to localhost:5000), I also deployed it on AWS beanstalk at: 
```
Capitalone-env.eba-wfmi6t3h.sa-east-1.elasticbeanstalk.com
```
I also created a postman collection that you can use to query (both locally and remotely). A sample request might look like:
```
url: Capitalone-env.eba-wfmi6t3h.sa-east-1.elasticbeanstalk.com/v1/getReward
body:
{
    "transactionList": [
        {
            "date": "2021-05-09",
            "merchant_code": "sportcheck",
            "amount_cents": 2000
        },
        {
            "date": "2021-05-10",
            "merchant_code": "tim_hortons",
            "amount_cents": 1321
        }
    ]
}
```
