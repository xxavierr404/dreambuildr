import requests as r


def get_page(url: str) -> str:
    while True:
        try:
            return r.get(url).text
        except Exception as e:
            print(e)
