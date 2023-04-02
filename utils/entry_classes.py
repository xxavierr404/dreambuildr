import typing

import bs4
import math
from type_tuples import *
from misc import sizes
from parser_utils import get_page


class ItemEntry:
    name: str
    price: int

    def __init__(self,
                 name_elem: bs4.PageElement,
                 price_elem: bs4.PageElement):
        self.name = name_elem.text
        if not price_elem.text:
            self.price = 0
        else:
            self.price = math.floor(float(price_elem.text.split()[1]) * 70)


class CPUEntry(ItemEntry):
    socket: int
    frequency: float

    def __init__(self,
                 name_elem: bs4.PageElement,
                 price_elem: bs4.PageElement,
                 socket_elem: bs4.PageElement):
        super().__init__(name_elem, price_elem)
        self.socket = socket_tuple.index(socket_elem.text)
        self.frequency = float(socket_elem.find_next('span').text.split()[1])

    def __str__(self):
        return f'{self.name};{self.price};{self.socket};{self.frequency}'


def get_motherboard_ram_info(url: str) -> dict[str: int, str: int]:
    soup: bs4.BeautifulSoup = bs4.BeautifulSoup(get_page(url), 'html.parser')

    info: dict = {}
    ram_info_card: bs4.PageElement = soup.find_all(class_='card-body')[2]
    ram_info_fields: bs4.ResultSet = ram_info_card.findAllNext('dd')
    info['type'] = ram_type_tuple.index(ram_info_fields[0].text)
    info['count'] = int(ram_info_fields[2].text)

    return info


class MotherboardEntry(ItemEntry):
    socket: int
    ram_type: int
    ram_slots_count: int

    def __init__(self,
                 name_elem: bs4.PageElement,
                 price_elem: bs4.PageElement,
                 socket_elem: bs4.PageElement,
                 ram_info: dict):
        super().__init__(name_elem, price_elem)
        self.socket = socket_tuple.index(socket_elem.text)
        self.ram_type = ram_info['type']
        self.ram_slots_count = ram_info['count']

    def __str__(self):
        return f'{self.name};{self.price};{self.socket};{self.ram_type};{self.ram_slots_count}'


class RAMEntry(ItemEntry):
    type: int
    frequency: int
    size: int

    def __init__(self, name_elem: bs4.PageElement,
                 price_elem: bs4.PageElement,
                 type_elem: bs4.PageElement,
                 size_elem: bs4.PageElement):
        super().__init__(name_elem, price_elem)
        self.type = ram_type_tuple.index(type_elem.text.split('-')[0])
        self.frequency = int(type_elem.text.split('-')[1])
        self.size = int(size_elem.text.split()[0])

    def __str__(self):
        return f'{self.name};{self.price};{self.type};{self.frequency};{self.size}'


class DriveEntry(ItemEntry):
    type: int
    size: int

    def __init__(self,
                 name_elem: bs4.PageElement,
                 price_elem: bs4.PageElement,
                 size_elem: bs4.PageElement):
        super().__init__(name_elem, price_elem)
        self.size = int(size_elem.text.split()[0]) * sizes[size_elem.text.split()[1]]
        type_elem: bs4.PageElement = size_elem.find_next_sibling('span')
        if 'rpm' in type_elem.find_next('span')['class']:
            self.type = 2
        else:
            type_elem = type_elem.find_next_sibling('span')
            self.type = drive_type_tuple.index(type_elem.text.split()[0])

    def __str__(self):
        return f'{self.name};{self.price};{self.type};{self.size}'
