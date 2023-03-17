import names
import random
import string
import requests

email_extensions = ["hotmail.com", "gmail.com", "kpn.nl", "outlook.com"]
admins = [0,0,0,0,0,0,0,0,0,0,0,1]


list_to_add = []
url_user = 'http://localhost:8080/user/create'

for _ in range(100):
    new_dict = {}
    first_name = names.get_first_name()
    last_name = names.get_last_name()
    new_dict["firstName"] = first_name
    new_dict["lastName"] = last_name
    new_dict["password"] = password = ''.join(random.choices(string.ascii_letters + string.digits + string.punctuation, k=random.randint(8,12)))
    new_dict["emailAddress"] = first_name + "_" + last_name + "@" + random.choice(email_extensions)
    new_dict["admin"] = random.choice(admins)


    list_to_add.append(new_dict)

    response = requests.post(url_user, json=new_dict)
    print(response.text)