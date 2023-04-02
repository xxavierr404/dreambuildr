import requests as r


def get_page(url: str) -> str:
    return r.get(url).text
