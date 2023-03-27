import requests
import re
from collections import Counter
import json
from pprint import pprint


def add_to_text_data(language):
    list_of_wiki_subjects = get_subjects()
    with open('counter_'+language+'.json', 'r') as f_counter:
        loaded_counter = Counter(json.load(f_counter))

    for subject in list_of_wiki_subjects:
        if language == "nl":
            wiki_text = str(requests.get("https://nl.wikipedia.org/w/api.php?action=query&prop=revisions&titles="+subject+"&rvslots=*&rvprop=content&formatversion=2").content)
        elif language == "en":
            wiki_text = str(requests.get("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&titles="+subject+"&rvslots=*&rvprop=content&formatversion=2").content)
        list_words = wiki_text.split(" ")
        list_to_add = []
        for w in list_words:
            w = w.replace("-","").lower()
            if w.isalpha():
                list_to_add.append(w)
        loaded_counter.update(list_to_add)
        print(subject, len(list_to_add))

    with open('counter_'+language+'.json', 'w') as f:
        json.dump(dict(loaded_counter), f)


def get_keywords_description(n_keywords,description, language):
    with open('counter_'+language+'.json', 'r') as f_counter:
        loaded_counter = Counter(json.load(f_counter))

    list_words = description.split(" ")
    description_words = []
    for w in list(set(list_words)):
        w = w.lower().replace("-","")
        if w.isalpha():
            description_words.append(w)
    return sorted(description_words, key=lambda x: loaded_counter[x])[:n_keywords]

def get_subjects():
    json_response = requests.get("https://nl.wikipedia.org/w/api.php?action=query&generator=random&grnnamespace=0&grnlimit=50&prop=info&inprop=url&format=json").json()
    list_of_subjects = [q["title"] for q in json_response["query"]["pages"].values()]
    print([{q["title"]: q["length"]} for q in json_response["query"]["pages"].values()])
    return list_of_subjects

def set_keywords():
    all_books = requests.get("http://localhost:8080/book/get").json()
    for book in all_books:
        keywords = get_keywords_description(5, book["description"], book["language"])
        for keyword in keywords:
            url_book = 'http://localhost:8080/keyword/create'
            response = requests.post(url_book, json={"bookId": book["id"], "name": keyword})
            print(response)
        print(book["title"], keywords)

set_keywords()