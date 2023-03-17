import requests
import json

def fill_book_table():
    # Vul de Book-tabel met voorbeeldgegevens
    url_book = 'http://localhost:8080/book/create'
    headers = {"Content-Type": "application/json"}
    book_data = [
        {"ISBN": "9789044633660", "title": "De acht bergen", "author": "Paolo Cognetti"},
        {"ISBN": "9789044620073", "title": "Grand Hotel Europa", "author": "Ilja Leonard Pfeijffer"},
        {"ISBN": "9789403132318", "title": "De meeste mensen deugen", "author": "Rutger Bregman"},
        {"ISBN": "9789026349551", "title": "De avond is ongemak", "author": "Marieke Lucas Rijneveld"},
        {"ISBN": "9789403187905", "title": "De cursus 'Omgaan met teleurstellingen' gaat wederom niet door", "author": "Herman Finkers"},
        {"ISBN": "9789044646646", "title": "De antwoorden op de grote vragen", "author": "Stephen Hawking"},
        {"ISBN": "9789026339798", "title": "Wees onzichtbaar", "author": "Murat Isik"},
        {"ISBN": "9789025906411", "title": "Het smelt", "author": "Lize Spit"},
        {"ISBN": "9789023495703", "title": "Alleen maar nette mensen", "author": "Robert Vuijsje"},
        {"ISBN": "9789045025214", "title": "Sapiens", "author": "Yuval Noah Harari"}
    ]
    for book in book_data:
        response = requests.post(url_book, json=book, headers=headers)
        print(response)

def fill_user_table():
    # Vul de User-tabel met voorbeeldgegevens
    url_user = 'http://localhost:8080/user/create'
    headers = {"Content-Type": "application/json"}
    user_data = [
        {'firstName': 'John','lastName' : 'Doe', 'emailAddress': 'john.doe@example.com', 'admin': True, 'password':'aaa'},
        {'firstName': 'Jane','lastName' : 'Doe', 'emailAddress': 'jane.doe@example.com', 'admin': False, 'password':'bbb'},
        {'firstName': 'Bob','lastName' : 'Smith', 'emailAddress': 'bob.smith@example.com', 'admin': False, 'password':'ccc'}
    ]
    for user in user_data:
        response = requests.post(url_user, json=user, headers=headers)
        print(response)

def fill_reservation_table():
    # Vul de Reservation-tabel met voorbeeldgegevens
    url_reservation = 'http://localhost:8080/reservation/create'
    headers = {"Content-Type": "application/json"}
    reservation_data = [
        {"bookId": 1, "userId": 1, "date": "2023-03-01"},
        {"bookId": 2, "userId": 2, "date": "2023-03-02"},
        {"bookId": 3, "userId": 3, "date": "2023-03-03"}
    ]

    for data in reservation_data:
        response = requests.post(url_reservation, json=data, headers=headers)
        print(response)

def fill_copy_table():
    # Voeg gegevens toe aan Copy-tabel
    url_copy = 'http://localhost:8080/copy/create'
    headers = {"Content-Type": "application/json"}
    copy_data = [
        {'bookId': 1},
        {'bookId': 1},
        {'bookId': 2},
        {'bookId': 3},
        {'bookId': 3}
    ]

    for data in copy_data:
        response = requests.post(url_copy, json=data, headers=headers)
        print(response)



def fill_loan_table():
    # Voeg gegevens toe aan Loan-tabel
    url_loan = "http://localhost:8080/loan/create"
    headers = {"Content-Type": "application/json"}
    loan_data = [
        {"copyId": 1, "userId": 1, "startDate": "2023-03-01", "endDate": "2023-03-08"},
        {"copyId": 2, "userId": 1, "startDate": "2023-03-02", "endDate": "2023-03-09"},
        {"copyId": 3, "userId": 2, "startDate": "2023-03-03", "endDate": "2023-03-10"},
        {"copyId": 4, "userId": 2, "startDate": "2023-03-04", "endDate": "2023-03-11"}
    ]
    for data in loan_data:
        response = requests.post(url_loan, json=data, headers=headers)
        print(response)

def fill_db():
    fill_book_table()
    fill_user_table()
    fill_copy_table()
    fill_loan_table()
    fill_reservation_table()

fill_db()