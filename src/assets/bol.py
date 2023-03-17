from pprint import pprint
import requests
import json
import time

def get_json(bol_url):
    resp = requests.get(bol_url)
    resp = str(resp.content).split("<script type=\"application/ld+json\">")[1].split("</script>")[0]
    full_json = json.loads(resp.replace("\\", ""))
    new_dict = {}
    new_dict["title"] = full_json["workExample"]["name"]
    new_dict["author"] = full_json["author"]["name"]
    new_dict["isbn"] = full_json["workExample"]["isbn"]
    url_book = 'http://localhost:8080/book/create'
    response = requests.post(url_book, json=new_dict)
    print(response.text)

#    response_image = requests.get(full_json['image']['url'])
#    with open('C:/Users/koen_/Desktop/frontend/libraryApp-frontend/bookstore-client/src/assets/bookCovers/'+new_dict["isbn"]+'.jpg', 'wb') as f:
#        f.write(response_image.content)

Done = []

ToDo = ["https://www.bol.com/nl/nl/p/data-science-from-scratch-first-principles-with-python/9200000101404006/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.41.ProductTitle",
        "https://www.bol.com/nl/nl/p/voor-dummies-scrum-voor-dummies/9200000035275084/?bltgh=skbqmCd95qZnxoAnVYhBIQ.2_18.33.ProductTitle",
        "https://www.bol.com/nl/nl/p/scrum/9200000039736414/?bltgh=qphhLxOglcb32MwdpBlGyg.4_14.15.ProductTitle",
        "https://www.bol.com/nl/nl/p/het-scrum-modellenboek/9200000084796672/?bltgh=skbqmCd95qZnxoAnVYhBIQ.2_18.36.ProductTitle",
        "https://www.bol.com/nl/nl/p/agile-scrum-handboek/9300000045747866/?bltgh=skbqmCd95qZnxoAnVYhBIQ.oveLCYw47dWwjLNE7lVI8A_0_16.28.ProductTitle",
        "https://www.bol.com/nl/nl/p/de-kracht-van-scrum/9300000073877443/?bltgh=iRm3Xz0LukIQss6dlwtIMg.2_18.34.ProductTitle",
        "https://www.bol.com/nl/nl/p/crash-course-programmeren-in-python/9200000085089738/?bltgh=oj30fxE6yt9XowrKiR9MZw.tD8bA-e53xWnswzluLlFlA_0_16.19.ProductTitle",
        "https://www.bol.com/nl/nl/p/stap-voor-stap-leren-programmeren-met-python/9200000085089748/?bltgh=rQXqGUSnnEeVKBZpfHxIVQ.gJUqO5NIEMzUyMzum5BHcw_0_16.20.ProductTitle",
        "https://www.bol.com/nl/nl/p/fluent-python/9300000005270326/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.27.ProductTitle",
        "https://www.bol.com/nl/nl/p/learn-python-3-the-hard-way/9200000073809482/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.33.ProductTitle",
        "https://www.bol.com/nl/nl/p/python-for-everybody/9200000061649900/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.37.ProductTitle",
        "https://www.bol.com/nl/nl/p/voor-dummies-programmeren-met-python-voor-dummies/9200000087357873/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.40.ProductTitle",
        "https://www.bol.com/nl/nl/p/think-python/9200000048025630/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.45.ProductTitle",
        "https://www.bol.com/nl/nl/p/python-tools-for-scientists/9300000092341655/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.46.ProductTitle",
        "https://www.bol.com/nl/nl/p/python-for-data-analysis/9300000119989783/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.49.ProductTitle",
        "https://www.bol.com/nl/nl/p/deep-learning-with-python/9300000033888581/?bltgh=m2iI2YWMIedS6ZdIRmRG9w.2_18.52.ProductTitle",
        "https://www.bol.com/nl/nl/p/javascript-the-definitive-guide/9200000127348616/?bltgh=j862HBWdm8vVE-6dYFBM5A.kI-B69BP529ppmFm7YhM-Q_0_16.18.ProductTitle",
        "https://www.bol.com/nl/nl/p/ocp-oracle-certified-professional-java-se-17-developer-study-guide/9300000049499639/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.23.ProductTitle",
        "https://www.bol.com/nl/nl/p/effective-java/9200000076724633/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.25.ProductTitle",
        "https://www.bol.com/nl/nl/p/java-for-dummies-8th-edition/9300000049498370/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.31.ProductTitle",
        "https://www.bol.com/nl/nl/p/handboek-html-css-en-javascript/1001004006552594/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.33.ProductTitle",
        "https://www.bol.com/nl/nl/p/javascript-jquery/9200000008613528/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.34.ProductTitle",
        "https://www.bol.com/nl/nl/p/php-mysql-javascript-html5-all-in-one/1001004011758318/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.37.ProductTitle",
        "https://www.bol.com/nl/nl/p/programmeren-in-java-met-greenfoot/1001004011024095/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.40.ProductTitle",
        "https://www.bol.com/nl/nl/p/voor-dummies-programmeren-met-javascript-voor-dummies/9200000087357988/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.41.ProductTitle",
        "https://www.bol.com/nl/nl/p/learning-php-mysql-javascript/9300000036846094/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.42.ProductTitle",
        "https://www.bol.com/nl/nl/p/java-the-complete-reference-twelfth-edition/9300000035585832/?bltgh=gXT4UDRxW2wMVbjCY-dIbA.2_18.50.ProductTitle",
        "https://www.bol.com/nl/nl/p/hands-on-machine-learning-with-scikit-learn-keras-and-tensorflow/9200000094568602/?bltgh=ofQ-kdyBqIlk5nVDpeFD4A.sJQgRMo5A4YFJLa90DFJdg_0_16.27.ProductTitle",
        "https://www.bol.com/nl/nl/p/deep-learning/9200000059459268/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.31.ProductTitle",
        "https://www.bol.com/nl/nl/p/machine-learning-for-engineers/9300000082014006/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.36.ProductTitle",
        "https://www.bol.com/nl/nl/p/personalized-machine-learning/9300000050306367/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.38.ProductTitle",
        "https://www.bol.com/nl/nl/p/probabilistic-machine-learning/9300000039443852/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.49.ProductTitle",
        "https://www.bol.com/nl/nl/p/data-driven-science-and-engineering/9300000077048186/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.54.ProductTitle",
        "https://www.bol.com/nl/nl/p/the-hundred-page-machine-learning-book/9200000105671695/?bltgh=unRaB59O0RSt5rySBhhPSw.2_18.60.ProductTitle"
        "https://www.bol.com/nl/nl/p/feedback-geven-en-krijgen/9300000005855481/?bltgh=m-jLcSvEFgYKYAqT0fNAeQ.iDLWdYGPbAe37h7YrYZL1g_0_4.5.ProductTitle",
        "https://www.bol.com/nl/nl/p/trainershandleiding-feedback-geven-en-ontvangen/9200000107559737/?bltgh=iDJWw-DvamcYinfD9EBPmg.2_6.8.ProductTitle",
        "https://www.bol.com/nl/nl/p/feedback/1001004004817946/?bltgh=iDJWw-DvamcYinfD9EBPmg.2_6.10.ProductTitle",
        "https://www.bol.com/nl/nl/p/kom-maar-op-met-je-feedback/9200000067314843/?bltgh=iDJWw-DvamcYinfD9EBPmg.2_6.15.ProductTitle",
        "https://www.bol.com/nl/nl/p/devops-for-dummies/9200000096954414/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.25.ProductTitle",
        "https://www.bol.com/nl/nl/p/quality-for-devops-teams/9200000132139720/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.21.ProductTitle",
        "https://www.bol.com/nl/nl/p/the-devops-handbook/9300000025764235/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.19.ProductTitle",
        "https://www.bol.com/nl/nl/p/devops-for-the-desperate/9300000069650555/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.29.ProductTitle",
        "https://www.bol.com/nl/nl/p/designing-and-implementing-microsoft-devops-solutions-az-400-exam-guide/9300000113272045/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.27.ProductTitle",
        "https://www.bol.com/nl/nl/p/net-devops-for-azure/9200000123248169/?bltgh=uhmPTZGzQMQnnEnuc35Jyg.2_17.46.ProductTitle"]

for url in ToDo:
    get_json(url)
    time.sleep(2)
    print("added: ", url)