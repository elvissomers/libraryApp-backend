from pprint import pprint
import requests
import random
from datetime import datetime, timedelta

url_book = 'http://localhost:8080/book/get'
response_book = requests.get(url_book).json()

url_user = 'http://localhost:8080/user/get'
response_user = requests.get(url_user).json()

date_str = "2020-10-10"
date_obj = datetime.strptime(date_str, "%Y-%m-%d")
now = datetime.now()
day_difference = (now - date_obj).days


for _ in range(50):
    new_dict = {}
    new_dict["bookId"] = random.choice(response_book)["id"]
    new_dict["userId"] = random.choice(response_user)["id"]
    new_dict["date"] = (date_obj + timedelta(days=random.randint(0,day_difference))).strftime("%Y-%m-%d")
    url_reservation = 'http://localhost:8080/reservation/create'
    response = requests.post(url_reservation, json=new_dict)