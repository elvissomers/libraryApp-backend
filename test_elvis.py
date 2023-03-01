import requests

url='http://localhost:8080/loan/create'
myobj={
	"copyId":"141",
	"reservationId":"1011",
	"userId":"12",
	"startDate": "15/01/2023"

}

requests.post(url, json=myobj)