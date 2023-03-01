import requests

url='http://localhost:8080/reservation/create'
myobj={
	"bookId":"142",
	"userId":"12",
	"date": "17/01/2023"

}

requests.post(url, json=myobj)