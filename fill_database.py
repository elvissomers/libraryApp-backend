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
        {'name': 'John Doe', 'eMailAddress': 'john.doe@example.com', 'admin': True},
        {'name': 'Jane Doe', 'eMailAddress': 'jane.doe@example.com', 'admin': False},
        {'name': 'Bob Smith', 'eMailAddress': 'bob.smith@example.com', 'admin': False}
    ]
    for user in user_data:
        response = requests.post(url_user, json=user, headers=headers)
        print(response)

def fill_reservation_table():
    # Vul de Reservation-tabel met voorbeeldgegevens
    url_reservation = 'http://localhost:8080/reservation/create'
    headers = {"Content-Type": "application/json"}
    reservation_data = [
        {"bookId": 1, "userid": 1, "date": "2023-03-01"},
        {"bookId": 2, "userid": 2, "date": "2023-03-02"},
        {"bookId": 3, "userid": 3, "date": "2023-03-03"}
    ]

    for data in reservation_data:
        response = requests.post(url_reservation, json=data, headers=headers)
        print(response)

def fill_copy_table():
    # Voeg gegevens toe aan Copy-tabel
    url_copy = 'http://localhost:8080/copy/create'
    headers = {"Content-Type": "application/json"}
    copy_data = [
        {'available': True, 'heldByUserId': None, 'bookId': 1},
        {'available': False, 'heldByUserId': 2, 'bookId': 1},
        {'available': True, 'heldByUserId': None, 'bookId': 2},
        {'available': True, 'heldByUserId': None, 'bookId': 3},
        {'available': False, 'heldByUserId': 3, 'bookId': 3}
    ]

    for data in copy_data:
        response = requests.post(url_copy, json=data, headers=headers)
        print(response)

def fill_keyword_table():
    # Voeg gegevens toe aan Keyword-tabel
    url_keyword = "http://localhost:8080/keyword/create"
    headers = {"Content-Type": "application/json"}
    keyword_data = [
        {"keyword": "detective", "keywordGroup": "genre"},
        {"keyword": "romance", "keywordGroup": "genre"},
        {"keyword": "mystery", "keywordGroup": "genre"},
        {"keyword": "Stephen King", "keywordGroup": "author"},
        {"keyword": "Agatha Christie", "keywordGroup": "author"},
        {"keyword": "J.K. Rowling", "keywordGroup": "author"}
    ]

    for data in keyword_data:
        response = requests.post(url_keyword, json=data, headers=headers)
        print(response)

def fill_bookKeyword_table():
    # Voeg gegevens toe aan BookKeyword-tabel
    url_book_keyword = "http://localhost:8080/keyword/create"
    headers = {"Content-Type": "application/json"}
    book_keyword_data = [
        {"bookId": 1, "keywordId": 1},
        {"bookId": 1, "keywordId": 2},
        {"bookId": 2, "keywordId": 1},
        {"bookId": 2, "keywordId": 3},
        {"bookId": 3, "keywordId": 4},
        {"bookId": 3, "keywordId": 5},
        {"bookId": 3, "keywordId": 6}
    ]
    for data in book_keyword_data:
        response = requests.post(url_book_keyword, json=data, headers=headers)
        print(response)

def fill_loan_table():
    # Voeg gegevens toe aan Loan-tabel
    url_loan = "http://localhost:8080/loan/create"
    headers = {"Content-Type": "application/json"}
    loan_data = [
        {"copyId": 1, "reservationId": 1, "startDate": "2023-03-01", "endDate": "2023-03-08"},
        {"copyId": 2, "reservationId": 1, "startDate": "2023-03-02", "endDate": "2023-03-09"},
        {"copyId": 3, "reservationId": 2, "startDate": "2023-03-03", "endDate": "2023-03-10"},
        {"copyId": 4, "reservationId": 2, "startDate": "2023-03-04", "endDate": "2023-03-11"}
    ]
    for data in loan_data:
        response = requests.post(url_loan, json=data, headers=headers)
        print(response)

def fill_db():
    fill_book_table()
    fill_user_table()
    fill_copy_table()
    fill_keyword_table()
    fill_bookKeyword_table()
    fill_loan_table()
    fill_reservation_table()

fill_db()
