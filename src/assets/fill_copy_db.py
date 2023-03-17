from pprint import pprint
import requests
import random
from datetime import datetime, timedelta

url_book = 'http://localhost:8080/book/get'
response_book = requests.get(url_book).json()
available = [False, True, True]

for book in response_book:
    for i in range(random.randint(0,5)):
        new_dict = {}

        new_dict["bookId"] = book["id"]
        new_dict["number"] = i
        new_dict["available"] = random.choice(available)
        print(new_dict)

        url_copy = 'http://localhost:8080/copy/create'
        response = requests.post(url_copy, json=new_dict)